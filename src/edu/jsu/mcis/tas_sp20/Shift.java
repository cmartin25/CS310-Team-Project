package edu.jsu.mcis.tas_sp20;

import java.util.*;

public class Shift {

private int id;
private String description;
private GregorianCalendar start; //these GregorianCalendar objects should only contain time values and only compared against their time instance variables!
private GregorianCalendar stop;
private int interval;
private int graceperiod;
private int dock;
private GregorianCalendar lunchstart;
private GregorianCalendar lunchstop;
private int lunchdeduct;

public Shift(int id, String description, GregorianCalendar start, GregorianCalendar stop, int interval, int graceperiod, int dock, GregorianCalendar lunchstart, GregorianCalendar lunchstop, int lunchdeduct) {
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

public GregorianCalendar getstart() {
	return this.start;
}

public void setstart(GregorianCalendar start) {
	this.start = start;
}

public GregorianCalendar getstop() {
	return this.stop;
}

public void setstop(GregorianCalendar stop) {
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

public GregorianCalendar getlunchstart() {
	return this.lunchstart;
}

public void setlunchstart(GregorianCalendar lunchstart) {
	this.lunchstart = lunchstart;
}

public GregorianCalendar getlunchstop() {
	return this.lunchstop;
}

public void setlunchstop(GregorianCalendar lunchstop) {
	this.lunchstop = lunchstop;
}

public int getlunchdeduct() {
	return this.lunchdeduct;
}

public void setlunchdeduct(int lunchdeduct) {
	this.lunchdeduct = lunchdeduct;
}



}