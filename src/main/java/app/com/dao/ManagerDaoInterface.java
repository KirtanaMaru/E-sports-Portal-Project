package app.com.dao;

import java.util.List;

import app.com.pojos.Credendials;
import app.com.pojos.Event;
import app.com.pojos.EventApplications;
import app.com.pojos.EventManager;
import app.com.pojos.User;

public interface ManagerDaoInterface {

	String saveEvent(Event e);

	List<EventApplications> fetchMyEvents(EventManager manager);

	String acceptRequest(int aid);

	String rejectRequest(int aid);

	User fetchUserByID(int uid);

	List<Credendials> fetchUserCertificate(int uid);

}
