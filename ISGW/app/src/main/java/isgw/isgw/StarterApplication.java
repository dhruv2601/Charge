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
                .applicationId("tHngQYBJmifYY141pqCbB2UePtRUlAHaazDVyIkd")
                .clientKey("SSTTaBiNXpnBqBdbvalUeytwyM3JSkYErPOLZoRA")
                .server("https://parseapi.back4app.com/").build()
        );

        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
