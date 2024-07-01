package seleniumsessions;

import com.github.javafaker.Faker;

public class FakeData {
	
	 public static void main(String[] args) {
	      // Create a Faker instance
	      Faker faker = new Faker();

	      System.out.println(faker.name().fullName());
	      System.out.println(faker.phoneNumber().cellPhone());
	      System.out.println(faker.address().fullAddress());
	      System.out.println(faker.date().birthday());
	      System.out.println(faker.company().name());

	      System.out.println(faker.name().fullName());
	      System.out.println(faker.phoneNumber().cellPhone());
	      System.out.println(faker.address().fullAddress());
	      System.out.println(faker.date().birthday());
	      System.out.println(faker.company().name());

	      System.out.println(faker.name().fullName());
	      System.out.println(faker.phoneNumber().cellPhone());
	      System.out.println(faker.address().fullAddress());
	      System.out.println(faker.date().birthday());
	      System.out.println(faker.company().name());

	   }

}
