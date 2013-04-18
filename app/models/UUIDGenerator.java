package models;


import javax.persistence.*;

import play.Logger;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;

import java.util.UUID;

@Entity
@Table(name="uuid")
public class UUIDGenerator extends Model{
	
	public static Logger LOG = new Logger();
	
	@Formats.NonEmpty
	@Id
	public String uuid;
	
	//private UUID uuid;
	
	@Constraints.Required
	@Formats.NonEmpty
	public String user;
	
	
		
	public static Model.Finder<String, UUIDGenerator> find = new Model.Finder(String.class, UUIDGenerator.class);
	
	public UUIDGenerator(User user) {
		// TODO Auto-generated constructor stub
		LOG.info(user.toString());
		this.user = user.toJson();
		this.uuid = getUUID(user.getEmail(), user.getPassword());
		createUUID();
	}
	
	public static String getUUID(String email, String password){
		String salt = "this is xqa app";
		UUID uuid = UUID.nameUUIDFromBytes((email+salt+password).getBytes()); //fromString("56964b59-9fdd-4e57-9c02-206616145949");//randomUUID();//fromString("test");//user.toString());
		LOG.info("uuid from uuidGenerator:"+uuid.toString());
		return uuid.toString();//String.valueOf(user.toJson().hashCode());
	}
	
	
	private void createUUID(){
		save();
	}
	
	public User getUser(){
		return User.getUserFromJson(this.user);
	}
	
	public String getUUID(){
		return this.uuid;
	}
	public static UUIDGenerator findByUDID(String uuid){
		return find.where().eq("UUID", uuid).findUnique();
	}
	
	@Override
	public String toString() {
	
		return this.uuid + " user " + this.user.toString();
	}
}