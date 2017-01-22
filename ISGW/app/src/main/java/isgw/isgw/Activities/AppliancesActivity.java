package isgw.isgw.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.parse.ParseException;
import com.parse.ParseUser;

import isgw.isgw.Graphs.Realtime;
import isgw.isgw.R;
import isgw.isgw.Server.SwitchParse;

public class AppliancesActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String GRAPH_TYPE="graph_type";
    public static final int AC=313,FRIDGE=314,BULB=315,WASH_M=316,HEATER=317,COMP=318;


    private void loadRealtimeGraph() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();
        txn.add(R.id.real_graph_holder, new Realtime());
        txn.commit();
    }

    private final Handler mHandler = new Handler();
    private Runnable t1;

    String acBeacon = "0";
    String fridgeBeacon = "0";
    String tvBeacon = "0";
    String heaterBeacon = "0";
    String wmBeacon = "0";
    String lightBeacon = "0";
    String smartMeterBeacon = "0";

    String acStat = "1";
    String fridgeStat = "1";
    String tvStat = "1";
    String heaterStat = "1";
    String wmStat = "1";
    String lightStat = "1";
    String meterStat = "1";

    ImageView acIW;
    ImageView fridgeIW;
    ImageView tvIW;
    ImageView heaterIW;
    ImageView wmIW;
    ImageView lightIW;

    Button mainsButton;

    private static final String TAG = "AppliaanceAct";
    ParseUser currUser = ParseUser.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliances);

        getSupportActionBar().hide();

        if (savedInstanceState == null){
            loadRealtimeGraph();
        }

        try {
            currUser = currUser.fetch();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        currUser.put("BtnSmartMeter","1");
        currUser.put("BtnAirconditioner", "1");
        currUser.put("BtnFridge", "1");
        currUser.put("BtnLighting", "1");
        currUser.put("BtnWashingMachine", "1");
        currUser.put("BtnHeater", "1");
        currUser.put("BtnTV", "1");

        currUser.saveInBackground();


        //CLICK LISTENERS
//        findViewById(R.id.air_c).setOnClickListener(this);
//        findViewById(R.id.heater).setOnClickListener(this);
//        findViewById(R.id.wash_m).setOnClickListener(this);
//        findViewById(R.id.bulb).setOnClickListener(this);
//        findViewById(R.id.comp).setOnClickListener(this);
//        findViewById(R.id.ref).setOnClickListener(this);

        acIW = (ImageView) findViewById(R.id.air_c);
        heaterIW = (ImageView) findViewById(R.id.heater);
        wmIW = (ImageView) findViewById(R.id.wash_m);
        lightIW = (ImageView) findViewById(R.id.bulb);
        tvIW = (ImageView) findViewById(R.id.comp);
        fridgeIW = (ImageView) findViewById(R.id.ref);
        mainsButton= (Button) findViewById(R.id.mains);

//        acIW.setOnClickListener(this);
//        heaterIW.setOnClickListener(this);
//        wmIW.setOnClickListener(this);
//        lightIW.setOnClickListener(this);
//        tvIW.setOnClickListener(this);
//        fridgeIW.setOnClickListener(this);


        t1 = new Runnable() {
            @Override
            public void run() {
                new getBeaconStatus().execute();
                mHandler.postDelayed(t1, 30 * 1000);
            }
        };
        mHandler.post(t1);
    }

    @Override
    public void onClick(View v) {
//        Intent  i=new Intent(getApplicationContext(),GraphZoomActivity.class);
        currUser = ParseUser.getCurrentUser();
        String prevOnOff;
        String sendingStatus;
        SwitchParse switchParse;

//        i.setAction(Realtime.INTENT_ACTION);
        switch (v.getId()) {
            case R.id.air_c:

                Log.d(TAG, "currUser: " + currUser.getUsername());
                prevOnOff = currUser.getString("BtnAirconditioner");
                sendingStatus = prevOnOff;
                if (prevOnOff == null) {
                    sendingStatus = "0";
                } else {
                    sendingStatus = invertStatus(prevOnOff);
                }
                switchParse = new SwitchParse(1, sendingStatus);
                switchParse.sendStatus();
                acStat = sendingStatus;
                new getBeaconStatus().execute();

                // i.putExtra(GRAPH_TYPE, AC);
                break;
            case R.id.ref:

                // i.putExtra(GRAPH_TYPE, FRIDGE);

                prevOnOff = currUser.getString("BtnFridge");
                sendingStatus = prevOnOff;
                if (prevOnOff == null) {
                    sendingStatus = "0";
                } else {
                    sendingStatus = invertStatus(prevOnOff);
                }
                switchParse = new SwitchParse(2, sendingStatus);
                switchParse.sendStatus();
                fridgeStat = sendingStatus;
                new getBeaconStatus().execute();

                break;
            case R.id.bulb:

                // i.putExtra(GRAPH_TYPE, BULB);

                prevOnOff = currUser.getString("BtnLighting");
                sendingStatus = prevOnOff;
                if (prevOnOff == null) {
                    sendingStatus = "0";
                } else {
                    sendingStatus = invertStatus(prevOnOff);
                }
                switchParse = new SwitchParse(3, sendingStatus);
                switchParse.sendStatus();

                lightStat = sendingStatus;
                new getBeaconStatus().execute();

                break;
            case R.id.wash_m:

                // i.putExtra(GRAPH_TYPE, WASH_M);

                prevOnOff = currUser.getString("BtnWashingMachine");
                sendingStatus = prevOnOff;
                if (prevOnOff == null) {
                    sendingStatus = "0";
                } else {
                    sendingStatus = invertStatus(prevOnOff);
                }
                switchParse = new SwitchParse(4, sendingStatus);
                switchParse.sendStatus();

                wmStat = sendingStatus;
                new getBeaconStatus().execute();

                break;
            case R.id.heater:

                // i.putExtra(GRAPH_TYPE, HEATER);

                prevOnOff = currUser.getString("BtnHeater");
                sendingStatus = prevOnOff;
                if (prevOnOff == null) {
                    sendingStatus = "0";
                } else {
                    sendingStatus = invertStatus(prevOnOff);
                }
                switchParse = new SwitchParse(5, sendingStatus);
                switchParse.sendStatus();

                heaterStat = sendingStatus;
                new getBeaconStatus().execute();

                break;
            case R.id.comp:

                // i.putExtra(GRAPH_TYPE, COMP);

                prevOnOff = currUser.getString("BtnTV");
                sendingStatus = prevOnOff;
                if (prevOnOff == null) {
                    sendingStatus = "0";
                } else {
                    sendingStatus = invertStatus(prevOnOff);
                }
                switchParse = new SwitchParse(6, sendingStatus);
                switchParse.sendStatus();

                tvStat = sendingStatus;
                new getBeaconStatus().execute();
                break;
            case R.id.mains:
                String smartBIGG = currUser.getString("BtnSmartMeter");
                String invert = invertStatus(smartBIGG);

                currUser.put("BtnSmartMeter",invert);
                currUser.put("BtnAirconditioner", invert);
                currUser.put("BtnFridge", invert);
                currUser.put("BtnLighting", invert);
                currUser.put("BtnWashingMachine", invert);
                currUser.put("BtnHeater", invert);
                currUser.put("BtnTV", invert);

                currUser.saveInBackground();

                acStat = invert;
                fridgeStat = invert;
                tvStat = invert;
                heaterStat = invert;
                wmStat = invert;
                lightStat = invert;
                meterStat = invert;

                new getBeaconStatus().execute();
                break;
            default:
        }
        //startActivity(i);
    }

    void setButtons() {
        if (acBeacon.equals("0")) {
            acIW.setImageResource(R.drawable.acbw);
            acIW.setOnClickListener(null);
        } else {
            if (acStat.equals("1"))
                acIW.setImageResource(R.drawable.ac);
            else
                acIW.setImageResource(R.drawable.acbw);
            acIW.setOnClickListener(this);
        }
        if (heaterBeacon.equals("0")) {
            heaterIW.setImageResource(R.drawable.fireplacebw);
            heaterIW.setOnClickListener(null);
        } else {
            if (heaterStat.equals("1"))
                heaterIW.setImageResource(R.drawable.fireplace);
            else
                heaterIW.setImageResource(R.drawable.fireplacebw);
            heaterIW.setOnClickListener(this);
        }
        if (wmBeacon.equals("0")) {
            wmIW.setImageResource(R.drawable.wmbw);
            wmIW.setOnClickListener(null);
        } else {
            if (wmStat.equals("1"))
                wmIW.setImageResource(R.drawable.wm);
            else
                wmIW.setImageResource(R.drawable.wmbw);
            wmIW.setOnClickListener(this);
        }
        if (lightBeacon.equals("0")) {
            lightIW.setImageResource(R.drawable.bulbw);
            lightIW.setOnClickListener(null);
        } else {
            if (lightStat.equals("1"))
                lightIW.setImageResource(R.drawable.bulb);
            else
                lightIW.setImageResource(R.drawable.bulbw);
            lightIW.setOnClickListener(this);
        }
        if (tvBeacon.equals("0")) {
            tvIW.setImageResource(R.drawable.computerbw);
            tvIW.setOnClickListener(null);
        } else {
            if (tvStat.equals("1"))
                tvIW.setImageResource(R.drawable.computer);
            else
                tvIW.setImageResource(R.drawable.computerbw);
            tvIW.setOnClickListener(this);
        }
        if (fridgeBeacon.equals("0")) {
            fridgeIW.setImageResource(R.drawable.refbw
            );
            fridgeIW.setOnClickListener(null);
        } else {
            if (fridgeStat.equals("1"))
                fridgeIW.setImageResource(R.drawable.ref);
            else
                fridgeIW.setImageResource(R.drawable.refbw);
            fridgeIW.setOnClickListener(this);
        }
        if(smartMeterBeacon.equals("0")){
            mainsButton.setBackgroundColor(Color.GRAY);
            mainsButton.setOnClickListener(null);
        }else{
            if(meterStat.equals("1")){
                mainsButton.setBackgroundColor(Color.RED);
            }else{
                mainsButton.setBackgroundColor(Color.GREEN);
            }
            mainsButton.setOnClickListener(this);
        }
    }

    private String invertStatus(String i) {
        String s;
        if (i.equals("0")) {
            s = "1";
        } else {
            s = "0";
        }
        return s;
    }

    public class getBeaconStatus extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                currUser = currUser.fetch();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            acBeacon = currUser.getString("Airconditioner");
            fridgeBeacon = currUser.getString("Fridge");
            lightBeacon = currUser.getString("Lighting");
            heaterBeacon = currUser.getString("Heater");
            tvBeacon = currUser.getString("TV");
            wmBeacon = currUser.getString("WashingMachine");
            smartMeterBeacon = currUser.getString("SmartMeter");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setButtons();
        }
    }


}
