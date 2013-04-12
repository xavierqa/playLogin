package controllers;


import models.*;
import play.data.*;
import play.mvc.*;
import play.Logger;
import static play.data.Form.*;
import play.mvc.Controller;

public class SignUp extends Controller{

	public static Logger LOG = new Logger();
	
	
	final static Form<User> signupForm = form(User.class);
	
	public static Result blank(){
		return ok(form.render(signupForm));
	}

	public static Result submit(){
		 Form<User> filledForm = signupForm.bindFromRequest();
		 
         LOG.info(filledForm.toString());
         if (!"true".equals(filledForm.field("accept").value())){
                 filledForm.reject("accept","You must accept the terms and conditions");
         }

         if(!filledForm.field("password").valueOr("").isEmpty()){
                 if (!filledForm.field("password").valueOr("").equals(filledForm.field("repeatPassword").value())){
                         filledForm.reject("repeatPassword","Password don't match");
                 }
         }
         // add support for generation of username
         if(!filledForm.hasErrors()){
                 if(filledForm.field("username").value().equals("admin")){
                         filledForm.reject("username", "This username is already taken");
                 }
         }

         //return null;
         if(filledForm.hasErrors()){
                 return badRequest(form.render(filledForm));
         } else {
                 User created = filledForm.get();
                 created.save();
                 session("email", filledForm.get().email);
                 return ok(routes.Home.index());
         }

	}
	
}
