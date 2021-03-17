import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		int[] terms_vector = {2, 5, 6, 0, 1, 8, 9, 9, 9, 11};
		int[] terms_vector2 = {9, 0, 0, 2, 6, 4, 3, 2, 30, 11};
		int[] terms_vector3 = {1, 2, 3, 4, 5, 6, 7 ,8, 9, 15};

		int[] geodesic_vector = {0, 0};

		City city = new City(terms_vector, geodesic_vector, "Athens");
		City city2 = new City(terms_vector2, geodesic_vector, "Paris");
		City city3 = new City(terms_vector3, geodesic_vector, "Wuakanda");


		ArrayList<City> cities = new ArrayList<>();
		cities.add(city);
		cities.add(city2);
		cities.add(city3);

		//broken
		YoungTraveller letzis = new YoungTraveller(16);
		letzis.setTerms_pref(new int[]{1, 2, 3, 4, 5, 6, 7 ,8, 9, 15});

		//broken
		MiddleTraveller lezos = new MiddleTraveller(25);
		lezos.setTerms_pref(new int[]{2, 5, 6, 0, 1, 8, 9, 9, 9, 11	});

		//working
		ElderTraveller dimitris = new ElderTraveller(35);
		dimitris.setTerms_pref(new int[]{9, 0, 0, 2, 6, 4, 3, 2, 8, 11});


		System.out.println("letzis: " + letzis.compare_cities(cities).getName());
		System.out.println("lezos: " + lezos.compare_cities(cities).getName());
		System.out.println("dimitris: " + dimitris.compare_cities(cities).getName());
	}

}
