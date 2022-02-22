package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator
		extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

	static CustomerRegistrationValidator isEmailValid() {
		return customer -> customer.getEmail().contains("@") ? ValidationResult.SUCCESS
				: ValidationResult.EMAIL_NOT_VALID;
	}

	static CustomerRegistrationValidator isPhoneNumberValid() {
		return customer -> customer.getPhoneNumber().startsWith("+0") ? ValidationResult.SUCCESS
				: ValidationResult.PHONE_NUMBER_NOT_VALID;
	}

	static CustomerRegistrationValidator isAnAdult() {
		return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ? ValidationResult.SUCCESS
				: ValidationResult.PHONE_NUMBER_NOT_VALID;
	}
	
	default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
		};
	}

	enum ValidationResult {
		SUCCESS, PHONE_NUMBER_NOT_VALID, EMAIL_NOT_VALID, IS_NOT_AN_ADULT;
	}
}
