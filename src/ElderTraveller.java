
public class ElderTraveller extends Traveller {

	public ElderTraveller(int age) {
		super(age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateSimilarity(City curCity) {
		this.getTerms_pref();

		int count = 0;

		for (int i = 0; i < 10; i++) {
			if (this.getTerms_pref()[i] == curCity.getTerms_vector()[i] || this.getTerms_pref()[i] == curCity.getTerms_vector()[i]+1 ||
					this.getTerms_pref()[i] == curCity.getTerms_vector()[i]-1 || (this.getTerms_pref()[i] == 10 && curCity.getTerms_vector()[i] >= 10)){
				count++;
			}
		}

		return count/20.0;
	}

}
