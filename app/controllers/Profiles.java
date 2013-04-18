package controllers;


import play.mvc.Controller;
import play.mvc.*;
import play.mvc.Security;

@Security.Authenticated(Secured.class)
public class Profiles extends Controller{
	
	public static Result index(){
		return ok("this is a profile");
	}
	
	public static Result blank(){
		return ok("this is a blank profile");
	}
	
	public static Result submit(){
		return ok("this is a submit profile");
	}
}
