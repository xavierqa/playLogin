package controllers;


import static play.data.Form.*;
import models.*;

import play.data.Form;
import play.mvc.*;
import views.html.*;

@Security.Authenticated(Secured.class)
public class Profiles extends Controller{
	
	final static Form <Profile> profileForm = form(Profile.class);
	
	public static Result index(){
		return ok(profiles.render(profileForm, "Test"));
	}
	
	public static Result blank(){
		UUIDGenerator uuid = UUIDGenerator.findByUDID(request().username());
		
		return ok(profiles.render(profileForm, uuid.getUser().getUsername()));
	}
	
	public static Result edit(){
		return ok("this is a edit profile");
	}
	
	public static Result delete(){
		return ok("this is a delete profile");
	}
	
	
	public static Result submit(){
		return ok("this is a submit profile");
	}
	
}
