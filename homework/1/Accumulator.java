/*
Author: Michael Aldridge
Class: CS2336
Section: 001
Assignment: Homework 1, Question 1.D
*/

public class Accumulator {
    private int sum =0;

    public int getSum() {
	return sum;
    }

    public void add(int toAdd) {
	sum = sum + toAdd;
    }
}