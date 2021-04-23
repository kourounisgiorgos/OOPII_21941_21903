import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static final String appid = "7ee00d1719bab23e58e8acfad960fa89";
    static ArrayList<Traveller> allTravellers = new ArrayList<>();
    static HashMap<String, City> allCities = new HashMap<>();
    static String city;
    

    public static void main(String[] args) throws Exception {
    	
    	Traveller.loadTravellersFromJson();
    	City.readFromDB();
    	
        //hard coded cities
        City Athens = new City("Athens");
        Athens.setTerms_vector();
        Athens.setGeodesic_vector();
        City Paris = new City("Paris");
        Paris.setTerms_vector();
        Paris.setGeodesic_vector();
        City Moscow = new City("Moscow");
        Moscow.setTerms_vector();
        Moscow.setGeodesic_vector();

        allCities.put(Athens.getName(), Athens);
        allCities.put(Paris.getName(), Paris);
        allCities.put(Moscow.getName(), Moscow);


        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Automated Travelling Assistant!");


        Traveller traveller;
        System.out.print("Provide your age: ");
        int age = in.nextInt();
        
        //check age
        while (age < 16 || age > 130) {
            System.out.println("Invalid age!");
            System.out.print("Provide your age: ");
            age = in.nextInt();
        }
        System.out.print("Provide your full name : ");
        in.nextLine();
        String name = in.nextLine();
        if (age >= 16 && age <= 25) {
            traveller = new YoungTraveller(name, age);

        } else if (age > 25 && age <= 60) {
            traveller = new MiddleTraveller(name, age);

        } else {
            traveller = new ElderTraveller(name, age);

        }
        allTravellers.add(traveller);
        
        
        System.out.print("Provide your city of residence: ");
        city = in.nextLine();

        if (!allCities.containsKey(city)) {
            City searchCity = new City(city);
            searchCity.setTerms_vector();
            searchCity.setGeodesic_vector();
            
            City.writeToDB(searchCity);
            allCities.put(city, searchCity);
            traveller.setGeodesic_pref(searchCity.getGeodesic_vector());
        }else {
        	traveller.setGeodesic_pref(allCities.get(city).getGeodesic_vector());
        }
        traveller.setTerms_pref();
        
        
        Collection<City> value = allCities.values();
        ArrayList<City> tempCities = new ArrayList<>(value);
        System.out.print("Your best match: ");
        System.out.println(traveller.compareCities(tempCities).getName());
        
        traveller.compareCities(tempCities, 3);
        
        Traveller.sortTravellers();
        Traveller.writeTravellersToJson();
        
    }
}
