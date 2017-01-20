package isgw.isgw.Graphs;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

/**
 * Created by vishal on 1/20/17.
 */

public class Realtime extends Fragment {

    private final Handler mHandler = new Handler();
    private Runnable t1, t2;
    private LineGraphSeries<DataPoint> series1, series2;
    private double graph2LastXVal;
    GraphView

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onResume() {
        super.onResume();
        t1 = new Runnable() {
            @Override
            public void run() {
                series1.resetData(retrieveData());
                mHandler.postDelayed(this, 300);
            }
        };

        mHandler.postDelayed(t1,300);
        
        t2=new Runnable() {
            @Override
            public void run() {

            }
        }

    }

    @Override
    public void onPause() {
        super.onPause();
    }


    /**
     * This function retrieves data form server
     *
     * @return set of data points to be plotted
     */
    private DataPoint[] retrieveData() {
        //sample data generator
        DataPoint[] val = new DataPoint[30];
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            double xCoord = i;
            //double f=r.nextDouble()*0.675 + 0.35;
            double yCoord = Math.abs(r.nextDouble() * (xCoord / (1 << i)));

            val[i] = new DataPoint(xCoord, yCoord);
        }
        return val;
    }


}
