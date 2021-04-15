import com.fasterxml.jackson.databind.ObjectMapper;
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

import java.net.URL;
import java.util.Scanner;

public class City {
	
	private static Scanner scan = new Scanner(System.in);

	String name;
	String country;
	private int[] terms_vector = new int[10];
	private double[] geodesic_vector = new double[2];

	public City(String name) {
		this.name = name;
		this.terms_vector = null;
		this.geodesic_vector = null;

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
		double bestSimilarity = -1;
		for (int i = 0; i < Main.allTravellers.size(); i++) {
			result = Main.allTravellers.get(i).calculateFreeTicket(this);
			if (result > bestSimilarity) {
				bestSimilarity = result;
				bestTraveller = Main.allTravellers.get(i);
			}

		}

		return bestTraveller;
	}

	public static double[] retrieveUnknownGeo(String city, String appid) { // retrieve Geodesic info 
		ObjectMapper mapper = new ObjectMapper();
		do {
			try {
				OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=" + appid + ""),OpenWeatherMap.class);
				double[] tempGeo = { weather_obj.getCoord().getLat(), weather_obj.getCoord().getLon() };
				return tempGeo;
			}catch(Exception e) {
				System.out.println("City " + city + " doesn't exist");
				System.out.println("Try inserting an existing city:");
				city = scan.nextLine();
				continue;
			}
		}while(true);
		
	}

	public int retrieveTemperature(String city, String appid) {
		ObjectMapper mapper = new ObjectMapper();
		do {
			try {
				OpenWeatherMap weather_obj = mapper.readValue(
						new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=" + appid + ""),
						OpenWeatherMap.class);
				int temperature;

				double celsius = weather_obj.getMain().getTemp() - 273.15; // conversion from kelvin to celsius
				if (celsius >= 40) {
					temperature = 10;
				} else if (celsius >= 35) {
					temperature = 9;
				} else if (celsius >= 30) {
					temperature = 8;
				} else if (celsius >= 25) {
					temperature = 7;
				} else if (celsius >= 20) {
					temperature = 6;
				} else if (celsius >= 15) {
					temperature = 5;
				} else if (celsius >= 10) {
					temperature = 4;
				} else if (celsius >= 5) {
					temperature = 3;
				} else if (celsius >= 0) {
					temperature = 2;
				} else if (celsius >= -5) {
					temperature = 1;
				} else {
					temperature = 0;
				}

				return temperature;
			}catch(Exception e) {
				System.out.println("City + " + city + " doesnt exist");
				System.out.println("Try inserting an existing city");
				city = scan.nextLine();
				continue;
			}
		}while(true);
		
	}

	public static int[] calculateTerms(String city, String appid){
		int[] terms = new int[10];
		ObjectMapper mapper = new ObjectMapper();
		do {
			try {
				OpenWeatherMap weather_obj = mapper.readValue(
						new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + "&APPID=" + appid + ""),
						OpenWeatherMap.class);
				MediaWiki mediaWiki_obj = mapper
						.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles=" + city
								+ "&format=json&formatversion=2"), MediaWiki.class);
				City thisCity = new City(city);

				terms[0] = countCriterionCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(), "cafe");
				terms[1] = countCriterionCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(), "sea");
				terms[2] = countCriterionCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(), "museum");
				terms[3] = countCriterionCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(), "restaurant");
				terms[4] = countCriterionCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(), "stadium");
				terms[5] = countCriterionCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(), "park");
				terms[6] = thisCity.retrieveTemperature(city, appid);
				terms[7] = countCriterionCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(), "sports");
				terms[8] = countCriterionCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(), "music");
				terms[9] = countCriterionCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(), "technology");

				return terms;
			}catch(Exception e) {
				System.out.println("City + " + city + " doesnt exist");
				System.out.println("Try inserting an existing city:");
				city = scan.nextLine();
				continue;
			}
		}while(true);
		
		
	}

	private static int countCriterionCity(String cityArticle, String criterion) {
		cityArticle = cityArticle.toLowerCase();
		int index = cityArticle.indexOf(criterion);
		int count = 0;
		while (index != -1) {
			count++;
			cityArticle = cityArticle.substring(index + 1);
			index = cityArticle.indexOf(criterion);
		}
		return count;
	}

}
