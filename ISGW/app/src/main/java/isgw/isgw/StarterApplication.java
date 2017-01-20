package isgw.isgw;


import android.app.Application;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

public class StarterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("lwAHnbXA3w5LDeHzTFyQsjyvV3M1xw0Y4NsJ9l6Y")
                .clientKey("gVHHcCQxgewVXhO9ZAFeIuEnsj8gCSLGxl7DTwcu")
                .server("https://parseapi.back4app.com/").build()
        );


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
