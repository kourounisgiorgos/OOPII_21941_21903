import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class AppGUI {

	public static JFrame frame;
	private static JTextField nameTextField;
	private static JTextField cityTextField;
	private static JTextField ageText;
	private static JSpinner cafe = new JSpinner();
	private static JSpinner sea = new JSpinner();
	private static JSpinner museum = new JSpinner();
	private static JSpinner restaurant = new JSpinner();
	private static JSpinner stadium = new JSpinner();
	private static JSpinner parks = new JSpinner();
	private static JSpinner hotWeather = new JSpinner();
	private static JSpinner sports = new JSpinner();
	private static JSpinner music = new JSpinner();
	private static JSpinner technology= new JSpinner();
	private static JLabel topCity1;
	private static JLabel topCity2;
	private static JLabel topCity3;
	private static JLabel lblYourTopCity;
	private static JLabel lblYourTop2City;
	private static JLabel lblYourTop3City;
	
	
	
	
	public AppGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().setBackground(new Color(128, 0, 128));
		frame.setBounds(100, 100, 765, 500);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("Travelling Assistant");
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        
        JLabel nameLabel = new JLabel("Insert your full name :");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        nameLabel.setForeground(new Color(240, 248, 255));
        nameLabel.setBounds(10, 59, 150, 35);
        frame.getContentPane().add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBackground(new Color(255, 255, 255));
        nameTextField.setBounds(182, 67, 123, 20);
        frame.getContentPane().add(nameTextField);
        nameTextField.setColumns(4);
        
        JLabel cityLabel = new JLabel("Insert your city of residence :");
        cityLabel.setForeground(new Color(240, 248, 255));
        cityLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        cityLabel.setBounds(10, 183, 225, 35);
        frame.getContentPane().add(cityLabel);
        
        cityTextField = new JTextField();
        cityTextField.setColumns(10);
        cityTextField.setBounds(233, 191, 86, 20);
        frame.getContentPane().add(cityTextField);
        
        JLabel welcomeLabel = new JLabel("WELCOME TO YOUR TRAVELLING ASSISTANT");
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        welcomeLabel.setForeground(new Color(240, 248, 255));
        welcomeLabel.setBounds(0, 10, 416, 33);
        frame.getContentPane().add(welcomeLabel);
        
        JLabel ageLabel = new JLabel("Insert your age :");
        ageLabel.setForeground(new Color(240, 248, 255));
        ageLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        ageLabel.setBounds(10, 123, 129, 35);
        frame.getContentPane().add(ageLabel);
        
        ageText = new JTextField();
        ageText.setColumns(10);
        ageText.setBounds(138, 131, 31, 20);
        frame.getContentPane().add(ageText);
        
        JButton submit = new JButton("Submit Info");
        submit.setBackground(new Color(255, 255, 255));
        submit.setBounds(326, 273, 100, 23);
        submit.addActionListener(new LoginAction());
        frame.getContentPane().add(submit);
        
        cafe = new JSpinner();
        cafe.setModel(new SpinnerNumberModel(5, 0, 10, 1));
        cafe.setBounds(522, 67, 39, 20);
        ((JSpinner.DefaultEditor)cafe.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(cafe);
        
        sea = new JSpinner();
        sea.setModel(new SpinnerNumberModel(5, 0, 10, 1));
        sea.setBounds(522, 105, 39, 20);
        ((JSpinner.DefaultEditor)sea.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(sea);
        
        museum = new JSpinner();
        museum.setModel(new SpinnerNumberModel(5, 0, 10, 1));
        museum.setBounds(522, 144, 39, 20);
        ((JSpinner.DefaultEditor)museum.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(museum);
        
        restaurant = new JSpinner();
        restaurant.setModel(new SpinnerNumberModel(5, 0, 10, 1));
        restaurant.setBounds(522, 191, 39, 20);
        ((JSpinner.DefaultEditor)restaurant.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(restaurant);
        
        stadium = new JSpinner();
        stadium.setModel(new SpinnerNumberModel(5, 0, 10, 1));
        stadium.setBounds(522, 235, 39, 20);
        ((JSpinner.DefaultEditor)stadium.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(stadium);
        
        parks = new JSpinner();
        parks.setModel(new SpinnerNumberModel(5, 0, 10, 1));
        parks.setBounds(695, 67, 39, 20);
        ((JSpinner.DefaultEditor)parks.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(parks);
        
        hotWeather = new JSpinner();
        hotWeather.setModel(new SpinnerNumberModel(5, 0, 10, 1));
        hotWeather.setBounds(695, 105, 39, 20);
        ((JSpinner.DefaultEditor)hotWeather.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(hotWeather);
        
        sports = new JSpinner();
        sports.setModel(new SpinnerNumberModel(5, 0, 10, 1));
        sports.setBounds(695, 144, 39, 20);
        ((JSpinner.DefaultEditor)sports.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(sports);
        
        music = new JSpinner();
        music.setModel(new SpinnerNumberModel(5, 0, 10, 1));
        music.setBounds(695, 191, 39, 20);
        ((JSpinner.DefaultEditor)music.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(music);
        
        technology = new JSpinner();
        technology.setModel(new SpinnerNumberModel(5, 0, 10, 1));
        technology.setBounds(695, 235, 39, 20);
        ((JSpinner.DefaultEditor)technology.getEditor()).getTextField().setEditable(false);
        frame.getContentPane().add(technology);
        
        JLabel lblCafes = new JLabel("Cafes :");
        lblCafes.setForeground(new Color(240, 248, 255));
        lblCafes.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCafes.setBounds(447, 59, 54, 35);
        frame.getContentPane().add(lblCafes);
        
        JLabel lblCafes_1 = new JLabel("Sea :");
        lblCafes_1.setForeground(new Color(240, 248, 255));
        lblCafes_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCafes_1.setBounds(458, 97, 54, 35);
        frame.getContentPane().add(lblCafes_1);
        
        JLabel lblCafes_2 = new JLabel("Museum :");
        lblCafes_2.setForeground(new Color(240, 248, 255));
        lblCafes_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblCafes_2.setBounds(435, 136, 77, 35);
        frame.getContentPane().add(lblCafes_2);
        
        JLabel lblRestaurants = new JLabel("Restaurants :");
        lblRestaurants.setForeground(new Color(240, 248, 255));
        lblRestaurants.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblRestaurants.setBounds(411, 183, 110, 35);
        frame.getContentPane().add(lblRestaurants);
        
        JLabel lblStadium = new JLabel("Stadium :");
        lblStadium.setForeground(new Color(240, 248, 255));
        lblStadium.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblStadium.setBounds(435, 227, 77, 35);
        frame.getContentPane().add(lblStadium);
        
        JLabel lblParks = new JLabel("Parks :");
        lblParks.setForeground(new Color(240, 248, 255));
        lblParks.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblParks.setBounds(631, 59, 54, 35);
        frame.getContentPane().add(lblParks);
        
        JLabel lblHotWeather = new JLabel("Hot Weather :");
        lblHotWeather.setForeground(new Color(240, 248, 255));
        lblHotWeather.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblHotWeather.setBounds(585, 97, 100, 35);
        frame.getContentPane().add(lblHotWeather);
        
        JLabel lblSports = new JLabel("Sports :");
        lblSports.setForeground(new Color(240, 248, 255));
        lblSports.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblSports.setBounds(627, 136, 68, 35);
        frame.getContentPane().add(lblSports);
        
        JLabel lblMusic = new JLabel("Music :");
        lblMusic.setForeground(new Color(240, 248, 255));
        lblMusic.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMusic.setBounds(631, 183, 54, 35);
        frame.getContentPane().add(lblMusic);
        
        JLabel lblTechnology = new JLabel("Technology:");
        lblTechnology.setForeground(new Color(240, 248, 255));
        lblTechnology.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTechnology.setBounds(603, 227, 92, 35);
        frame.getContentPane().add(lblTechnology);
        
        JLabel lblRateTheFollowing = new JLabel("RATE THE FOLLOWING 0/10");
        lblRateTheFollowing.setForeground(new Color(240, 248, 255));
        lblRateTheFollowing.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblRateTheFollowing.setBounds(538, 10, 196, 35);
        frame.getContentPane().add(lblRateTheFollowing);
        
        lblYourTop2City = new JLabel("YOUR TOP 2 CITY");
        lblYourTop2City.setForeground(new Color(240, 248, 255));
        lblYourTop2City.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblYourTop2City.setBounds(200, 369, 129, 35);
        lblYourTop2City.setVisible(false);
        frame.getContentPane().add(lblYourTop2City);
        
        topCity1 = new JLabel("");
        topCity1.setForeground(new Color(240, 248, 255));
        topCity1.setFont(new Font("Tahoma", Font.BOLD, 13));
        topCity1.setBounds(353, 333, 100, 35);
        frame.getContentPane().add(topCity1);
        
        lblYourTopCity = new JLabel("YOUR TOP CITY");
        lblYourTopCity.setForeground(new Color(240, 248, 255));
        lblYourTopCity.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblYourTopCity.setBounds(326, 307, 110, 35);
        lblYourTopCity.setVisible(false);
        frame.getContentPane().add(lblYourTopCity);
        
        lblYourTop3City = new JLabel("YOUR TOP 3 CITY");
        lblYourTop3City.setForeground(new Color(240, 248, 255));
        lblYourTop3City.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblYourTop3City.setBounds(435, 369, 150, 35);
        lblYourTop3City.setVisible(false);
        frame.getContentPane().add(lblYourTop3City);
        
        topCity2 = new JLabel("");
        topCity2.setForeground(new Color(240, 248, 255));
        topCity2.setFont(new Font("Tahoma", Font.BOLD, 13));
        topCity2.setBounds(229, 402, 100, 35);
        frame.getContentPane().add(topCity2);
        
        topCity3 = new JLabel("");
        topCity3.setForeground(new Color(240, 248, 255));
        topCity3.setFont(new Font("Tahoma", Font.BOLD, 13));
        topCity3.setBounds(471, 402, 100, 35);
        frame.getContentPane().add(topCity3);
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	Traveller.sortTravellers();
                try {
					Traveller.writeTravellersToJson();
				} catch (Exception e1) {}
                frame.dispose();
                System.exit(0);
            }
        });
	}
	
	private class LoginAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e){
			Traveller traveller;
			int age = Integer.parseInt(ageText.getText());
			if (age < 16 || age > 130) {
				JOptionPane.showMessageDialog(null, "Incorrect age . Try again!");
				return;
	        }
			String name = nameTextField.getText();
			if (age >= 16 && age <= 25) {
	            traveller = new YoungTraveller(name, age);

	        } else if (age > 25 && age <= 60) {
	            traveller = new MiddleTraveller(name, age);

	        } else {
	            traveller = new ElderTraveller(name, age);

	        }
			
		    Main.allTravellers.add(traveller);
			String city = cityTextField.getText();
			if (!Main.allCities.containsKey(city)) {
	            City searchCity = new City(city);
	            try {
					searchCity.setTerms_vector();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "City does not exist!");
					return;
				}
	            searchCity.setGeodesic_vector();
	            
	            try {
					City.writeToDB(searchCity);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Failed To Access DB");
				}
	            
	            Main.allCities.put(city, searchCity);
	            traveller.setGeodesic_pref(searchCity.getGeodesic_vector());
	        }else {
	        	traveller.setGeodesic_pref(Main.allCities.get(city).getGeodesic_vector());
	        }
			int [] termsPref = new int[10];
			termsPref[0] = (int) cafe.getValue();
			termsPref[1] = (int) sea.getValue();
			termsPref[2] = (int) museum.getValue();
			termsPref[3] = (int) restaurant.getValue();
			termsPref[4] = (int) stadium.getValue();
			termsPref[5] = (int) parks.getValue();
			termsPref[6] = (int) hotWeather.getValue();
			termsPref[7] = (int) sports.getValue();
			termsPref[8] = (int) music.getValue();
			termsPref[9] = (int) technology.getValue();
			
	        traveller.setTerms_pref(termsPref);
	        
	        ArrayList<City> tempCities = new ArrayList<>(Main.allCities.values());

	        
	        String[] topCities = traveller.compareCities(tempCities, 3);
	        lblYourTopCity.setVisible(true);
	        topCity1.setText(topCities[0]);
	        lblYourTop2City.setVisible(true);
	        topCity2.setText(topCities[1]);
	        lblYourTop3City.setVisible(true);
	        topCity3.setText(topCities[2]);  
	        
		}
		
    }
}
