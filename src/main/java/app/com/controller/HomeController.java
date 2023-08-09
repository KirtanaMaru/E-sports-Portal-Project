package app.com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.com.pojos.Admin;
import app.com.pojos.EventManager;
import app.com.pojos.User;
import app.com.service.LoginServiceInterface;
import app.com.utility.AESUtils;
import app.com.utility.OTPSender;
import app.com.utility.Utility;

@Controller
@RequestMapping("/")
public class HomeController {
	final String secretKey = "JHKLXABYZC!!!!";
	@Autowired
	private LoginServiceInterface loginService;

	public HomeController() {
		System.out.println("in const of " + getClass().getName());
	}

	@GetMapping("/")
	public String showHomePage() {
		Admin admin = loginService.checkAdmin();
		if (admin != null) {
		} else {
			Admin admin1 = new Admin("Super User", "admin@gmail.com", "admin", "9860388909");
			loginService.registerAdmin(admin1);
		}
		return "/index";
	}

	@PostMapping("/signup")
	public String processRegister(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			@RequestParam String cpassword, HttpSession hs, RedirectAttributes flashMap, Model modelMap) {
		String encryptedPassword = AESUtils.encrypt(password, secretKey);
		if (Utility.ValidatePassword(password)) {
			if (password.equals(cpassword)) {
				User user = new User(name, email, encryptedPassword, "New");
				loginService.registerUser(user);
				return "redirect:/";
			} else {
				modelMap.addAttribute("error", "Password MissMatched");
				return "/index2";
			}
		} else {
			modelMap.addAttribute("error", "Please Provide Strong Password");
			return "/index2";
		}
	}

	@PostMapping("/login")
	public String processLogin(@RequestParam String email, @RequestParam String password, HttpSession hs,
			RedirectAttributes flashMap, Model modelMap) {
		String encryptedPassword = AESUtils.encrypt(password, secretKey);
		User user = loginService.verifyLogin(email, encryptedPassword);
		Admin admin = loginService.verifyAdmin(email, password);
		EventManager em = loginService.verifyEventManger(email, password);
		if (user != null) {
			if (user.getStatus().equals("Active")) {
				hs.setAttribute("userDetails", user);
				return "redirect:/User/Dashboard";
			} else if (user.getStatus().equals("Inactive")) {
				flashMap.addFlashAttribute("message", "Your Profile is locked");
				return "redirect:/";
			} else {
				flashMap.addFlashAttribute("success", "Please Update Your Profile To Activate Your Profile");
				hs.setAttribute("userDetails", user);
				return "redirect:/User/myprofile";
			}
		} else if (admin != null) {
			hs.setAttribute("userDetails", admin);
			return "redirect:/Admin/Dashboard";
		} else if (em != null) {
			if (em.getStatus().equals("Active")) {
				hs.setAttribute("userDetails", em);
				return "redirect:/Manager/Dashboard";
			} else {
				flashMap.addFlashAttribute("success", "Please Update Your Profile To Activate Your Profile");
				hs.setAttribute("userDetails", em);
				return "redirect:/Manager/updatePassword";
			}
		} else {
			flashMap.addFlashAttribute("message", "Invallid Login");
			return "redirect:/";
		}
	}

	@GetMapping("/index2")
	public String showSignUp() {
		return "/index2";
	}

	@GetMapping("/logout")
	public String logout(HttpSession hs) {
		hs.getAttribute("userDetails");
		hs.invalidate();
		return "redirect:/";
	}

	@GetMapping("/forget_Password")
	public String showForgetPassword() {
		return "/forget_Password";
	}

	@PostMapping("/sendotp")
	public String sendOTP(@RequestParam String email, HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		hs.setAttribute("email", email);
		hs.setAttribute("user", loginService.getUser(email));
		if (loginService.checkEmail(email)) {
			int otp = Utility.generateOTP();
			hs.setAttribute("otp", otp);
			OTPSender op = new OTPSender();
			op.sendEmail(email, otp);

		} else {
			flashMap.addFlashAttribute("error", "Email Is Not Registered");
		}
		return "redirect:/forget_Password";
	}

	@PostMapping("/verifyotp")
	public String verifyOTP(@RequestParam int otp, HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		int otp1 = (int) hs.getAttribute("otp");
		if (otp1 != otp) {
			flashMap.addFlashAttribute("error", "Invalid OTP");
			return "redirect:/forget_Password";
		} else {
			return "redirect:/change_password";
		}
	}

	@GetMapping("/change_password")
	public String showChangePassword() {
		return "/change_password";
	}

	@PostMapping("/changePassowrd")
	public String changePassword(@RequestParam String npassword, @RequestParam String cpassword, Model modelMap,
			RedirectAttributes flashMap, HttpSession hs) {

		if (!npassword.equals(cpassword)) {
			flashMap.addFlashAttribute("error", "Password Not Matched");
		} else {
			if (Utility.ValidatePassword(cpassword)) {
				User user = (User) hs.getAttribute("user");
				String encryptedPassword = AESUtils.encrypt(cpassword, secretKey);
				flashMap.addFlashAttribute("message", loginService.changePassword(user, encryptedPassword));
				return "redirect:/";
			} else {
				flashMap.addFlashAttribute("error", "Please Provide Strong Password");
			}
		}
		return "redirect:/change_password";
	}

	@GetMapping("/manager_registration")
	public String showManigerRegistration() {

		return "/manager_registration";
	}

	@PostMapping("/managerSignup")
	public String registerManger(@RequestParam String email, @RequestParam String name, @RequestParam String password) {
		EventManager em = new EventManager(email, name, password, "Active");
		loginService.saveManger(em);
		return "redirect:/";

	}
}
