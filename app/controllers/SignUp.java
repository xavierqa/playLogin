package controllers;

import models.*;
import play.data.*;
import play.mvc.*;
import play.Logger;
import static play.data.Form.*;
import play.mvc.Controller;
import views.html.*;

public class SignUp extends Controller {

	public static Logger LOG = new Logger();

	final static Form<User> signupForm = form(User.class);

	public static Result blank() {
		// return ok();
		return ok(signup.render(signupForm));
	}

	public static Result submit() {
		LOG.info("submit here");
		Form<User> filledForm = signupForm.bindFromRequest();
		LOG.info(filledForm.toString());
		LOG.info("Username: " + filledForm.field("username").value());

		if (!"true".equals(filledForm.field("accept").value())) {
			filledForm.reject("accept", "You must accept");
		}

		if (!filledForm.field("password").valueOr("").isEmpty()) {
			if (!filledForm.field("password").valueOr("")
					.equals(filledForm.field("repeatPassword").value())) {
				filledForm.reject("repeatPassword",
						"Please re-enter password, it does not match");
				LOG.info(" repeat password");
			}
		}

		if (!filledForm.hasErrors()) {
			//if (
			
					if( User.findByUsername(filledForm.field("username").value()) == null || filledForm.field("username").value().equals("admin")) {
				LOG.info("Wrong username");
				filledForm.reject("username",
						"This username has been already taken");

			}
		}

		if (!filledForm.hasErrors()) {
			if (User.findByEmail(filledForm.field("email").value()) != null) {
				LOG.info("user already exist");
				filledForm.reject("email", "User already exist");
			}
		}
		LOG.info("creating user" + filledForm.hasErrors());
		if (filledForm.hasErrors()) {
			LOG.info("bad request" + filledForm.globalError());
			return badRequest(signup.render(filledForm));
		} else {
			User created = filledForm.get();
			LOG.info("User:" + created.toString());
			session("email", created.getEmail());
			return redirect(routes.Home.index());

		}

	}

}
