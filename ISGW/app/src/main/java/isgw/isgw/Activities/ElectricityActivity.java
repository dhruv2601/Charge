package isgw.isgw.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import isgw.isgw.Graphs.Realtime;
import isgw.isgw.R;

public class ElectricityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);
        loadRealtimeGraph();

    }

    private void loadRealtimeGraph() {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction txn=manager.beginTransaction();
        txn.add(R.id.real_graph_holder, new Realtime());
        txn.commit();
    }
}
