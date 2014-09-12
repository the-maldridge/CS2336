/*
Author: Michael Aldridge
Class: CS2336
Section: 001
Assignment: Homework 1, Question 1.A
*/

public class Counter {
    private int counter;

    public Counter() {}

    public Counter(int initial) {
	counter = initial;
    }

    public void increment() {
	counter++;
    }

    public void decrement() {
	counter--;
    }

    public int getValue() {
	return counter;
    }
}