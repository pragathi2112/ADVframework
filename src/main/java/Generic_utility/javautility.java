package Generic_utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautility {

    // Generate random number
    public int togetrandomnum()
    {
        Random r = new Random();

        int newnum = r.nextInt(1000);

        return newnum;
    }

    // Get current date
    public String togetcurrentdate()
    {
        Date d = new Date();

        SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");

        String currentdate = sim.format(d);

        return currentdate;
    }

    // Get required date
    public String togetreqdate(int days)
    {
        Date d = new Date();

        SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");

        sim.format(d);

        Calendar cal = sim.getCalendar();

        cal.add(Calendar.DAY_OF_MONTH, days);

        String reqdate = sim.format(cal.getTime());

        return reqdate;
    }
}