import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Traveller> allTravellers = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Automated Travelling Assistant!");

		//initialize first user
		int age;
		Traveller traveller;
		System.out.print("Provide your age: ");
		age = in.nextInt();
		//check age
		while (age < 16 || age > 130) {
			System.out.println("Invalid age!");
			System.out.print("Provide your age: ");
			age = in.nextInt();
		}
		if (age >= 16 && age <= 25) {
			traveller = new YoungTraveller(age);

		} else if (age > 25 && age <= 60) {
			traveller = new MiddleTraveller(age);

		}else {
			traveller = new ElderTraveller(age);

		}
		allTravellers.add(traveller);
		System.out.print("Provide your city of residence: ");
		in.nextLine();
		String city = in.nextLine();

		traveller.setGeodesic_pref(City.retrieveData(city, "7ee00d1719bab23e58e8acfad960fa89"));
		System.out.println(traveller.getGeodesic_pref()[0]);

		System.out.println("Option 1\n" + "Option 2\n" + "Option 3\n");
		int choice = in.nextInt();
		switch (choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
		}
	}

}
