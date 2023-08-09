package app.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.com.pojos.Addresses;
import app.com.pojos.Admin;
import app.com.pojos.EventManager;
import app.com.pojos.GraduationDetails;
import app.com.pojos.HSCDetials;
import app.com.pojos.PostGraduationDetails;
import app.com.pojos.SSCDetails;
import app.com.pojos.User;

@Repository
public class LoginDao implements LoginDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public void registerUser(User user) {
		User u = user;
		Addresses add = new Addresses();
		u.setUserAddress(add);
		SSCDetails ssc = new SSCDetails();
		u.setSscDetails(ssc);
		HSCDetials hsc = new HSCDetials();
		u.setHscDetails(hsc);
		GraduationDetails ug = new GraduationDetails();
		u.setgDetails(ug);
		PostGraduationDetails pg = new PostGraduationDetails();
		u.setPgDetails(pg);
		mgr.persist(u);

	}

	@Override
	public User verifyLogin(String email, String password) {
		try {

			String jpql = "select u from User u where u.email=:email and u.password=:password";
			User user = mgr.createQuery(jpql, User.class).setParameter("email", email)
					.setParameter("password", password).getSingleResult();
			if (user != null && !user.getStatus().equals("Revoked"))
				return user;
			return null;

		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	@Override
	public Admin checkAdmin() {
		try {
			String jpql = "select a from Admin a";
			Admin a = mgr.createQuery(jpql, Admin.class).getSingleResult();
			if (a != null)
				return a;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void registerAdmin(Admin admin1) {
		mgr.persist(admin1);

	}

	@Override
	public Admin verifyAdmin(String email, String password) {
		try {

			String jpql = "select u from Admin u where u.email=:email and u.password=:password";
			Admin user = mgr.createQuery(jpql, Admin.class).setParameter("email", email)
					.setParameter("password", password).getSingleResult();
			if (user != null)
				return user;
			return null;

		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	@Override
	public boolean checkEmail(String email) {
		try {
			String jpql = "select u from User u where u.email=:email";
			User user = mgr.createQuery(jpql, User.class).setParameter("email", email).getSingleResult();
			if (user != null)
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User getUser(String email) {
		try {
			String jpql = "select u from User u where u.email=:email";
			User user = mgr.createQuery(jpql, User.class).setParameter("email", email).getSingleResult();
			if (user != null)
				return user;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String changePassword(User user, String encryptedPassword) {
		User u=mgr.find(User.class, user.getId());
		u.setPassword(encryptedPassword);
		return "Your Password is Changed !!";
	}

	@Override
	public EventManager verifyEventManger(String email, String password) {
		try {

			String jpql = "select u from EventManager u where u.email=:email and u.password=:password";
			EventManager user = mgr.createQuery(jpql, EventManager.class).setParameter("email", email)
					.setParameter("password", password).getSingleResult();
			if (user != null && !user.getStatus().equals("Revoked"))
				return user;
			return null;

		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	@Override
	public void updatePassword(EventManager em, String password) {
		EventManager em1=mgr.find(EventManager.class, em.getId());
		
		em1.setPassword(password);
		em1.setStatus("Active");
		
	}

	@Override
	public void saveManger(EventManager em) {
		// TODO Auto-generated method stub
		mgr.persist(em);
	}

}
