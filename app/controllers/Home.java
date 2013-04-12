package controllers;
import play.*;
import play.mvc.*;

import play.mvc.Controller;
import views.html.*;
import models.*;

@Security.Authenticated(Secured.class)
public class Home extends Controller{

	public static Logger LOG = new Logger();
	
	public static Result index(){
		LOG.info("this is home");
		return ok(home.render(request().username()));
	}
	
}
