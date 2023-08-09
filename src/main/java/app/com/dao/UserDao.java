package app.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.com.pojos.AcadmeyDetails;
import app.com.pojos.Addresses;
import app.com.pojos.Credendials;
import app.com.pojos.EventApplications;
import app.com.pojos.GraduationDetails;
import app.com.pojos.HSCDetials;
import app.com.pojos.Order;
import app.com.pojos.Payment;
import app.com.pojos.PostGraduationDetails;
import app.com.pojos.Product;
import app.com.pojos.SSCDetails;
import app.com.pojos.User;

@Repository
public class UserDao implements UserDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public String updateMyProfile(User user, String full_name, String mobile, String email, Addresses add) {
		User u = mgr.find(User.class, user.getId());
		u.setEmail(email);
		Addresses a = u.getUserAddress();
		a.setCity(add.getCity());
		a.setCountry(add.getCountry());
		a.setDistrict(add.getDistrict());
		a.setMobileNo(add.getMobileNo());
		a.setPinCode(add.getPinCode());
		a.setState(add.getState());
		a.setStreetLine(add.getStreetLine());
		u.setName(full_name);
		u.setStatus("Active");
		return "User Details Updated Successfully";
	}

	@Override
	public String changePassword(User u, String conpassword) {
		User user = mgr.find(User.class, u.getId());
		user.setPassword(conpassword);
		return "Password Updated Successfully";
	}

	@Override
	public String addQualifaction(User u, SSCDetails ssc, HSCDetials hsc, GraduationDetails ug,
			PostGraduationDetails pg) {
		User user = mgr.find(User.class, u.getId());
		SSCDetails s = user.getSscDetails();
		s.setGrade1(ssc.getGrade1());
		s.setName1(ssc.getName1());
		s.setPyear1(ssc.getPyear1());
		HSCDetials h = user.getHscDetails();
		h.setGrade(hsc.getGrade());
		h.setName(hsc.getName());
		h.setPyear(hsc.getPyear());
		GraduationDetails g = user.getgDetails();
		g.setGrade2(ug.getGrade2());
		g.setName2(ug.getName2());
		g.setPyear2(ug.getPyear2());
		g.setType(ug.getType());
		PostGraduationDetails p = user.getPgDetails();
		p.setGrade3(pg.getGrade3());
		p.setName3(pg.getName3());
		p.setPyear3(pg.getPyear3());
		p.setType2(pg.getType2());
		return "User Qualifaction Added Successfully";
	}

	@Override
	public String buyProduct(User u, Product product, Payment pay) {
		Order o = new Order();
		o.setPay(pay);
		o.setProd(product);
		o.setUser(u);
		o.setStatus("Placed");
		Product p = mgr.find(Product.class, product.getId());
		p.setStock(p.getStock() - 1);
		mgr.persist(o);
		return "Order Placed Successfully";
	}

	@Override
	public List<Order> fetchMyOrders(User u) {
		try {
			String jpql = "select o from Order o where o.user=:user";
			List<Order> list = mgr.createQuery(jpql, Order.class).setParameter("user", u).getResultList();
			if (list != null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String addCertificate(User u, Credendials certify) {
		User user = mgr.find(User.class, u.getId());
		Credendials c = certify;
		c.setUserDetails(user);
		List<Credendials> cList = user.getCertificateList();
		cList.add(c);
		mgr.persist(c);
		return "Certificate Added Successfully";
	}

	@Override
	public List<Credendials> fetchUserCertificate(User u) {
		try {
			User user = mgr.find(User.class, u.getId());
			String jpql = "select c from Credendials c where c.userDetails=:user";
			List<Credendials> list = mgr.createQuery(jpql, Credendials.class).setParameter("user", user)
					.getResultList();
			if (list != null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<AcadmeyDetails> fetchClg() {
		try {
			String jpql = "select a from AcadmeyDetails a";
			List<AcadmeyDetails> list = mgr.createQuery(jpql, AcadmeyDetails.class).getResultList();
			if (list != null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String applyEvent(EventApplications ea) {
		mgr.persist(ea);
		return "Your Application is received";
	}

	@Override
	public List<EventApplications> fetchMyApplications(User user) {
		try {
			User user1 = mgr.find(User.class, user.getId());
			String jpql = "select c from EventApplications c where c.user=:user";
			List<EventApplications> list = mgr.createQuery(jpql, EventApplications.class).setParameter("user", user1)
					.getResultList();
			if (list != null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
