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

import app.com.pojos.AcadmeyDetails;
import app.com.pojos.EventManager;
import app.com.pojos.Product;
import app.com.service.AdminServiceInterface;
import app.com.utility.PasswordSender;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AdminServiceInterface adminService;

	public AdminController() {
		System.out.println("In Constr of " + getClass().getName());
	}

	@GetMapping("/Dashboard")
	public String showAdminDashboard() {
		return "/Admin/Dashboard";
	}

	@GetMapping("/availableuser")
	public String showAvailabeUsers(HttpSession hs) {
		hs.setAttribute("userList", adminService.fetchAllUsers());
		return "/Admin/availableuser";
	}

	@GetMapping("/addProduct")
	public String showAddProduct() {
		return "/Admin/addProduct";
	}

	@GetMapping("/viewProduct")
	public String showViewProduct(HttpSession hs) {
		hs.setAttribute("productList", adminService.fetchProducts());
		return "/Admin/viewProduct";
	}

	@PostMapping("/add_product")
	public String saveProduct(@RequestParam String category, @RequestParam String name, @RequestParam String brand,
			@RequestParam String title, @RequestParam String stock, @RequestParam String price,
			@RequestParam String description, @RequestParam String mdate, @RequestParam String warrenty,
			@RequestParam String mname, @RequestParam String dimension, @RequestParam String color,
			@RequestParam String weight, @RequestParam MultipartFile image, RedirectAttributes flashMap)
			throws IOException {
		System.out.println("category "+category+" Stocks "+stock+" price "+price);
		if (!(category.equals("") && stock.equals("") && price.equals(""))) {
			byte[] imageFile = image.getBytes();
			Product product = new Product(category, name, brand, title, Integer.parseInt(stock),
					Double.parseDouble(price), description, mdate, warrenty, mname, dimension, color, weight,
					imageFile);
			flashMap.addFlashAttribute("message", adminService.addProduct(product));
			return "redirect:/Admin/addProduct";
		} else {
			flashMap.addFlashAttribute("message", "Please fill all required details");
			return "redirect:/Admin/addProduct";
		}

	}

	@GetMapping("/UpdateProduct")
	public String updateProduct(@RequestParam int pid, HttpSession hs) {
		hs.setAttribute("productDetails", adminService.fetchProductByID(pid));
		return "/Admin/UpdateProduct";

	}

	@PostMapping("/updateProduct")
	public String updateProductDetails(@RequestParam int id, @RequestParam String category, @RequestParam String name,
			@RequestParam String brand, @RequestParam String title, @RequestParam int stock, @RequestParam double price,
			@RequestParam String description, @RequestParam String mdate, @RequestParam String warrenty,
			@RequestParam String mname, @RequestParam String dimension, @RequestParam String color,
			@RequestParam String weight, @RequestParam MultipartFile image, RedirectAttributes flashMap)
			throws IOException {
		byte[] imageFile = image.getBytes();
		flashMap.addFlashAttribute("message", adminService.updateProduct(id, category, name, brand, title, stock, price,
				description, mdate, warrenty, mname, dimension, color, weight, imageFile));
		return "redirect:/Admin/viewProduct";
	}

	@GetMapping("/orderRequests")
	public String showOrderRequests(HttpSession hs) {
		hs.setAttribute("orderList", adminService.fetchAllOrders());
		return "/Admin/orderRequests";
	}

	@GetMapping("toggle_order")
	public String toogleOrder(HttpSession hs, @RequestParam int oid) {
		adminService.toggleOrder(oid);
		return "redirect:/Admin/orderRequests";
	}

	@GetMapping("/addAcademy")
	public String showAddAcadmey() {
		return "/Admin/addAcademy";
	}

	@PostMapping("/addAcademy")
	public String addAcademyDetails(@RequestParam String name, @RequestParam String location,
			@RequestParam String established, @RequestParam String sport, @RequestParam String chairman,
			@RequestParam String mobile, @RequestParam MultipartFile image, @RequestParam String map,
			RedirectAttributes flashMap) throws IOException {
		byte[] imageFile = image.getBytes();
		AcadmeyDetails ad = new AcadmeyDetails(name, location, established, sport, chairman, mobile, imageFile, map);
		flashMap.addFlashAttribute("message", adminService.addAcadmy(ad));
		return "redirect:/Admin/addAcademy";
	}

	@GetMapping("/registerManger")
	public String showRegisterManger() {
		return "/Admin/registerManger";
	}

	@PostMapping("/registerManger")
	public String saveRegisterManger(@RequestParam String email, @RequestParam String name, Model modelMap,
			RedirectAttributes flashMap) {
		String password = name.substring(0, 3) + "#986038";
		EventManager em = new EventManager(email, name, password, "New");

		flashMap.addFlashAttribute("message", adminService.registerManager(em));
		PasswordSender ps = new PasswordSender();
		ps.sendEmail(email, password);
		return "redirect:/Admin/registerManger";
	}

	@GetMapping("/user_status")
	public String toggleUser(@RequestParam int uid, HttpSession hs, Model modelMap, RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("message", adminService.toggleUserStatus(uid));
		return "redirect:/Admin/availableuser";
	}
}
