package edu.jsu.mcis.tas_sp20;

import java.util.*;
import java.time.LocalTime;

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
        this.description=description;
        this.start = start;
        this.stop = stop;
        this.interval = interval;
        this.graceperiod = graceperiod;
        this.dock = dock;
        this.lunchstart = lunchstart;
        this.lunchstop = lunchstop;
        this.lunchdeduct = lunchdeduct;
            
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getStop() {
        return stop;
    }

    public void setStop(LocalTime stop) {
        this.stop = stop;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getGraceperiod() {
        return graceperiod;
    }

    public void setGraceperiod(int graceperiod) {
        this.graceperiod = graceperiod;
    }

    public int getDock() {
        return dock;
    }

    public void setDock(int dock) {
        this.dock = dock;
    }

    public LocalTime getLunchstart() {
        return lunchstart;
    }

    public void setLunchstart(LocalTime lunchstart) {
        this.lunchstart = lunchstart;
    }

    public LocalTime getLunchstop() {
        return lunchstop;
    }

    public void setLunchstop(LocalTime lunchstop) {
        this.lunchstop = lunchstop;
    }

    public int getLunchdeduct() {
        return lunchdeduct;
    }

    public void setLunchdeduct(int lunchdeduct) {
        this.lunchdeduct = lunchdeduct;
    }

    
    //"Shift 1: 07:00 - 15:30 (510 minutes); Lunch: 12:00 - 12:30 (30 minutes)"
    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder("Shift ");
        s.append(this.getId()).append(": ").append(getStart().toString());
        s.append(" - ").append(getStop().toString()).append(" (510 minutes); ");
        s.append("Lunch: ").append(getLunchstart().toString()).append(" - ");
        s.append(getLunchstop().toString()).append(" (30 minutes)");
        
        return s.toString();
        
    }

}