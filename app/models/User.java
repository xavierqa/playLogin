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
	
	@Constraints.Required
	public String name;
	
	@Constraints.Required
	public String password;
	
	// -- Query
	
	public static Model.Finder<String, User> find = new Model.Finder(String.class, User.class);
	
	/*
	 * Retrieve all users
	 */
	
	public static List<User> findAll(){
		return find.all();
	}
	
	
	public static User findByEmail(String email){
		return find.where().eq("email", email).findUnique();
	}
	
	public static User authenticate(String email, String password){
		LOG.info("This is the database response"+find.where().eq("email", email).eq("password", password).findUnique());
		return find.where().eq("email", email).eq("password", password).findUnique();
	}
	
	public String toString(){
		return "user:"+email+"name:"+name+"password:"+password;
	}
}
