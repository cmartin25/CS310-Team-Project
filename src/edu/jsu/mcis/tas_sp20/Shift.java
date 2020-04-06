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

    public void setID(int id) {
            this.id = id;
    }

    public String getDescription() {
            return this.description;
    }

    public void setDescription(String description) {
            this.description = description;
    }

    public LocalTime getStart() {
            return this.start;
    }

    public void setStart(LocalTime start) {
            this.start = start;
    }

    public LocalTime getStop() {
            return this.stop;
    }

    public void setStop(LocalTime stop) {
            this.stop = stop;
    }

    public int getGracePeriod() {
            return this.graceperiod;
    }

    public void setGracePeriod(int graceperiod) {
            this.start = start;
    }

    public int getInterval() {
            return this.interval;
    }

    public void setInterval(int interval) {
            this.interval = interval;
    }

    public int getdock() {
            return this.dock;
    }

    public void setdock(int dock) {
            this.dock = dock;
    }

    public LocalTime getLunchStart() {
            return this.lunchstart = lunchstart;
    }

    public void setLunchStart(LocalTime lunchstart) {
            this.lunchstart = lunchstart;
    }

    public LocalTime getLunchStop() {
            return this.lunchstop;
    }

    public void setLunchStop(LocalTime lunchstop) {
            this.lunchstop = lunchstop;
    }

    public int getLunchDeduct() {
            return this.lunchdeduct;
    }

    public void setLunchDeduct(int lunchdeduct) {
            this.lunchdeduct = lunchdeduct;
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