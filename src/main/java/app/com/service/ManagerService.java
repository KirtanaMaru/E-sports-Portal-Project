package app.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.com.dao.ManagerDaoInterface;
import app.com.pojos.Credendials;
import app.com.pojos.Event;
import app.com.pojos.EventApplications;
import app.com.pojos.EventManager;
import app.com.pojos.User;

@Service
@Transactional
public class ManagerService implements ManagerServiceInterface {

	@Autowired
	private ManagerDaoInterface managerDao;

	@Override
	public String saveEvent(Event e) {
		// TODO Auto-generated method stub
		return managerDao.saveEvent(e);
	}

	@Override
	public List<EventApplications> fetchMyEvents(EventManager manager) {
		// TODO Auto-generated method stub
		return managerDao.fetchMyEvents(manager);
	}

	@Override
	public String acceptRequest(int aid) {
		// TODO Auto-generated method stub
		return managerDao.acceptRequest(aid);
	}

	@Override
	public String rejectRequest(int aid) {
		// TODO Auto-generated method stub
		return managerDao.rejectRequest(aid);
	}

	@Override
	public User fetchUserByID(int uid) {
		// TODO Auto-generated method stub
		return managerDao.fetchUserByID(uid);
	}

	@Override
	public List<Credendials> fetchUserCertificate(int uid) {
		// TODO Auto-generated method stub
		return managerDao.fetchUserCertificate(uid);
	}
}
