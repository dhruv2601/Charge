package isgw.isgw.Activities;

import android.app.ProgressDialog;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.parse.ParseUser;

import isgw.isgw.R;

public class RewardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        getSupportActionBar().hide();

        final TextView currentUsage = (TextView) findViewById(R.id.textView8);
        final TextView limitUsage = (TextView) findViewById(R.id.textView12);
        final TextView rewards = (TextView) findViewById(R.id.textView15);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("");
        progressDialog.setMessage("Fetching Data");
        progressDialog.show();

        new CountDownTimer(2000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                progressDialog.dismiss();

                if (ParseUser.getCurrentUser()!=null){
                    if (ParseUser.getCurrentUser().get("name").equals("sid")){

                    } else {
                        currentUsage.setText("0.00 kW");
                        limitUsage.setText("0.00 kW");
                        rewards.setText("0");
                    }
                }
            }
        }.start();


    }
}
