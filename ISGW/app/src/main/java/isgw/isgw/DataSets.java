package isgw.isgw;

import java.util.HashMap;

/**
 * Created by vishal on 1/21/17.
 */

public class DataSets {


    static HashMap<Double, Double> monthlyElectricityData() {
        HashMap<Double, Double> map = new HashMap<>();
        map.put(1d, 801d);
        map.put(2d, 777d);
        map.put(3d, 1000d);
        map.put(4d, 1203d);
        map.put(5d, 1300d);
        map.put(6d, 1350d);
        map.put(7d, 1400d);
        map.put(8d, 1389d);
        map.put(9d, 1117d);
        map.put(10d, 931d);
        map.put(11d, 815d);
        map.put(12d, 707d);

        return map;
    }

    static void liveData() {

    }


}
