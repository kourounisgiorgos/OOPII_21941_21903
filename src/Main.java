import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static final String appid = "7ee00d1719bab23e58e8acfad960fa89";
    static ArrayList<Traveller> allTravellers = new ArrayList<>();
    static HashMap<String, City> allCities = new HashMap<>();

    public static void main(String[] args) throws IOException {

        //hard coded cities
        City Athens = new City("Athens");
        Athens.setTerms_vector(City.calculateTerms(Athens.getName(), appid));
        Athens.setGeodesic_vector(City.retrieveUnknownGeo("Athens", appid));
        City Paris = new City("Paris");
        Paris.setTerms_vector(City.calculateTerms(Paris.getName(), appid));
        Paris.setGeodesic_vector(City.retrieveUnknownGeo("Paris", appid));
        City Moscow = new City("Moscow");
        Moscow.setTerms_vector(City.calculateTerms(Moscow.getName(), appid));
        Moscow.setGeodesic_vector(City.retrieveUnknownGeo("Moscow", appid));

        allCities.put(Athens.getName(), Athens);
        allCities.put(Paris.getName(), Paris);
        allCities.put(Moscow.getName(), Moscow);


        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Automated Travelling Assistant!");


        Traveller traveller;
        System.out.print("Provide your age: ");
        int age = in.nextInt();
        System.out.println("Provide your full name : ");
        in.nextLine();
        String name = in.nextLine();
        //check age
        while (age < 16 || age > 130) {
            System.out.println("Invalid age!");
            System.out.print("Provide your age: ");
            age = in.nextInt();
        }
        if (age >= 16 && age <= 25) {
            traveller = new YoungTraveller(name, age);

        } else if (age > 25 && age <= 60) {
            traveller = new MiddleTraveller(name, age);

        } else {
            traveller = new ElderTraveller(name, age);

        }
        allTravellers.add(traveller);
        
        System.out.print("Provide your age: "); //second traveller for testing
        age = in.nextInt();
        System.out.println("Provide your full name : ");
        in.nextLine();
        name = in.nextLine();
        //check age
        while (age < 16 || age > 130) {
            System.out.println("Invalid age!");
            System.out.print("Provide your age: ");
            age = in.nextInt();
        }
        if (age >= 16 && age <= 25) {
            traveller = new YoungTraveller(name, age);

        } else if (age > 25 && age <= 60) {
            traveller = new MiddleTraveller(name, age);

        } else {
            traveller = new ElderTraveller(name, age);

        }
        allTravellers.add(traveller);
        
        
        System.out.print("Provide your city of residence: ");
        String city = in.nextLine();

        if (!allCities.containsKey(city)) {
            City searchCity = new City(city);
            searchCity.setTerms_vector(City.calculateTerms(city, appid));
            searchCity.setGeodesic_vector(City.retrieveUnknownGeo(city, appid));
            allCities.put(city, searchCity);
        }else {
        	traveller.setGeodesic_pref(allCities.get(city).getGeodesic_vector());
        }
        traveller.setTerms_pref();
        System.out.print("Your best match: ");
        Collection<City> value = allCities.values();
        ArrayList<City> tempCities = new ArrayList<>(value);

        System.out.println(traveller.compareCities(tempCities).getName());
        traveller.compareCities(tempCities, 3);

        Traveller.sortTravellers();
    }
}
