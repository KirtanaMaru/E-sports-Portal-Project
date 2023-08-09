package app.com.service;

import app.com.pojos.Admin;
import app.com.pojos.EventManager;
import app.com.pojos.User;

public interface LoginServiceInterface {

	void registerUser(User user);

	User verifyLogin(String email, String password);

	Admin checkAdmin();

	void registerAdmin(Admin admin1);

	Admin verifyAdmin(String email, String password);

	boolean checkEmail(String email);

	User getUser(String email);

	String changePassword(User user, String encryptedPassword);

	EventManager verifyEventManger(String email, String password);

	void updatePassword(EventManager em, String password);

	void saveManger(EventManager em);

}
