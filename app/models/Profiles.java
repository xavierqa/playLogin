package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.Constraint;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.*;

import com.avaje.ebean.*;

@Entity
@Table(name="profiles")
public class Profiles extends Model{

	@Id
	@Constraints.Required
	@Formats.NonEmpty
	private String id;
	
	@Constraints.Required
	private String profilesJson;
	 
	private Birthday birthday;
	
	private Location originalLocation;
	
	Map<Integer,Profile> profiles = null;
	// Query
	
	private Integer index = null;
	
	public static Model.Finder<String, Profiles> find = new Model.Finder(String.class, Profiles.class);
	
	
	public Profiles(String uuid) {
			Profiles profiles = findProfiles(uuid);
			this.id = uuid;
			if( profiles == null){
			this.profiles = new HashMap<Integer,Profile>();
			this.index = 0;
			}else{
				this.profiles = profiles.getProfiles();
			}
	}
	
	public Map<Integer,Profile> getProfiles(){
		return  this.profiles;
	}
	
	public void setProfiles(Profile profile){
		this.profiles.put(getIndex(), profile);
		addIndex();
	}
	
	public void addIndex(){
		this.index++;
	}
	
	public Integer getIndex(){
		return this.index;
	}
	
	public Boolean isEmptyProfiles(){
		return this.profiles.isEmpty();
	}
	
	
	public static Profiles createProfiles(String uuid){
		Profiles profiles = new Profiles(uuid);
		profiles.save();
		return profiles;
	}
	
	public static Profiles findProfiles(String uuid){
		Profiles profiles = find.where().eq("id",uuid).findUnique();
		return profiles;
	}
	
	
	
	
	
	
	
	
}
