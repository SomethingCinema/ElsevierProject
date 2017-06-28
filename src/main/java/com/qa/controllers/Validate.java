package com.qa.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qa.models.Address;
import com.qa.models.Customer;
import com.qa.models.Shipping;

public class Validate {
	public static String validateLogin(String email, String password) {
		// Check if email or password fields are empty
		String msg = "";
		if (email.isEmpty()) {
			msg = "Please enter an email";
		} else if (password.isEmpty()) {
			msg =  "Please enter a password";
		}

		// Validate email
		Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
		Matcher emailMatcher = emailPattern.matcher(email);
		if (!emailMatcher.matches()) {
			msg =  "Please enter a valid email";
		}
		return msg;
	}

	public static String validateRegistration(Customer customer, String agreement) {
		// Validate registration
		String msg = "";
		if (customer.getFirstName().isEmpty()) {
			msg =  "Registration failed - please enter a first name";
		} else if (customer.getLastName().isEmpty()) {
			msg =  "Registration failed - please enter a last name";
		} else if (customer.getEmail().isEmpty()) {
			msg =  "Registration failed - please enter an email";
		} else if (customer.getPassword().isEmpty()) {
			msg =  "Registration failed - please enter a password";
		}

		// Validate email
		Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
		Matcher emailMatcher = emailPattern.matcher(customer.getEmail());
		if (!emailMatcher.matches()) {
			msg =  "Registration failed - please enter a valid email";
		}
		// Validate names
		Pattern namePattern = Pattern.compile("[a-zA-Z]+");
		Matcher firstNameMatcher = namePattern.matcher(customer.getFirstName());
		Matcher lastNameMatcher = namePattern.matcher(customer.getLastName());
		if (!firstNameMatcher.matches() || !lastNameMatcher.matches()) {
			msg =  "Registration failed - please enter alphabetical characters for names";
		}

		// // Validate password
		// Pattern passPattern =
		// Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
		// Matcher passMatcher = passPattern.matcher(customer.getPassword());
		// if (passMatcher.matches()) {
		// String msg = "Registration failed - please enter a password with an
		// uppercase, lowercase, and number";
		// msg =  new ModelAndView("register", "alert", msg);
		// }

		// Check if user agreement box is checked
		if (agreement == null) {
			msg =  "Registration failed - please check the User Agreement box";
		}

		return msg;
	}

	public static String validateAddress(Address address) {
		String msg = "";

		Pattern addressPattern = Pattern.compile("[a-zA-Z0-9.]+");
		Matcher addressMatcher1 = addressPattern.matcher(address.getAddressLine1());
		Matcher addressMatcher2 = addressPattern.matcher(address.getAddressLine2());
		if (!addressMatcher1.matches() || !addressMatcher2.matches()) {
			msg = "Please enter a valid address";
		}

		Pattern cityPattern = Pattern.compile("[a-zA-Z]+");
		Matcher cityMatcher = cityPattern.matcher(address.getCity());
		Matcher stateMatcher = cityPattern.matcher(address.getState());
		Matcher countryMatcher = cityPattern.matcher(address.getCountry());
		if (!cityMatcher.matches()) {
			msg = "Please enter a valid city";
		} else if (!stateMatcher.matches()) {
			msg = "Please enter a valid state";
		} else if (!countryMatcher.matches()) {
			msg = "Please enter a valid country";
		}

		Pattern zipPattern = Pattern.compile("(\\d{5}([-]\\d{4})?)");
		Matcher zipMatcher = zipPattern.matcher(address.getPostcode());
		if (!zipMatcher.matches()) {
			msg = "Please enter a valid zipcode";
		}

		Pattern phonePattern = Pattern.compile("\\d{3}[-]\\d{3}[-]\\d{4}");
		Matcher phoneMatcher = phonePattern.matcher(address.getPostcode());
		if (!phoneMatcher.matches()) {
			msg = "Please enter a valid phone number";
		}
		return msg;
	}

	public static String validateShipping(Shipping address) {
		String msg = "";

		Pattern namePattern = Pattern.compile("[a-zA-Z]+");
		Matcher firstNameMatcher = namePattern.matcher(address.getFirstName());
		Matcher lastNameMatcher = namePattern.matcher(address.getFirstName());
		if (!firstNameMatcher.matches()) {
			msg = "Please enter a valid first name";
		} else if (!lastNameMatcher.matches()) {
			msg = "Please enter a valid last name";
		}

		Pattern addressPattern = Pattern.compile("[a-zA-Z0-9.]+");
		Matcher addressMatcher1 = addressPattern.matcher(address.getAddressLine1());
		Matcher addressMatcher2 = addressPattern.matcher(address.getAddressLine2());
		if (!addressMatcher1.matches() || !addressMatcher2.matches()) {
			msg = "Please enter a valid address";
		}

		Matcher cityMatcher = namePattern.matcher(address.getCity());
		Matcher stateMatcher = namePattern.matcher(address.getState());
		Matcher countryMatcher = namePattern.matcher(address.getCountry());
		if (!cityMatcher.matches()) {
			msg = "Please enter a valid city";
		} else if (!stateMatcher.matches()) {
			msg = "Please enter a valid state";
		} else if (!countryMatcher.matches()) {
			msg = "Please enter a valid country";
		}

		Pattern zipPattern = Pattern.compile("(\\d{5}([-]\\d{4})?)");
		Matcher zipMatcher = zipPattern.matcher(address.getPostcode());
		if (!zipMatcher.matches()) {
			msg = "Please enter a valid zipcode";
		}

		Pattern phonePattern = Pattern.compile("\\d{3}[-]\\d{3}[-]\\d{4}");
		Matcher phoneMatcher = phonePattern.matcher(address.getPostcode());
		if (!phoneMatcher.matches()) {
			msg = "Please enter a valid phone number";
		}

		// Validate email
		Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
		Matcher emailMatcher = emailPattern.matcher(address.getEmail());
		if (!emailMatcher.matches()) {
			msg =  "Please enter a valid email";
		}

		return msg;
	}
}
