package isgw.isgw.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import isgw.isgw.Graphs.BarGraph;
import isgw.isgw.Graphs.Realtime;


import isgw.isgw.R;

public class ElectricityActivity extends AppCompatActivity {

    private static final String TAG = "ElectricityActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);

        getSupportActionBar().hide();

        if (savedInstanceState==null) {
            loadRealtimeGraph();
            loadBarGraph();
        }
    }

    private void loadRealtimeGraph() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();
        txn.add(R.id.real_graph_holder, new Realtime());
        txn.commit();
    }

    private void loadBarGraph() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();
        txn.add(R.id.bar_graph_holder, new BarGraph());
        txn.commit();
    }

}
