package isgw.isgw.Activities;

import com.parse.ParseObject;

import java.sql.Time;
import java.util.Date;

/**
 * Created by dhruv on 20/1/17.
 */

public class SendToParse {

    private Date date;
    private Time time;
    private String appliance;
    private int unitsConsumed;
    private int hoursUsed;

    private String userName;

    public SendToParse(Date date, Time time, String appliance, int unitsConsumed, int hoursUsed) {
        this.date = date;
        this.time = time;
        this.appliance = appliance;
        this.hoursUsed = hoursUsed;
        this.unitsConsumed = unitsConsumed;
    }

    ParseObject parseObject = new ParseObject("User");

}
