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
    Long originaltimestamp;
    
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
    
    public String printOriginaltimestamp(){
        String s = "#";
        String badgeid = this.badge.getBadgeID();
        s += badgeid;
        
        switch (this.getPunchTypeID()){
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
    
    public void adjust(Shift s) {
       
        
    }
    
    public String printAdjustedTimestamp() {
        String s = "";
        s = "Badge #: " + this.getBadge();
        return s;
    }

    String getBadgeid() {
        return this.badge.getBadgeID();
    }
    
}
    