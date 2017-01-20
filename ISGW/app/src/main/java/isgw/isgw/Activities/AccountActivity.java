package isgw.isgw.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import isgw.isgw.R;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        getSupportActionBar().hide();

        LinearLayout electricity = (LinearLayout)findViewById(R.id.elec);
        LinearLayout carbon = (LinearLayout)findViewById(R.id.carbon);
        LinearLayout rewards = (LinearLayout)findViewById(R.id.reward);
        LinearLayout profile = (LinearLayout)findViewById(R.id.profile);

        electricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountActivity.this,ElectricityActivity.class);
                startActivity(intent);
            }
        });

        carbon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"WORKING FINE",Toast.LENGTH_LONG).show();
            }
        });

        rewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"WORKING FINE",Toast.LENGTH_LONG).show();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"WORKING FINE",Toast.LENGTH_LONG).show();
            }
        });


    }
}
