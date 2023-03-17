package fa.training.util;


public class Validation {

	private final static String VALID_REGEX_PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
	private final static String VALID_REGEX_PHONE = "^[0][0-9]{9}$";
	private final static String VALID_REGEX_EMAIL = "^[a-zA-Z][a-zA-Z0-9\\-_]+@[a-zA-Z]+(\\.[a-zA-z]+){1,3}$";
	private final static String VALID_REGEX_LICENSE = "^[0-9]{2}-[A-Za-z][0-9]\\s[0-9]{4,5}$";
	private final static String VALID_REGEX_AreaAndPrice = "^[0-9]+$";
	// validate password
	public boolean checkPassword(String pass) {
		while (true) {
			if (pass.matches(VALID_REGEX_PASSWORD)) {
				return true;
			} else {
				return false;

			}
		}
	}

	// validate phone
	public boolean checkphone(String phone) {
		while (true) {
			if (phone.matches(VALID_REGEX_PHONE)) {
				return true;
			} else {
				return false;
			}
		}
	}

	// validate email
	public boolean checkEmail(String email) {
		while (true) {
			if (email.matches(VALID_REGEX_EMAIL)) {
				return true;
			} else {
				return false;
			}

		}
	}

	// validate license
	public boolean checkLicense(String license) {
		while (true) {
			if (license.matches(VALID_REGEX_LICENSE)) {
				return true;
			} else {
				return false;
			}

		}
	}
	public boolean PriceAndArea(String phone) {
		while (true) {
			if (phone.matches(VALID_REGEX_AreaAndPrice)) {
				return true;
			} else {
				return false;
			}
		}
	}

}
