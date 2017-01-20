package isgw.isgw.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Arrays;

import isgw.isgw.R;

public class MainActivity extends AppCompatActivity {

    public static String parseUser;
    public static String parsePassword;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            parseUser = currentUser.getUsername();
            parsePassword = currentUser.getEmail();

            Log.d(TAG,"currentUserIsThere");

            currentUser.addAll("appliance", Arrays.asList("A.C.", "Fan", "CFL", "Refrigerator"));
            currentUser.saveInBackground();

//            Log.d(TAG,"currentUser is there");
//            Intent i = new Intent(MainActivity.this, AccountActivity.class);         // account Activity
//            startActivity(i);
        } else {
            Log.d(TAG,"No Current User");
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            MainActivity.this.finish();
        }
    }
}