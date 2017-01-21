package isgw.isgw.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import isgw.isgw.Graphs.Realtime;
import isgw.isgw.R;

public class AppliancesActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String GRAPH_TYPE="graph_type";
    public static final int AC=313,FRIDGE=314,BULB=315,WASH_M=316,HEATER=317,COMP=318;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliances);

        getSupportActionBar().hide();

        //CLICK LISTENERS
        findViewById(R.id.air_c).setOnClickListener(this);
        findViewById(R.id.heater).setOnClickListener(this);
        findViewById(R.id.wash_m).setOnClickListener(this);
        findViewById(R.id.bulb).setOnClickListener(this);
        findViewById(R.id.comp).setOnClickListener(this);
        findViewById(R.id.ref).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent  i=new Intent(getApplicationContext(),GraphZoomActivity.class);
        i.setAction(Realtime.INTENT_ACTION);
        switch (v.getId()) {
            case R.id.air_c:
                i.putExtra(GRAPH_TYPE,AC);
                break;
            case R.id.ref:
                i.putExtra(GRAPH_TYPE,FRIDGE);
                break;
            case R.id.bulb:
                i.putExtra(GRAPH_TYPE,BULB);
                break;
            case R.id.wash_m:
                i.putExtra(GRAPH_TYPE,WASH_M);
                break;
            case R.id.heater:
                i.putExtra(GRAPH_TYPE,HEATER);
                break;
            case R.id.comp:
                i.putExtra(GRAPH_TYPE,COMP);
                break;
            default:
        }
        startActivity(i);
    }

}
