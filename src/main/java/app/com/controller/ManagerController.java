package app.com.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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

import app.com.pojos.Event;
import app.com.pojos.EventManager;
import app.com.pojos.User;
import app.com.service.AdminServiceInterface;
import app.com.service.LoginServiceInterface;
import app.com.service.ManagerServiceInterface;
import app.com.utility.NotifactionSender;

@Controller
@RequestMapping("/Manager")
public class ManagerController {

	@Autowired
	private LoginServiceInterface loginService;
	
	@Autowired
	private ManagerServiceInterface managerService;
	
	@Autowired
	private AdminServiceInterface adminService;

	public ManagerController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/Dashboard")
	public String showDashboard() {
		return "/Manager/Dashboard";
	}

	@GetMapping("/updatePassword")
	public String showUpdatePassword() {
		return "/Manager/updatePassword";
	}

	@PostMapping("/updatePassword")
	public String processPasswordUpdate(@RequestParam String password, @RequestParam String cpassword, HttpSession hs,
			Model modelMap) {
		EventManager em = (EventManager) hs.getAttribute("userDetails");
		loginService.updatePassword(em, password);
		return "redirect:/Manager/Dashboard";
	}

	@GetMapping("/addEvent")
	public String addEvents() {
		return "/Manager/addEvent";
	}

	@PostMapping("/addEvent")
	public String saveEvent(HttpSession hs, Model model, RedirectAttributes flashmap, @RequestParam String title,
			@RequestParam String location, @RequestParam String sport, @RequestParam String date,
			@RequestParam String price, @RequestParam String mobile, @RequestParam String map,
			@RequestParam MultipartFile image) throws IOException {
		byte[] imageFile=image.getBytes();
		EventManager manager=(EventManager) hs.getAttribute("userDetails");
		Event e=new Event(title, location, sport, date, price, mobile, map, imageFile,manager);
		flashmap.addFlashAttribute("message", managerService.saveEvent(e));
		
		return "redirect:/Manager/addEvent";
	}
	
	@GetMapping("/sportApplications")
	public String showApplications(HttpSession hs,Model modelMap) {
		EventManager manager=(EventManager) hs.getAttribute("userDetails");
		hs.setAttribute("applications", managerService.fetchMyEvents(manager));
		return "/Manager/sportApplications";
	}
	@GetMapping("accept")
	public String acceptApplication(@RequestParam int aid,HttpSession hs, Model modelMap,RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("message", managerService.acceptRequest(aid));
		return "redirect:/Manager/sportApplications";
	}
	@GetMapping("/reject")
	public String rejectApplication(@RequestParam int aid,HttpSession hs, Model modelMap,RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("message", managerService.rejectRequest(aid));
		return "redirect:/Manager/sportApplications";
	}
	
	@GetMapping("/showUserAcadmic")
	public String showAcadmic(@RequestParam int uid,HttpSession hs,Model modelMap) {
		hs.setAttribute("u", managerService.fetchUserByID(uid));
		return "/Manager/showUserAcadmic";
	}
	@GetMapping("/showUserCertificate")
	public String showCertificate(@RequestParam int uid,Model modelMap,RedirectAttributes flashMap,HttpSession hs) {
		hs.setAttribute("userCertificateList", managerService.fetchUserCertificate(uid));
		return "/Manager/showUserCertificate";
	}
}
