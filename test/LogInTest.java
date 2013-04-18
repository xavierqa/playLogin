
import java.util.HashMap;
import java.util.Map;

import models.UUIDGenerator;
import models.User;


import org.junit.*;
import static org.fest.assertions.Assertions.*;

import play.Logger;

import play.mvc.*;
import play.mvc.Http.Cookie;
import play.mvc.Http.Session;
import play.api.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;



public class LogInTest {

	public static Logger LOG = new Logger();
	
	@Test
	public void logInTest(){
		
		running(fakeApplication(), new Runnable() {
			@Override
			public void run() {
				String email = "xavier@test.com";
				String username = "xavier";
				String password = "12345678";
				User user = User.create(email, username, password);
				user.createUDID();
				 
				final Map<String, String> data = new HashMap<String, String>();
	            data.put("email", email);
	            data.put("password", password);
	            
	            Result result = callAction(
	                    controllers.routes.ref.Application.authenticate(),
	                    fakeRequest().withFormUrlEncodedBody(data));
	            
	          //  LOG.info(contentAsString(result));
	         // RECOVER COOKIE FROM LOGIN RESULT
	         //   final Session playSession = play.test.Helpers.session(result);

	         //   LOG.info("Cookie: "+playSession.toString());
	            
	            // LIST SOMETHING (using cookie of the login result)
	            LOG.info("calling home");
	            result = callAction(controllers.routes.ref.Home.index(),fakeRequest().withSession("UUID", user.getUUID()));//withCookies(playSession));

	            /* 
	             * WAS RECEIVING 'SEE_OTHER' (303) 
	             * BEFORE RECOVERING PLAY_SESSION COOKIE (BECAUSE NOT LOGGED IN).
	             *
	             * NOW, EXPECTED 'OK'
	             */ 
	            
	            assertThat(status(result)).isEqualTo(OK); 
	            assertThat(!(contentAsString(result)).contains(" Invalid username or password"));
			}
		});
	}
}
