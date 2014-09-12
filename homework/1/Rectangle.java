/*
Author: Michael Aldridge
Class: CS2336
Section: 001
Assignment: Homework 1, Question 2.A
*/

public class Rectangle {
    private double width=1, height=1;

    public Rectangle() {} //as the w/h are already set, no work needs to occur here

    public Rectangle(double width, double height) {
	this.width = width;
	this.height = height;
    }

    public double getWidth() {
	return width;
    }

    public double getHeight() {
	return height;
    }

    public double getArea() {
	return width * height;
    }

    public double getPerimeter() {
	return 2 * width + 2 * height;
    }
}
