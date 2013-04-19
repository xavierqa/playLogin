package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;


@Entity
@Table(name="profiles")
public class Profiles extends Model{

	@Id
	@Constraints.Required
	@Formats.NonEmpty
	private String uuid;
	
	@Id
	@Constraints.Required
	@Formats.NonEmpty
	private String profilesuuid;
	
	@ManyToMany 
	List<Profile> profiles = new ArrayList<Profile>();
	// Query
	
	public static Model.Finder<String, Profile> finder = new Model.Finder(String.class, Profile.class);
	
	
	public Profiles(String uuid, String description) {
			
	}
	
	/*
	 * Create a profile
	 * 
	 */
	
	public static Profiles createProfile(String uuid, String description){
		
		Profile profile = new Profile(uuid, description);
		
		return null;
	}
	
	
	class Profile{
		
		public Profile(String uuid, String description) {
			// TODO Auto-generated constructor stub
		}
	}
	
	class Category{
		
	}
	
	class Location{
		
	}
	
	class Communication{
		
	}
}
