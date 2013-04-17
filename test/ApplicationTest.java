import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.User;

import org.codehaus.jackson.JsonNode;
import org.junit.*;

import play.Application;
import play.Logger;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

	private Logger LOG = new Logger();
	
    @Test 
    public void simpleCheck() {
    	
   // 	Global.InitialData.insert();
   //     User user = new User("xavier@test.com","xavier","12345678");
   //     List<User> u = new ArrayList<User>(user.findAll());
   //     assertThat(u == null);
        //LOG.info(String.valueOf(u.size()));
        //assertThat(u.size()).isEqualTo(0);
    }
    
    /*@Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Your new application is ready.");
    }*/
  
   
}
