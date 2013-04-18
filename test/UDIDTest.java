import models.UUIDGenerator;
import models.User;

import org.junit.*;
import static org.fest.assertions.Assertions.*;

import play.Logger;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class UDIDTest {

	private static Logger LOG = new Logger();
	
	@Test
	public void UdidTest(){
		
		running(fakeApplication(), new Runnable() {
			
			@Override
			public void run() {
				 User user = User.create("xavier@test.com","xavier","12345678");
				 user.createUDID();
				 String UUID = user.getUUID();
				 LOG.info(UUID);
				 assertThat(UUID!=null);
				 UUIDGenerator uuid = UUIDGenerator.findByUDID(UUID);
				 assertThat(uuid!=null);
				 LOG.info(uuid.getUser().toString());
				 assertThat(uuid.getUUID().equals(UUID));
				 assertThat(uuid.getUser().equals(user));
			}
		});
		
	}
}
