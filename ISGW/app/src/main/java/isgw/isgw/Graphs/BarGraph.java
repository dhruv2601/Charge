package isgw.isgw.Graphs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import isgw.isgw.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarGraph extends Fragment {

    public static final String INTENT_ACTION="BarGraph";
    private GraphView gView;
    private DataPoint[] pt;
    private BarGraphSeries<DataPoint> series;
    private StaticLabelsFormatter label;
    public BarGraph() {
        // Required empty public constructor
        pt = new DataPoint[12];
        for (int i = 0; i < 12; i++) {
            pt[i] = new DataPoint(i, (i*97+17)%6);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rView = inflater.inflate(R.layout.fragment_bar_graph, container, false);
        series=new BarGraphSeries<>(pt);
        series.setSpacing(50);
        series.setDrawValuesOnTop(true);
        series.setAnimated(true);
        series.setTitle("Yearly Unit Consumption");

        gView = (GraphView) rView.findViewById(R.id.bar_graph);
        gView.addSeries(series);

        label=new StaticLabelsFormatter(gView);
        label.setHorizontalLabels(new String[]{
                "JAN",
                "FEB",
                "MAR",
                "APR",
                "MAY",
                "JUN",
                "JUL",
                "AUG",
                "SEP",
                "OCT",
                "NOV",
                "DEC"
        });
        gView.getGridLabelRenderer().setLabelFormatter(label);
        gView.getLegendRenderer().setVisible(true);
        gView.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        return rView;
    }

    //inflate data
    private void retrieveData() {
        //call gView from here
    }
}
