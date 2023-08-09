package app.com.service;

import java.util.List;

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

public interface UserServiceInterface {

	String updateMyProfile(User user, String full_name, String mobile, String email, Addresses add);

	String changePassword(User u, String conpassword);

	String addQualifaction(User u, SSCDetails ssc, HSCDetials hsc, GraduationDetails ug, PostGraduationDetails pg);

	String buyProduct(User u, Product product, Payment pay);

	List<Order> fetchMyOrders(User u);

	String addCertificate(User u, Credendials certify);

	List<Credendials> fetchUserCertificate(User u);

	List<AcadmeyDetails> fetchClg();

	String applyEvent(EventApplications ea);

	List<EventApplications> fetchMyApplications(User user);

}
