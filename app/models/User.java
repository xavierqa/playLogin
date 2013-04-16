package models;

import java.util.List;

import javax.persistence.*;

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
	
	public UDID udid;
	
	
	public User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.udid = new UDID(this);
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
		return "user:"+email+"name:"+username+"password:"+password;
	}
	
	public String toJson(){
		return "{user:"+this.getUsername()+",username:"+this.username+",password"+this.password+"}";
	}
	
	/*@Table (name="UDID_lookup")
	class UDID{
		
		public UDIDData data = new UDIDData(new Model.Finder(String.class, UDID.class));

		public UDID(User user) {
			// TODO Auto-generated constructor stub
			this.data.user = user.toJson();
			this.data.UDID = getUDID(user);
			createUDID();
		}
		
		private String getUDID(User user){
			return String.valueOf(user.toJson().hashCode());
		}
		private void createUDID(){
			save();
		}
		
		public UDID findByUDID(String UDID){
			return data.findudid.where().eq("UDID", UDID).findUnique();
		}
		
	}*/
	
}
