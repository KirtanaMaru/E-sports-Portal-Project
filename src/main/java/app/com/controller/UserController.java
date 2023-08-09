package app.com.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.com.pojos.Addresses;
import app.com.pojos.Credendials;
import app.com.pojos.Event;
import app.com.pojos.EventApplications;
import app.com.pojos.EventManager;
import app.com.pojos.GraduationDetails;
import app.com.pojos.HSCDetials;
import app.com.pojos.Payment;
import app.com.pojos.PostGraduationDetails;
import app.com.pojos.Product;
import app.com.pojos.SSCDetails;
import app.com.pojos.User;
import app.com.service.AdminServiceInterface;
import app.com.service.LoginServiceInterface;
import app.com.service.UserServiceInterface;
import app.com.utility.AESUtils;
import app.com.utility.Utility;

@Controller
@RequestMapping("/User")
public class UserController {
	final String secretKey = "JHKLXABYZC!!!!";
	@Autowired
	private UserServiceInterface userService;
	@Autowired
	private LoginServiceInterface loginService;
	@Autowired
	private AdminServiceInterface adminService;

	public UserController() {
		System.out.println("In Constr of " + getClass().getName());
	}

	@GetMapping("/Dashboard")
	public String showUserDashboard(HttpSession hs) {
		hs.setAttribute("eventList", adminService.fetchALlEvents());
		return "/User/Dashboard";
	}

	@GetMapping("/myprofile")
	public String showUserProfile() {
		return "/User/myProfile";
	}

	@PostMapping("/myprofile")
	public String updateMyProfile(@RequestParam String full_name, @RequestParam String mobile,
			@RequestParam String email, @RequestParam String city, @RequestParam String state,
			@RequestParam String district, @RequestParam String add_ln, @RequestParam int pin_code,
			@RequestParam String country, HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		Addresses add = new Addresses(city, mobile, district, state, country, add_ln, pin_code);
		User user = (User) hs.getAttribute("userDetails");
		flashMap.addFlashAttribute("success", userService.updateMyProfile(user, full_name, mobile, email, add));
		hs.setAttribute("userDetails", loginService.verifyLogin(email, user.getPassword()));
		return "redirect:/User/myprofile";
	}

	@GetMapping("/changepassword")
	public String showChangePassword() {
		return "/User/changepassword";
	}

	@PostMapping("/changepassword")
	public String changePassword(@RequestParam String cpassword, @RequestParam String npassword,
			@RequestParam String conpassword, Model modelMap, RedirectAttributes flashMap, HttpSession hs) {
		User u = (User) hs.getAttribute("userDetails");
		String encryptedPassword = AESUtils.encrypt(npassword, secretKey);
		String encryptedPassword1 = AESUtils.encrypt(cpassword, secretKey);
		if (!Utility.ValidatePassword(npassword)) {
			modelMap.addAttribute("success", "Please provide Strong Password");
			return "/User/changepassword";
		} else {
			if (u.getPassword().equals(encryptedPassword1)) {
				if (npassword.equals(cpassword)) {
					modelMap.addAttribute("success", "User Different Password then Previous");
					return "/User/changepassword";
				} else {
					if (npassword.equals(conpassword)) {
						modelMap.addAttribute("success", userService.changePassword(u, encryptedPassword));
						hs.setAttribute("userDetails", loginService.verifyLogin(u.getEmail(), encryptedPassword));
						return "/User/changepassword";
					} else {
						modelMap.addAttribute("success", "new Password and confirm password does not matched");
						return "/User/changepassword";
					}
				}
			} else {
				modelMap.addAttribute("success", "Current Password Does Not Matched");
				return "/User/changepassword";
			}
		}
	}

	@GetMapping("/addQualifaction")
	public String showAddQualifaction() {
		return "/User/addQualifaction";
	}

	@PostMapping("/addQualifaction")
	public String addQualifaction(@RequestParam String name1, @RequestParam String pyear1, @RequestParam String grade1,
			@RequestParam String name, @RequestParam String pyear, @RequestParam String grade,
			@RequestParam String name2, @RequestParam String type, @RequestParam String pyear2,
			@RequestParam String grade2, @RequestParam String name3, @RequestParam String type2,
			@RequestParam String pyear3, @RequestParam String grade3, HttpSession hs, Model modelMap,
			RedirectAttributes flashMap) {
		User u = (User) hs.getAttribute("userDetails");
		SSCDetails ssc = new SSCDetails(name1, pyear1, grade1);
		HSCDetials hsc = new HSCDetials(name, pyear, grade);
		GraduationDetails ug = new GraduationDetails(name2, pyear2, grade2, type);
		PostGraduationDetails pg = new PostGraduationDetails(name3, pyear3, grade3, type2);
		flashMap.addFlashAttribute("success", userService.addQualifaction(u, ssc, hsc, ug, pg));
		hs.setAttribute("userDetails", loginService.verifyLogin(u.getEmail(), u.getPassword()));

		return "redirect:/User/addQualifaction";
	}

	@GetMapping("/shopping")
	public String showShopping(HttpSession hs) {
		hs.setAttribute("productList", adminService.fetchProducts());
		hs.setAttribute("catList", adminService.fetchCategories());
		return "/User/shopping";
	}

	@PostMapping("/searchCat")
	public String showShopping(HttpSession hs, @RequestParam String category) {
		hs.setAttribute("productList", adminService.fetchProductsByCat(category));
		return "/User/shopping";
	}

	@GetMapping("/productd")
	public String showProductDescription(HttpSession hs, @RequestParam int pid) {
		hs.setAttribute("product", adminService.fetchProductByID(pid));
		return "/User/showDescription";
	}

	@GetMapping("/buy")
	public String processBuy(@RequestParam int pid, HttpSession hs, RedirectAttributes flashMap) {

		Product product = adminService.fetchProductByID(pid);
		hs.setAttribute("product", product);
		return "/User/payment";
	}

	@PostMapping("/pay")
	public String processPayment(@RequestParam String name, @RequestParam String cvv, @RequestParam String expDate,
			@RequestParam String cardNo, HttpSession hs, RedirectAttributes flashMap, Model modelMap) {
		User u = (User) hs.getAttribute("userDetails");
		Product product = (Product) hs.getAttribute("product");
		Payment pay = new Payment(cardNo, name, expDate, cvv, "" + product.getPrice());
		flashMap.addFlashAttribute("message", userService.buyProduct(u, product, pay));
		return "redirect:/User/shopingHistory";
	}

	@GetMapping("/shopingHistory")
	public String showHistory(HttpSession hs) {
		User u = (User) hs.getAttribute("userDetails");
		hs.setAttribute("orderList", userService.fetchMyOrders(u));
		return "/User/shoppingHistory";
	}

	@GetMapping("/addCertification")
	public String showAddCertifaction(HttpSession hs) {
		User u = (User) hs.getAttribute("userDetails");
		hs.setAttribute("userCertificateList", userService.fetchUserCertificate(u));
		return "/User/addCertification";
	}

	@PostMapping("/addCertification")
	public String processAddCertifaction(HttpSession hs, Model modelMap, RedirectAttributes flashMap,
			@RequestParam String game, @RequestParam String status, @RequestParam String date,
			@RequestParam MultipartFile image) throws IOException {
		byte[] imageFile = image.getBytes();
		User u = (User) hs.getAttribute("userDetails");
		Credendials certify = new Credendials(game, date, status, imageFile);
		hs.setAttribute("message", userService.addCertificate(u, certify));
		return "redirect:/User/addCertification";
	}

	@GetMapping("/injuryPreduction")
	public String showInjuryPreduction() {
		return "/User/injuryPreduction";
	}

	@PostMapping("/injuryPreduction")
	public String processInjuryPreduction(HttpSession hs, Model modelMap, RedirectAttributes flashMap,
			@RequestParam int age, @RequestParam double weight, @RequestParam double height, @RequestParam String blood,
			@RequestParam double bp, @RequestParam String suger, @RequestParam String blooding,
			@RequestParam String gender) {
		int dayes=0;
		int g=1;
		int bpressure=0;
		int s=0;
		int b=0;
		if(gender.equals("female")) {
			g=g*2;
		}else {
			g=g*1;
		}
		if(bp < 120) {
			bpressure=bpressure+0;
		}else if (bp >= 120 && bp <= 129) {
			bpressure=10;
		}else if (bp >= 130 && bp <= 139) {
			bpressure=20;
		}else if (bp >=140) {
			bpressure=30;
		}else if (bp<80) {
			bpressure=30;
		}else {
			bpressure=1;
		}
		if(suger.equals("Yes")) {
			s=30;
		}else {
			s=5;
		}
		if(blooding.equals("no")) {
			b=1;
		}else if (blooding.equals("swelling")) {
			b=3;
		}else if (blooding.equals("internal")) {
			b=10;
		}else if (blooding.equals("external")) {
			b=15;
		}
		dayes=g+bpressure+s+b;
		if(dayes < 3) {
			modelMap.addAttribute("message1", "Normal Health Condition will recover in 2 day");
		}else if(dayes > 20) {
			modelMap.addAttribute("message1", "Please take care of your health");
			modelMap.addAttribute("message2", "your Injury will recover in "+Math.round(dayes/3)+" dayes approxmetly");
		}else if(dayes > 50) {
			modelMap.addAttribute("message1", "Please take care of your health");
			modelMap.addAttribute("message2", "your Injury will recover in "+Math.round(dayes/4)+" dayes approxmetly");
		}else {
			modelMap.addAttribute("message1", "Please take care of your health");
			modelMap.addAttribute("message2", "your Injury will recover in "+dayes+" dayes approxmetly");
		}
		return "/User/injuryPreduction";
	}
	
	@GetMapping("/showAcademy")
	public String showAcademy(HttpSession hs) {
		hs.setAttribute("clgList", userService.fetchClg());
		return "/User/showAcademy";
	}
	
	@GetMapping("/findSports")
	public String showEvents(HttpSession hs) {
		hs.setAttribute("eventList", adminService.fetchALlEvents());
		return "/User/findSports";
	}
	
	@GetMapping("applySport")
	public String appySport(@RequestParam int eid,HttpSession hs,RedirectAttributes flashMap,Model modelMap) {
		Event event=adminService.fetchEventByID(eid);
		EventManager manager=event.getManager();
		User user=(User) hs.getAttribute("userDetails");
		EventApplications ea=new EventApplications(user, manager, event, "New");
		
		flashMap.addFlashAttribute("message", userService.applyEvent(ea));
		
		return "redirect:/User/showmyapplications";
	}
	
	@GetMapping("/showmyapplications")
	public String showMyApplications(HttpSession hs,Model modelMap) {
		User user=(User) hs.getAttribute("userDetails");
		hs.setAttribute("aList", userService.fetchMyApplications(user));
		return "/User/showmyapplications";
	}
}
