/*
Author: Michael Aldridge
Class: CS2336
Section: 001
Assignment: Homework 1, Question 3.A
*/

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;

public class Time {
    private int hour, minute, second;
    private long ts;

    public Time() {
	Calendar now = new GregorianCalendar();
	now.setTime(new Date(System.currentTimeMillis()));
	hour = now.get(Calendar.HOUR_OF_DAY);
	minute = now.get(Calendar.MINUTE);
	second = now.get(Calendar.SECOND);
    }

    public Time(long init) {
	Calendar now = new GregorianCalendar();
	now.setTime(new Date(init));
	hour = now.get(Calendar.HOUR_OF_DAY);
	minute = now.get(Calendar.MINUTE);
	second = now.get(Calendar.SECOND);
    }

    public Time(int hour, int minute, int second) {
	this.hour = hour;
	this.minute = minute;
	this.second = second;
    }

    public void setTime(long newTime) {
	Calendar now = new GregorianCalendar();
	now.setTime(new Date(newTime));
	hour = now.get(Calendar.HOUR_OF_DAY);
	minute = now.get(Calendar.MINUTE);
	second = now.get(Calendar.SECOND);
    }

    public int getHour() {
	return hour;
    }

    public int getMinute() {
	return minute;
    }

    public int getSecond() {
	return second;
    }
}