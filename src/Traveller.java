import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

abstract class Traveller {
	
	Scanner r = new Scanner(System.in);
	protected int[] terms_pref = new int[10];
	protected double[] geodesic_pref = new double[2];
	protected int age;

	public abstract double calculateSimilarity(City curCity);

	public int[] getTerms_pref() {
		return terms_pref;
	}

	public void setTerms_pref() {
		System.out.println("Cafes - 0/10");
		terms_pref[0] = checkInput(r.nextInt());
		
		
		System.out.println("Sea - 0/10");
		terms_pref[1] = checkInput(r.nextInt());
				
		System.out.println("Museums - 0/10");
		terms_pref[2] = checkInput(r.nextInt());
				
		System.out.println("Restaurant - 0/10");
		terms_pref[3] = checkInput(r.nextInt());
				
		System.out.println("Stadium - 0/10");
		terms_pref[4] = checkInput(r.nextInt());
				
		System.out.println("Parks - 0/10");
		terms_pref[5] = checkInput(r.nextInt());
		
		System.out.println("Hot weather - 0/10");
		terms_pref[6] = checkInput(r.nextInt());
		
		System.out.println("Sports - 0/10");
		terms_pref[7] = checkInput(r.nextInt());
		
		System.out.println("Music - 0/10");
		terms_pref[8] = checkInput(r.nextInt());
		
		System.out.println("Technology - 0/10");
		terms_pref[9] = checkInput(r.nextInt());	
		
	}
	
	private int checkInput(int input) {
		
		while(input < 0 || input > 10) {
			System.out.println("Wrong input, try again!");
			input = r.nextInt();
		}
		return input;
		
	}

	public double[] getGeodesic_pref() {
		return geodesic_pref;
	}

	public void setGeodesic_pref(double[] geodesic_pref) {
		this.geodesic_pref = geodesic_pref;
	}

	public Traveller(int age) {
		super();
		this.age = age;

	}
	
	public double similarityGeodesicVector(City myCity) {
		int maxdist = 15317;
		return  Math.log(2/(2-distance(myCity.getGeodesic_vector()[0],myCity.getGeodesic_vector()[1],this.geodesic_pref[0],this.geodesic_pref[1],"K")/maxdist)) / Math.log(2);
		
		
	}

	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}

	public City compareCities(ArrayList<City> cities) {

		City probableCity = null;
		double res;
		double max = -1;
		double p=0;
		if(this instanceof YoungTraveller) {
			p = 0.7;
		}else if(this instanceof MiddleTraveller) {
			p = 0.5;
		}else if(this instanceof ElderTraveller) {
			p = 0.3;
		}
		
		for(int i=0;i<cities.size();i++) {
			res = p * this.calculateSimilarity(cities.get(i)) + (1 - p) * this.similarityGeodesicVector(cities.get(i));
			if (max < res) {
				max = res;
				probableCity = cities.get(i);
			}

		}
		return probableCity;
	}
	
	public void compareCities(ArrayList<City> cities , int x) {
		if(x > cities.size()) {
			x = cities.size();
		}
		City[] bestCities = new City[x];
		ArrayList<City> tempCities = new ArrayList<City>(cities);
		
		int i = 0;
		while(i < x) {
			bestCities[i] = compareCities(tempCities);
			tempCities.remove(bestCities[i]);
			i++;
		}

		System.out.println("Your Top "+x+" cities:");
		for (int j = 0; j < x; j++) {
			System.out.println(bestCities[j].name);
		}
	}
	

	public double calculateFreeTicket(City myCity) {
		double p=0;
		if(this instanceof YoungTraveller) {
			p = 0.7;
		}else if(this instanceof MiddleTraveller) {
			p = 0.5;
		}else if(this instanceof ElderTraveller) {
			p = 0.3;
		}
		
		return p * this.calculateSimilarity(myCity) + (1 - p) * this.similarityGeodesicVector(myCity);
	}
	
}

