/*
Author: Michael Aldridge
Class: CS2336
Section: 001
Assignment: Homework 1, Question 3.B
*/

public class TestTime {
    public static void main(String[] args) {
	// we need more time!
	Time t1 = new Time();
	Time t2 = new Time(555550000);

	System.out.println("Information about time:");

	//show the first time object
	System.out.println("Time object 1 (default constructor): " + t1.getHour() + ":" + t1.getMinute() + ":" + t1.getSecond());

	//show the second time object
	System.out.println("Time object 2 (specified time): " + t2.getHour() + ":" + t2.getMinute() + ":" + t2.getSecond());
    }
}