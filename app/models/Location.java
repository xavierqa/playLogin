package models;

import java.util.ArrayList;
import java.util.List;

public class Location {

	private String country;
	
	private String city;
	
	private String state;
	
	private String neigborhood;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNeigborhood() {
		return neigborhood;
	}

	public void setNeigborhood(String neigborhood) {
		this.neigborhood = neigborhood;
	}

	public static List<String> countrylist() {
        List<String> all = new ArrayList<String>();
        all.add("France");
        all.add("Austria");
        all.add("Belgium");
        all.add("Bulgaria");
        all.add("Cyprus");
        all.add("Czech Republic");
        all.add("Denmark");
        all.add("Estonia");
        all.add("Finland");
        all.add("French Guiana");
        all.add("Germany");
        all.add("Gibraltar");
        all.add("Greece");
        all.add("Guadeloupe");
        all.add("Hungary");
        all.add("Ireland");
        all.add("Italy");
        all.add("Latvia");
        all.add("Lithuania");
        all.add("Luxembourg");
        all.add("Malta");
        all.add("Martinique");
        all.add("Netherlands");
        all.add("Poland");
        all.add("Portugal");
        all.add("Reunion");
        all.add("Romania");
        all.add("Slovak (Republic)");
        all.add("Slovenia");
        all.add("Spain");
        all.add("Sweden");
        all.add("United Kingdom");
        return all;
    }

	
}
