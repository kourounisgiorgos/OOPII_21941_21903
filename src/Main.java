import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static final String appid = "7ee00d1719bab23e58e8acfad960fa89";
	static ArrayList<Traveller> allTravellers = new ArrayList<>();
	static ArrayList<City> allCities = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		//hard coded cities
		City Athens = new City("Athens");
		Athens.setTerms_vector(City.calculateTerms(Athens.name, appid));
		Athens.setGeodesic_vector(City.retrieveUnknownGeo("Athens", appid));
		City Paris = new City("Paris");
		Paris.setTerms_vector(City.calculateTerms(Paris.name, appid));
		Paris.setGeodesic_vector(City.retrieveUnknownGeo("Paris", appid));
		City Moscow = new City("Moscow");
		Moscow.setTerms_vector(City.calculateTerms(Moscow.name, appid));
		Moscow.setGeodesic_vector(City.retrieveUnknownGeo("Moscow", appid));

		allCities.add(Athens);
		allCities.add(Paris);
		allCities.add(Moscow);


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

		traveller.setGeodesic_pref(City.retrieveUnknownGeo(city, appid));
		traveller.setTerms_pref();
		System.out.print("Your best match: ");
		System.out.println(traveller.compareCities(allCities).name);
		traveller.compareCities(allCities,3);
	}

}
