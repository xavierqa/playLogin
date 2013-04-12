import play.*;
import play.GlobalSettings;
import play.libs.*;

import java.util.*;

import com.avaje.ebean.*;

import models.*;


public class Global extends GlobalSettings{

	public static Logger LOG = new Logger();
	
	public void onStart(Application app){
		LOG.info("starting app");
		InitialData.insert(app);
	}
	
	public static class InitialData{
		
		public static void insert(Application app){
			LOG.info("calling init");
			
			if(Ebean.find(User.class).findRowCount()==0){
			LOG.info("starting process");
				  Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
	                // Insert users first
	                Ebean.save(all.get("users"));

			}
		}
		
		public static void insert(){
			LOG.info("calling init");
			if(Ebean.find(User.class).findRowCount()==0){
				  Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
	                // Insert users first
	                Ebean.save(all.get("users"));

			}
		}
		
	}
}
