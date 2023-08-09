package app.com.utility;

import java.util.Random;

public class Utility {

	public static final int EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH, PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH;
	public static final String SYMBOL_ONE, SYMBOL_TWO;

	static {
		EMAIL_MIN_LENGTH = 9;
		EMAIL_MAX_LENGTH = 50;
		PASSWORD_MIN_LENGTH = 8;
		PASSWORD_MAX_LENGTH = 20;
		SYMBOL_ONE = "@";
		SYMBOL_TWO = ".com";
	}

	public static boolean validateEmail(String email) {
		if (!(email.length() > EMAIL_MIN_LENGTH && email.length() < EMAIL_MAX_LENGTH && email.contains(SYMBOL_ONE)
				&& email.endsWith(SYMBOL_TWO))) {
			return false;

		}
		return true;
	}

	/*
	 * public static boolean validateDublicateEmail(String email,
	 * ArrayList<Customer> list) throws CustomerHandlingException { for (Customer c
	 * : list) { if (c != null && email.equals(c.getEmail())) { return false; } }
	 * return true; }
	 */

	public static boolean ValidatePassword(String password) {
		if (password.length() < PASSWORD_MIN_LENGTH || password.length() > PASSWORD_MAX_LENGTH)
			return false;
		else if (!password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})"))
			return false;
		return true;
	}

	public static int generateOTP() {
		String digits = "0123456789";
		Random random_method = new Random();
		char[] otpchar = new char[5];
		String otp = "";
		for (int i = 0; i < 5; i++) {
			otpchar[i] = digits.charAt(random_method.nextInt(digits.length()));
			otp = otp + otpchar[i];
		}
		return Integer.parseInt(otp);
	}

}
