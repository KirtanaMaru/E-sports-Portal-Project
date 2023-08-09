package app.com.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.com.pojos.AcadmeyDetails;
import app.com.pojos.Event;
import app.com.pojos.EventManager;
import app.com.pojos.Order;
import app.com.pojos.Product;
import app.com.pojos.User;

@Repository
public class AdminDao implements AdminDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public List<User> fetchAllUsers() {
		return mgr.createQuery("Select u from User u", User.class).getResultList();
	}

	@Override
	public String addProduct(Product product) {
		mgr.persist(product);
		return "Product Added Successfully";
	}

	@Override
	public List<Product> fetchProducts() {
		List<Product> list = mgr.createQuery("select p from Product p", Product.class).getResultList();
		List<Product> list1 = new ArrayList<>();
		for (Product p : list) {
			if (p.getStock() != 0) {
				list1.add(p);
			}
		}
		return list1;
	}
	@Override
	public Product fetchProductByID(int pid) {
		return mgr.find(Product.class, pid);
	}

	@Override
	public String updateProduct(int id, String category, String name, String brand, String title, int stock,
			double price, String description, String mdate, String warrenty, String mname, String dimension,
			String color, String weight, byte[] imageFile) {
		Product p = mgr.find(Product.class, id);
		p.setBrand(brand);
		p.setCategory(category);
		p.setColor(color);
		p.setDescription(description);
		p.setImage(imageFile);
		p.setMdate(mdate);
		p.setMname(mname);
		p.setName(name);
		p.setPrice(price);
		p.setStock(stock);
		p.setTitle(title);
		p.setWarrenty(warrenty);
		p.setWeight(weight);
		return "product details updated";
	}

	@Override
	public List<Order> fetchAllOrders() {
		String jpql="Select o from Order o";
		return mgr.createQuery(jpql, Order.class).getResultList();
	}

	@Override
	public void toggleOrder(int oid) {
		Order order=mgr.find(Order.class, oid);
		String status=order.getStatus();
		if(status.equals("Placed")) {
			order.setStatus("Confirmed");
		}else if(status.equals("Confirmed")) {
			order.setStatus("Shipping");
		}else if(status.equals("Shipping")) {
			order.setStatus("Out For Dilivery");
		}else if(status.equals("Out For Dilivery")) {
			order.setStatus("Delivered");
		}else {
			order.setStatus("Completed");
		}
		
	}

	@Override
	public List<Product> fetchProductsByCat(String category) {
		List<Product> list = mgr.createQuery("select p from Product p where p.category=:cat", Product.class).setParameter("cat", category).getResultList();
		List<Product> list1 = new ArrayList<>();
		for (Product p : list) {
			if (p.getStock() != 0) {
				list1.add(p);
			}
		}
		return list1;	}
	 public static List<String> removeDuplicates(List<String> list)
	    {
	  
	        List<String> newList = new ArrayList<>();
	  
	        for (String element : list) {
	  
	        
	            if (!newList.contains(element)) {
	  
	                newList.add(element);
	            }
	        }
	  
	        return newList;
	    }
	@Override
	public List<String> fetchCategories() {
		List<Product> list = mgr.createQuery("select p from Product p", Product.class).getResultList();
		List<String> list1 = new ArrayList<>();
		for (Product p : list) {
			list1.add(p.getCategory());
		}
		List<String> list2 = AdminDao.removeDuplicates(list1);
		return list2;
	}

	@Override
	public String addAcadmy(AcadmeyDetails ad) {
		mgr.persist(ad);
		return "Academy Details Added Successfully";
	}

	@Override
	public String registerManager(EventManager em) {
		mgr.persist(em);
		return "Event Manager Registered Successfully";
	}

	@Override
	public List<Event> fetchALlEvents() {
		String jpql="Select e from Event e";
		return mgr.createQuery(jpql, Event.class).getResultList();
	}

	@Override
	public Event fetchEventByID(int eid) {
		
		return mgr.find(Event.class, eid);
	}

	@Override
	public String toggleUserStatus(int uid) {
		User user=mgr.find(User.class, uid);
		String status=user.getStatus();
		if(status.equals("Active")) {
			user.setStatus("Inactive");
			return "User Inactivated";
		}else if(status.equals("Inactive")) {
			user.setStatus("Active");
			return "User Reactivated";
		}else {
			user.setStatus("Active");
			return null;
		}
	}


}
