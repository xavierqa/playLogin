package controllers;

import models.User;
import play.*;

import static play.data.Form.*;

import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
	
	public static Logger LOG = new Logger();
	
    public static Result index() {
    	return ok(index.render());
    }

	
	public static class Login{
		public String email;
		public String password;
		
		public String validate(){
			if(User.authenticate(email, password) == null){
				return "Invalid username or password";
			}
			return null;
		}
		
	}
	
	public static Result login(){
		return ok(login.render(form(Login.class)));
	}
	
	public static Result authenticate(){
		Form<Login> loginForm = form(Login.class).bindFromRequest();
		if(loginForm.hasErrors()){
			return badRequest(login.render(loginForm));
		}else{
			session("email", loginForm.get().email);
			return redirect(routes.Home.index());
		}
		
	}
	
	
	public static Result logout(){
		LOG.info("logout");
		session().clear();
		flash("success", "you have been logged out");
		return redirect(routes.Application.login());
	}
	
	public static Result home(String username){
		return ok(home.render(username));
	}
	
}
