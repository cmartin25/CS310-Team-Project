package edu.jsu.mcis.tas_sp20;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Punch {
    int id, terminalid, punchtypeid;
    Badge badge;
    Long originaltimestamp;
    String adjustmenttype;
    
    Punch(Badge badge, int terminalid, int punchtypeid){
        id = 0;   
        adjustmenttype = null;
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtypeid = punchtypeid;
        this.originaltimestamp = System.currentTimeMillis();
    }
    
    Punch(int terminalid, Badge badge, Long timestamp, int punchtypeid){
        id = 0;   
        adjustmenttype = null;
        this.terminalid = terminalid;
        this.badge = badge;
        this.punchtypeid = punchtypeid;
        this.originaltimestamp = timestamp;
    }
    
    public void setBadge(Badge badge){
        this.badge = badge;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public void setTerminalID(int terminalid){
        this.terminalid = terminalid;
    }
    
    public void setPunchTypeID(int punchtypeid){
        this.punchtypeid = punchtypeid;
    }
    
    public void setOriginalTimeStamp(Long originaltimestamp){
        this.originaltimestamp = originaltimestamp;
    }
    
    public void setAdjustmentType(String adjustmenttype){
        this.adjustmenttype = adjustmenttype;
    }
    
    public Badge getBadge(){
        return this.badge;
    }
    
    public int getID(){
        return this.id;
    }
    
    public int getTerminalID(){
        return this.terminalid;
    }
    
    public int getPunchTypeID(){
        return this.punchtypeid;
    }
    
    public Long getOriginalTimeStamp(){
        return this.originaltimestamp;
    }
    
    public String getAdjustmentType(){
        return this.adjustmenttype;
    }
    
    public String printOriginalTimestamp(){
        String s = "";
        
        s = "#" + (this.getBadge()).getID();
        
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
    
}
