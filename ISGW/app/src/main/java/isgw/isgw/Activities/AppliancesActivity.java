package isgw.isgw.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.ImageView;

import isgw.isgw.Graphs.Realtime;
import isgw.isgw.R;

public class AppliancesActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String GRAPH_TYPE="graph_type";
    public static final int AC=313,FRIDGE=314,BULB=315,WASH_M=316,HEATER=317,COMP=318;

    String acBeacon;
    String fridgeBeacon;
    String tvBeacon;
    String heaterBeacon;
    String wmBeacon;
    String lightBeacon;
    String smartMeterBeacon;

    ImageView acIW;
    ImageView fridgeIW;
    ImageView tvIW;
    ImageView heaterIW;
    ImageView wmIW;
    ImageView lightIW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliances);

        getSupportActionBar().hide();

        //CLICK LISTENERS
//        findViewById(R.id.air_c).setOnClickListener(this);
//        findViewById(R.id.heater).setOnClickListener(this);
//        findViewById(R.id.wash_m).setOnClickListener(this);
//        findViewById(R.id.bulb).setOnClickListener(this);
//        findViewById(R.id.comp).setOnClickListener(this);
//        findViewById(R.id.ref).setOnClickListener(this);

        acIW= (ImageView) findViewById(R.id.air_c);
        heaterIW= (ImageView) findViewById(R.id.heater);
        wmIW= (ImageView) findViewById(R.id.wash_m);
        lightIW= (ImageView) findViewById(R.id.bulb);
        tvIW= (ImageView) findViewById(R.id.comp);
        fridgeIW= (ImageView) findViewById(R.id.ref);

//        acIW.setOnClickListener(this);
//        heaterIW.setOnClickListener(this);
//        wmIW.setOnClickListener(this);
//        lightIW.setOnClickListener(this);
//        tvIW.setOnClickListener(this);
//        fridgeIW.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent  i=new Intent(getApplicationContext(),GraphZoomActivity.class);
        i.setAction(Realtime.INTENT_ACTION);
        switch (v.getId()) {
            case R.id.air_c:

                break;
            case R.id.ref:

                break;
            case R.id.bulb:

                break;
            case R.id.wash_m:

                break;
            case R.id.heater:

                break;
            case R.id.comp:

                break;
            default:
        }
        startActivity(i);
    }

    void setButtons(){
        if(acBeacon.equals("0")){
            acIW.setImageResource(R.drawable.acBW);
            acIW.setOnClickListener(null);
        }else{
            acIW.setImageResource(R.drawable.ac);
            acIW.setOnClickListener(this);
        }
        if(heaterBeacon.equals("0")){
            heaterIW.setImageResource(R.drawable.fireplaceBW);
            heaterIW.setOnClickListener(null);
        }else{
            heaterIW.setImageResource(R.drawable.fireplace);
            heaterIW.setOnClickListener(this);
        }
        if(wmBeacon.equals("0")){
            wmIW.setImageResource(R.drawable.wmBW);
            wmIW.setOnClickListener(null);
        }else {
            wmIW.setImageResource(R.drawable.wm);
            wmIW.setOnClickListener(this);
        }
        if(lightBeacon.equals("0")){
            lightIW.setImageResource(R.drawable.bulbBW);
            lightIW.setOnClickListener(null);
        }else{
            lightIW.setImageResource(R.drawable.bulb);
            lightIW.setOnClickListener(this);
        }
        if(tvBeacon.equals("0")){
            tvIW.setImageResource(R.drawable.computerBW);
            tvIW.setOnClickListener(null);
        }else{
            tvIW.setImageResource(R.drawable.computer);
        }
        if(fridgeBeacon.equals("0")){
            heaterIW.setImageResource(R.drawable.fireplaceBW);
            heaterIW.setOnClickListener(null);
        }else{
            heaterIW.setImageResource(R.drawable.fireplace);
            heaterIW.setOnClickListener(this);
        }
    }

}
