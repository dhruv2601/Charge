package isgw.isgw.Activities;

import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.Collection;

import isgw.isgw.R;

public class ScanningActivity extends AppCompatActivity implements BeaconConsumer {

    private BeaconManager beaconManager;
    private static final String TAG = "ScanningActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning);
        beaconManager = BeaconManager.getInstanceForApplication(this.getApplicationContext());
       beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout(BeaconParser.EDDYSTONE_UID_LAYOUT));
        beaconManager.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.unbind(this);
    }

    @Override
    public void onBeaconServiceConnect() {
        //Identifier myBeaconNamespaceId = Identifier.parse("0x99d462bd1cff8053ecbc");
        Identifier myBeaconNamespaceId = Identifier.parse("0xb8ed0f35da2d8a65c6ef");
        Identifier myBeaconInstanceId = Identifier.parse("0x000000000002");
//        Identifier myBeaconNamespaceId = null;
//        Identifier myBeaconInstanceId = null;
        Region region = new Region("my-beacon-region", myBeaconNamespaceId, myBeaconInstanceId, null);
        Log.d(TAG, "onBeaconServiceConnect: "+beaconManager.toString());
        beaconManager.addMonitorNotifier(new MonitorNotifier() {
            @Override
            public void didEnterRegion(Region region) {
                Log.d(TAG, "sjI detected a beacon in the region with namespace id "
                        + region.getId1() + " and instance id: " + region.getId2());
            }

            @Override
            public void didExitRegion(Region region) {
                Log.d(TAG, "sjI lost a beacon in the region with namespace id "
                        + region.getId1() + " and instance id: " + region.getId2());
            }

            @Override
            public void didDetermineStateForRegion(int i, Region region) {

            }
        });
//        try {
//            beaconManager.startMonitoringBeaconsInRegion(region);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
        beaconManager.addRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                if (beacons.size() > 0) {
                    Log.i(TAG, "sjThe first beacon I see is about "+beacons.iterator().next().getTxPower()+" meters away.");
                }
            }
        });
        try {
            beaconManager.startRangingBeaconsInRegion(region);
        } catch (RemoteException e) {    }
    }
}
