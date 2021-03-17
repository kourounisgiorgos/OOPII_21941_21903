
public class City {

	String name;
	private int[] terms_vector = new int[10];
	private int[] geodesic_vector = new int[2];
	
	public City(int[] terms_vector, int[] geodesic_vector, String name) {
		super();
		this.name = name;
		this.terms_vector = terms_vector;
		this.geodesic_vector = geodesic_vector;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int[] getTerms_vector() {
		return terms_vector;
	}

	public void setTerms_vector(int[] terms_vector) {
		this.terms_vector = terms_vector;
	}

	public int[] getGeodesic_vector() {
		return geodesic_vector;
	}

	public void setGeodesic_vector(int[] geodesic_vector) {
		this.geodesic_vector = geodesic_vector;
	}

}
