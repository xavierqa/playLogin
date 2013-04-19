package controllers;

import models.UUIDGenerator;
import models.User;
import play.*;

import static play.data.Form.*;

import play.data.Form;
import play.libs.Crypto;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
	
	public static Logger LOG = new Logger();
	
    public static Result index() {
    	return ok(index.render());
    }

    public static Result list(){
    	return ok("this is a test");
    }
	
	public static class Login{
		public String email;
		public String password;
		public String username;
		public String uuid; 
		
		public String validate(){
			LOG.info("validating user");
			User user = User.authenticate(email, password);
			
			if(user == null){
				return "Invalid username or password";
			}
			LOG.info("validated User:"+user.toString());
			return null;
		}
			
	}
	
	public static Result login(){
		return ok(login.render(form(Login.class), "logout"));
	}
	
	public static Result authenticate(){
		LOG.info("authentication");
		Form<Login> loginForm = form(Login.class).bindFromRequest();
		if(loginForm.hasErrors()){
			return badRequest(login.render(loginForm,"logout"));
		}else{
			LOG.info("user:"+loginForm);
			//User user = User.create(, name, password)
			String uuid = UUIDGenerator.getUUID(loginForm.get().email, loginForm.get().password);
			LOG.info("user uuid:" + uuid);
			session("UUID", uuid);
			LOG.info("redirecting to home");
			//response().setCookie("rememberme", Crypto.sign(uuid));
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
