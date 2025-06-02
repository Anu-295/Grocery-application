package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker = new Faker();

	public String generateName() {
		return faker.name().fullName();
	}

	public String generateAdress() {
		return faker.address().fullAddress();
	}

	public String generatephoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public String generateEmailID() {
		return faker.internet().emailAddress();
	}

	public String generateProfession() {
		return faker.company().profession();
	}

	public String generateCompanyName() {
		return faker.company().name();
	}

}
