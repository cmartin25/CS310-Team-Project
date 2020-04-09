package edu.jsu.mcis.tas_sp20;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.time.*;
import java.util.GregorianCalendar;

public class Punch {
    int terminalid, id, punchtypeid;
    Badge badge;
    String adjustmenttype;
    Long originaltimestamp, adjustedtimestamp;
    
    Punch(Badge badge, int terminalid, int punchtypeid){
        id = 0;   
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtypeid = punchtypeid;
        adjustmenttype = null;
        this.originaltimestamp = System.currentTimeMillis();
    }
    
    Punch(int terminalid, Badge badge, Long timestamp, int punchtypeid){
        id = 0;   
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtypeid = punchtypeid;
        adjustmenttype = null;
        this.originaltimestamp = timestamp;
    }

    Punch(int id, int terminalid, Badge badge, long timestamp, int punchtypeid) {
        this.id = id;   
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtypeid = punchtypeid;
        adjustmenttype = null;
        this.originaltimestamp = timestamp;
    }
    
    //Set Methods
    public void setBadge(Badge badge){
        this.badge = badge;
    }
    
    public void setPunchTypeID(int punchtypeid){
        this.punchtypeid = punchtypeid;
    }
        
    public void setID(int id){
        this.id = id;
    }
    
    public void setTerminalID(int terminalid){
        this.terminalid = terminalid;
    }
    
    public void setAdjustmentType(String adjustmenttype){
        this.adjustmenttype = adjustmenttype;
    }
    
    public void setOriginalTimeStamp(Long originaltimestamp){
        this.originaltimestamp = originaltimestamp;
    }
    
    public void setAdjustedTimestamp(Long adjustedtimestamp){
        this.adjustedtimestamp = adjustedtimestamp;
    }
    
    //Getter methods
    public Badge getBadge(){
        return this.badge;
    }
    
    public int getID(){
        return this.id;
    }
    
    public int getPunchtypeid(){
        return this.punchtypeid;
    }
    
    public Long getOriginaltimestamp(){
        return this.originaltimestamp;
    }
    
    public int getTerminalid(){
        return this.terminalid;
    }
    
    public String getAdjustmentType(){
        return this.adjustmenttype;
    }
    
    public Long getAdjustedTimestamp(){
        return this.adjustedtimestamp;
    }
    
     public String getBadgeID() {
        return this.badge.getBadgeID();
    }
    
     
    public void adjust(Shift s) {
        
        long shiftInterval = s.getInterval() * 60000;
        long shiftDock = s.getDock() * 60000;
        long shiftGrace = s.getGracePeriod() * 60000;
        
       
       //Creates orginal calendar and converts shfit times to GC and Long objects
        GregorianCalendar orginialCalender = new GregorianCalendar();
            orginialCalender.setTimeInMillis(this.getOriginaltimestamp());
            orginialCalender.clear(GregorianCalendar.SECOND);
        Long punchTime = orginialCalender.getTimeInMillis();
        
        //Pulls from orginial calendar
        //Shifts
        GregorianCalendar startGC = (GregorianCalendar) orginialCalender.clone();
        startGC.set(GregorianCalendar.HOUR_OF_DAY, s.getStart().getHour());
        startGC.set(GregorianCalendar.MINUTE, s.getStart().getMinute());
        Long shiftStart = startGC.getTimeInMillis();
        
        GregorianCalendar stopGC = (GregorianCalendar) orginialCalender.clone();
        stopGC.set(GregorianCalendar.HOUR_OF_DAY, s.getStop().getHour());
        stopGC.set(GregorianCalendar.MINUTE, s.getStop().getMinute());
        Long shiftStop = stopGC.getTimeInMillis();
        
        //Lunchs
        GregorianCalendar lunchStartGC = (GregorianCalendar) orginialCalender.clone();
        lunchStartGC.set(GregorianCalendar.HOUR_OF_DAY, s.getStop().getHour());
        lunchStartGC.set(GregorianCalendar.MINUTE, s.getStop().getMinute());
        Long lunchStart = lunchStartGC.getTimeInMillis();
        
        GregorianCalendar lunchStopGC = (GregorianCalendar) orginialCalender.clone();
        lunchStopGC.set(GregorianCalendar.HOUR_OF_DAY, s.getStop().getHour());
        lunchStopGC.set(GregorianCalendar.MINUTE, s.getStop().getMinute());
        Long lunchStop = lunchStopGC.getTimeInMillis();
        
        
        //Checks is punch lands on a Saturday or Sunday 
        if ((orginialCalender.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SATURDAY) && (orginialCalender.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.SUNDAY)){
            
            }
        }
    
    
    public String printOriginalTimestamp(){
        String s = "#";
        String badgeid = this.badge.getBadgeID();
        s += badgeid;
        
        switch (this.getPunchtypeid()){
            case 0:
                s += " CLOCKED OUT: ";
                break;
            case 1:
                s += " CLOCKED IN: ";
                break;
            case 2:
                s += " TIMED OUT: ";
        }
        
        DateFormat df = new SimpleDateFormat("EEE MM/dd/yyyy HH:mm:ss");
        Date d = new Date(this.originaltimestamp);
        
        s += (df.format(d)).toUpperCase();
        
        
        return s;
    }
    
    public String printAdjustedTimestamp() {
        String s = "";
        s = "Badge #: " + this.getBadge();
        return s;
    }
    
}
    