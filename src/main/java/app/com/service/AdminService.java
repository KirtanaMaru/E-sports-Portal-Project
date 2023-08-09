package app.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import app.com.dao.AdminDaoInterface;
import app.com.pojos.AcadmeyDetails;
import app.com.pojos.Event;
import app.com.pojos.EventManager;
import app.com.pojos.Order;
import app.com.pojos.Product;
import app.com.pojos.User;

@Service
@Transactional
public class AdminService implements AdminServiceInterface {

	@Autowired
	private AdminDaoInterface adminDao;
	@Override
	public List<User> fetchAllUsers() {
		// TODO Auto-generated method stub
		return adminDao.fetchAllUsers();
	}
	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		return adminDao.addProduct(product);
	}
	@Override
	public List<Product> fetchProducts() {
		// TODO Auto-generated method stub
		return adminDao.fetchProducts();
	}
	@Override
	public Product fetchProductByID(int pid) {
		// TODO Auto-generated method stub
		return adminDao.fetchProductByID(pid);
	}

	@Override
	public String updateProduct(int id, String category, String name, String brand, String title, int stock,
			double price, String description, String mdate, String warrenty, String mname, String dimension,
			String color, String weight, byte[] imageFile) {
		// TODO Auto-generated method stub
		return adminDao.updateProduct(id, category, name, brand, title, stock, price, description, mdate, warrenty, mname, dimension, color, weight, imageFile);
	}
	@Override
	public List<Order> fetchAllOrders() {
		// TODO Auto-generated method stub
		return adminDao.fetchAllOrders();
	}
	@Override
	public void toggleOrder(int oid) {
		// TODO Auto-generated method stub
		adminDao.toggleOrder(oid);
	}
	@Override
	public List<Product> fetchProductsByCat(String category) {
		// TODO Auto-generated method stub
		return adminDao.fetchProductsByCat(category);
	}
	@Override
	public List<String> fetchCategories() {
		// TODO Auto-generated method stub
		return adminDao.fetchCategories();
	}
	@Override
	public String addAcadmy(AcadmeyDetails ad) {
		// TODO Auto-generated method stub
		return adminDao.addAcadmy(ad);
	}
	@Override
	public String registerManager(EventManager em) {
		// TODO Auto-generated method stub
		return adminDao.registerManager(em);
	}
	@Override
	public List<Event> fetchALlEvents() {
		// TODO Auto-generated method stub
		return adminDao.fetchALlEvents();
	}
	@Override
	public Event fetchEventByID(int eid) {
		// TODO Auto-generated method stub
		return adminDao.fetchEventByID(eid);
	}
	@Override
	public String toggleUserStatus(int uid) {
		// TODO Auto-generated method stub
		return adminDao.toggleUserStatus(uid);
	}

}
