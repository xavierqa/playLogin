package models;

import java.util.List;

import javax.persistence.*;
import javax.validation.Constraint;

import org.json.JSONException;
import org.json.JSONObject;

import play.Logger;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;


import com.avaje.ebean.*;


@Entity
@Table(name="account")
public class User extends Model{

	private static Logger LOG = new Logger();
	
	@Id
	@Constraints.Required
	@Formats.NonEmpty
	public String email;
	
	@Id
	@Constraints.Required
	@Formats.NonEmpty
	public String username;
	
	@Constraints.Required
	public String password;
	
	
	public String uuid; 
	
	
	public UUIDGenerator udid;
	
	
	public User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
		
	}
	
	
	// -- Query
	
	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}


	public static Model.Finder<String, User> find = new Model.Finder(String.class, User.class);
	
	
	/*
	 * create users
	 */
	
	public static User create(String email, String name, String password){
		User user = new User(email, name, password);
		User exist = User.findByEmail(user.getEmail());
		//user.createUDID();
		if(exist==null){
			user.save();
		}else{
			user = null;
		}
		return user;
	}
	
		
	/*
	 * Retrieve all users
	 */
	
	public String getUUID(){
		return this.uuid;
	}
	
	public void createUDID(){
		this.udid = new UUIDGenerator(this);
		this.uuid = this.udid.getUUID();
	}
	
	public static List<User> findAll(){
		return find.all();
	}
	
	
	public static User findByEmail(String email){
		return find.where().eq("email", email).findUnique();
	}
	
	public static User findByUsername(String username){
		LOG.info("value of user:"+username+" "+find.where().eq("username", username).findUnique());
		return find.where().eq("username", username).findUnique();
	}
	
	
	public static User authenticate(String email, String password){
		LOG.info("This is the database response"+find.where().eq("email", email).eq("password", password).findUnique());
		return find.where().eq("email", email).eq("password", password).findUnique();
	}
	
	public String toString(){
		return "email:"+email+" username:"+username+" password:"+password;
	}
	
	public String toJson(){
		return "{email:"+this.getEmail()+",username:"+this.getUsername()+",password:"+this.getPassword()+"}";
	}
	
	public static User getUserFromJson(String json){
		
		User user = null;
		try {
			JSONObject jsonuser = new JSONObject(json);
			user = new User(jsonuser.getString("email"), jsonuser.getString("username"), jsonuser.getString("password"));
		} catch (JSONException e) {
			LOG.error("error deserializing json user",e);
		}
		return user;
	}
	
	
	
}
