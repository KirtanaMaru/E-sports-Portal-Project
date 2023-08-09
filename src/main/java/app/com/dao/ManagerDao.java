package app.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import app.com.pojos.Credendials;
import app.com.pojos.Event;
import app.com.pojos.EventApplications;
import app.com.pojos.EventManager;
import app.com.pojos.User;

@Repository
public class ManagerDao implements ManagerDaoInterface {

	@Autowired
	private EntityManager mgr;

	@Override
	public String saveEvent(Event e) {
		mgr.persist(e);
		return "Event Saved Successfully";
	}

	@Override
	public List<EventApplications> fetchMyEvents(EventManager manager) {
		try {
			EventManager user1 = mgr.find(EventManager.class, manager.getId());
			String jpql = "select c from EventApplications c where c.manager=:user and c.status=:status";
			List<EventApplications> list = mgr.createQuery(jpql, EventApplications.class).setParameter("user", user1).setParameter("status", "New")
					.getResultList();
			if (list != null)
				return list;
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String acceptRequest(int aid) {
		EventApplications ea=mgr.find(EventApplications.class, aid);
		ea.setStatus("Accepted");
		return "Request is acepted";
	}

	@Override
	public String rejectRequest(int aid) {
		EventApplications ea=mgr.find(EventApplications.class, aid);
		ea.setStatus("Rejected");
		return "Request is Rejected";
	}

	@Override
	public User fetchUserByID(int uid) {
		// TODO Auto-generated method stub
		return mgr.find(User.class, uid);
	}

	@Override
	public List<Credendials> fetchUserCertificate(int uid) {
		try {
			User user = mgr.find(User.class, uid);
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
	

	
}
