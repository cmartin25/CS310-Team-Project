package edu.jsu.mcis.tas_sp20;

import java.util.*;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;

public class Shift {
    private int id;
    private String description;
    private LocalTime start;
    private LocalTime stop;
    private int interval;
    private int graceperiod;
    private int dock;
    private LocalTime lunchstart;
    private LocalTime lunchstop;
    private int lunchdeduct;

    public Shift(int id, String description, LocalTime start, 
        LocalTime stop, int interval, int graceperiod, int dock,
        LocalTime lunchstart, LocalTime lunchstop,
        int lunchdeduct) {
        this.id = id;
        this.description = description;
        this.start = start;
        this.stop = stop;
        this.interval = interval;
        this.graceperiod = graceperiod;
        this.dock = dock;
        this.lunchstart = lunchstart;
        this.lunchstop = lunchstop;
        this.lunchdeduct = lunchdeduct;
    }

    public int Shift() {
            return this.id;
    }

    //Set methods
    public void setID(int id) {
            this.id = id;
    }

    public void setDescription(String description) {
            this.description = description;
    }

    public void setInterval(int interval) {
            this.interval = interval;
    }
    
    public void setStart(LocalTime start) {
            this.start = start;
    }

    public void setStop(LocalTime stop) {
            this.stop = stop;
    }
    
    public void setGracePeriod(int graceperiod) {
            this.start = start;
    }
    
    public void setDock(int dock) {
            this.dock = dock;
    }
    
    public void setLunchStart(LocalTime lunchstart) {
        this.lunchstart = lunchstart;
    }

    public void setLunchStop(LocalTime lunchstop) {
            this.lunchstop = lunchstop;
    }
    
    public void setLunchDeduct(int lunchdeduct) {
        this.lunchdeduct = lunchdeduct;
    }

    //Getter methods
    public String getDescription() {
        return this.description;
    }
    
    public int getInterval() {
            return this.interval;
    }

    public LocalTime getStart() {
            return this.start;
    }
    
    public LocalTime getStop() {
            return this.stop;
    }
    
    public int getGracePeriod() {
            return this.graceperiod;
    }
    
    public int getDock() {
            return this.dock;
    }

    public LocalTime getLunchStart() {
            return this.lunchstart = lunchstart;
    }

    public LocalTime getLunchStop() {
            return this.lunchstop;
    }

    public int getLunchDeduct() {
            return this.lunchdeduct;
    }
    
    @Override
    public String toString(){
        
        long startMinutes = start.until(stop, MINUTES);
        long startLunchMinutes = lunchstart.until(lunchstop, MINUTES);
        
        String shift = description + ": " + start + " - " + stop + " (" 
        + startMinutes + " minutes); Lunch: " + 
        lunchstart + " - " + lunchstop + " (" 
        + startLunchMinutes + " minutes)";
        
        return shift;
        
    }
    
}