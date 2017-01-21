package isgw.isgw.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import isgw.isgw.Graphs.BarGraph;
import isgw.isgw.Graphs.Realtime;
import isgw.isgw.R;

public class GraphZoomActivity extends AppCompatActivity {

    private static final String TAG = "GraphZoomActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_zoom);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Intent i = getIntent();
        FragmentManager manager = getSupportFragmentManager();

        if (savedInstanceState == null)
            switch (i.getAction()) {
                case Realtime.INTENT_ACTION:
                    FragmentTransaction txn = manager.beginTransaction();
                    txn.replace(R.id.activity_graph_zoom, new Realtime());
                    txn.commit();
                    Log.d(TAG, "onCreate: matched " + Realtime.INTENT_ACTION);
                    break;
                case BarGraph.INTENT_ACTION:
                    FragmentTransaction txn1 = manager.beginTransaction();
                    txn1.replace(R.id.activity_graph_zoom, new BarGraph());
                    txn1.commit();
                    Log.d(TAG, "onCreate: matched " + BarGraph.INTENT_ACTION);
                    break;
                default:
                    Log.d(TAG, "onCreate: no match found");
            }
    }
}
