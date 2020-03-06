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

    public int Shift() {
            return this.id;
    }

    public void setid(int id) {
            this.id = id;
    }

    public String getdescription() {
            return this.description;
    }

    public void setdescription(String description) {
            this.description = description;
    }

    public LocalTime getstart() {
            return this.start;
    }

    public void setstart(LocalTime start) {
            this.start = start;
    }

    public LocalTime getstop() {
            return this.stop;
    }

    public void setstop(LocalTime stop) {
            this.stop = stop;
    }

    public int getgraceperiod() {
            return this.graceperiod;
    }

    public void setgraceperiod(int graceperiod) {
            this.start = start;
    }

    public int getinterval() {
            return this.interval;
    }

    public void setinterval(int interval) {
            this.interval = interval;
    }

    public int getdock() {
            return this.dock;
    }

    public void setdock(int dock) {
            this.dock = dock;
    }

    public LocalTime getlunchstart() {
            return this.lunchstart = lunchstart;
    }

    public void setlunchstart(LocalTime lunchstart) {
            this.lunchstart = lunchstart;
    }

    public LocalTime getlunchstop() {
            return this.lunchstop;
    }

    public void setlunchstop(LocalTime lunchstop) {
            this.lunchstop = lunchstop;
    }

    public int getlunchdeduct() {
            return this.lunchdeduct;
    }

    public void setlunchdeduct(int lunchdeduct) {
            this.lunchdeduct = lunchdeduct;
    }

}