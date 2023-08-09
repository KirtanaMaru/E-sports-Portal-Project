package app.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.com.dao.UserDaoInterface;
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

@Service
@Transactional
public class UserService implements UserServiceInterface {

	@Autowired
	private UserDaoInterface userDao;
	@Override
	public String updateMyProfile(User user, String full_name, String mobile, String email, Addresses add) {
		// TODO Auto-generated method stub
		return userDao.updateMyProfile(user, full_name, mobile, email, add);
	}
	@Override
	public String changePassword(User u, String conpassword) {
		// TODO Auto-generated method stub
		return userDao.changePassword(u, conpassword);
	}
	@Override
	public String addQualifaction(User u, SSCDetails ssc, HSCDetials hsc, GraduationDetails ug,
			PostGraduationDetails pg) {
		// TODO Auto-generated method stub
		return userDao.addQualifaction(u, ssc, hsc, ug, pg);
	}
	@Override
	public String buyProduct(User u, Product product, Payment pay) {
		// TODO Auto-generated method stub
		return userDao.buyProduct(u, product, pay);
	}
	@Override
	public List<Order> fetchMyOrders(User u) {
		// TODO Auto-generated method stub
		return userDao.fetchMyOrders(u);
	}
	@Override
	public String addCertificate(User u, Credendials certify) {
		// TODO Auto-generated method stub
		return userDao.addCertificate(u, certify);
	}
	@Override
	public List<Credendials> fetchUserCertificate(User u) {
		// TODO Auto-generated method stub
		return userDao.fetchUserCertificate(u);
	}
	@Override
	public List<AcadmeyDetails> fetchClg() {
		// TODO Auto-generated method stub
		return userDao.fetchClg();
	}
	@Override
	public String applyEvent(EventApplications ea) {
		// TODO Auto-generated method stub
		return userDao.applyEvent(ea);
	}
	@Override
	public List<EventApplications> fetchMyApplications(User user) {
		// TODO Auto-generated method stub
		return userDao.fetchMyApplications(user);
	}

}
