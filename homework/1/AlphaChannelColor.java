/*
Author: Michael Aldridge
Class: CS2336
Section: 001
Assignment: Homework 1, Question 1.C
*/

public class AlphaChannelColor extends Color {
    private int alpha;

    public void dissolve() {
	alpha++;
	this.setRed(this.getRed()++);
	this.setGreen(this.getGreen()++);
	this.setBlue(this.getBlue()++);
    }
}