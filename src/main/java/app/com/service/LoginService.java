package app.com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.com.dao.LoginDaoInterface;
import app.com.pojos.Admin;
import app.com.pojos.EventManager;
import app.com.pojos.User;

@Service
@Transactional
public class LoginService implements LoginServiceInterface {

	@Autowired
	private LoginDaoInterface loginDao;
	
	@Override
	public void registerUser(User user) {
		loginDao.registerUser(user);

	}

	@Override
	public User verifyLogin(String email, String password) {
		// TODO Auto-generated method stub
		return loginDao.verifyLogin(email, password);
	}

	@Override
	public Admin checkAdmin() {
		// TODO Auto-generated method stub
		return loginDao.checkAdmin();
	}

	@Override
	public void registerAdmin(Admin admin1) {
		// TODO Auto-generated method stub
		loginDao.registerAdmin(admin1);
	}

	@Override
	public Admin verifyAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return loginDao.verifyAdmin(email, password);
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return loginDao.checkEmail(email);
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return loginDao.getUser(email);
	}

	@Override
	public String changePassword(User user, String encryptedPassword) {
		// TODO Auto-generated method stub
		return loginDao.changePassword(user, encryptedPassword);
	}

	@Override
	public EventManager verifyEventManger(String email, String password) {
		// TODO Auto-generated method stub
		return loginDao.verifyEventManger(email, password);
	}

	@Override
	public void updatePassword(EventManager em, String password) {
		// TODO Auto-generated method stub
		loginDao.updatePassword(em, password);
	}

	@Override
	public void saveManger(EventManager em) {
		// TODO Auto-generated method stub
		loginDao.saveManger(em);
	}

}
