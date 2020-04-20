package edu.jsu.mcis.tas_sp20;

import java.util.ArrayList;

public class TASLogic {
    
    public static final int CLOCKIN = 1;
    public static final int CLOCKOUT = 0;
    
    public static int calculateTotalMinutes(ArrayList<Punch> dailypunchlist, 
            Shift shift) {

        int totalMinutes = 0;
        int punchCounter = 0;
        int lunchBreak = 30;
        long timeIn = 0;
        long timeOut = 0;
        long totalInMillis = 0;

        for(int i = 0; i < dailypunchlist.size(); i++) {
           if (dailypunchlist.get(i).getPunchTypeID() == CLOCKIN) {
               timeIn = dailypunchlist.get(i).getAdjustedTimeStamp();
               punchCounter++;
               continue;
           }
           
           if (dailypunchlist.get(i).getPunchTypeID() == CLOCKOUT) {
               timeOut = dailypunchlist.get(i).getAdjustedTimeStamp();
               punchCounter++;
           }

           if (timeIn != 0 && timeOut != 0) {
               totalInMillis += timeOut - timeIn;
           }
           timeIn = 0;
           timeOut = 0;
        }

        if (totalInMillis != 0) {
            totalMinutes = (int) (totalInMillis/60000);
        }

        if (totalMinutes > shift.getLunchDeduct() && punchCounter <= 3) {
            totalMinutes -= lunchBreak;
        }
        return totalMinutes;
    }    

}
