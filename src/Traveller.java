import java.util.ArrayList;

abstract class Traveller {

	protected int[] terms_pref = new int[10];
	protected int[] geodesic_pref = new int[2];
	protected int age;

	public abstract double calculateSimilarity(City curCity);

	public int[] getTerms_pref() {
		return terms_pref;
	}

	public void setTerms_pref(int[] terms_pref) {
		this.terms_pref = terms_pref;
	}

	public int[] getGeodesic_pref() {
		return geodesic_pref;
	}

	public void setGeodesic_pref(int[] geodesic_pref) {
		this.geodesic_pref = geodesic_pref;
	}

	public Traveller(int age) {
		super();
		this.age = age;

	}

	public City compare_cities(ArrayList<City> cities) {

		City probableCity = null;
		double res;
		if (this instanceof MiddleTraveller || this instanceof YoungTraveller || this instanceof ElderTraveller) {

			double maxSimilarity = -1;

			for (int i = 0; i < cities.size(); i++) {

				res = calculateSimilarity(cities.get(i));

				if (maxSimilarity < res) {
					maxSimilarity = res;
					probableCity = cities.get(i);
				}

			}

		}
		return probableCity;
	}
}
