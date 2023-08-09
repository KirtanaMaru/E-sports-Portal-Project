package app.com.service;

import java.util.List;

import app.com.pojos.AcadmeyDetails;
import app.com.pojos.Event;
import app.com.pojos.EventManager;
import app.com.pojos.Order;
import app.com.pojos.Product;
import app.com.pojos.User;

public interface AdminServiceInterface {

	List<User> fetchAllUsers();

	String addProduct(Product product);

	List<Product> fetchProducts();
	Product fetchProductByID(int pid);

	String updateProduct(int id, String category, String name, String brand, String title, int stock, double price,
			String description, String mdate, String warrenty, String mname, String dimension, String color,
			String weight, byte[] imageFile);

	List<Order> fetchAllOrders();

	void toggleOrder(int oid);

	List<Product> fetchProductsByCat(String category);

	List<String> fetchCategories();

	String addAcadmy(AcadmeyDetails ad);

	String registerManager(EventManager em);

	List<Event> fetchALlEvents();

	Event fetchEventByID(int eid);

	String toggleUserStatus(int uid);


}
