import com.fasterxml.jackson.databind.ObjectMapper;
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class City {

	String name;
	String country;
	private int[] terms_vector = new int[10];
	private double[] geodesic_vector = new double[2];
	
	public City(int[] terms_vector, double[] geodesic_vector, String name) {
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

	public double[] getGeodesic_vector() {
		return geodesic_vector;
	}

	public void setGeodesic_vector(double[] geodesic_vector) {
		this.geodesic_vector = geodesic_vector;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public Traveller compareTravellers() {
		Traveller bestTraveller = null;
		double result;
		double bestSimilarity=-1;
		for(int i=0;i<Main.allTravellers.size();i++) {
			result = Main.allTravellers.get(i).calculateFreeTicket(this);
			if(result > bestSimilarity) {
				bestSimilarity = result;
				bestTraveller = Main.allTravellers.get(i);
			}
			
		}
		
		return bestTraveller;
	}

	public void retrieveData(String appid) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+this.name+"&APPID="+appid+""), OpenWeatherMap.class);
		System.out.println(this.name+" temperature: " + (weather_obj.getMain()).getTemp());

		double[] tempGeo = {weather_obj.getCoord().getLat(), weather_obj.getCoord().getLon()};
		setGeodesic_vector(tempGeo);
		System.out.println(this.name+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());

		MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+this.name+"&format=json&formatversion=2"),MediaWiki.class);
		System.out.println(this.name+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());
	}

	public static double[] retrieveData(String city, String appid) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID="+appid+""), OpenWeatherMap.class);
		double[] tempGeo = {weather_obj.getCoord().getLat(), weather_obj.getCoord().getLon()};

		return tempGeo;
	}

}
