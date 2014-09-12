/*
Originating Author: Ebru Cankaya
Author: Michael Aldridge
Class: CS2336
Section: 001
Assignment: Homework 1, Question 2.B
*/

public class TestShape {
    /** Main method */
    public static void main(String[] args) {
	// Create a circle with radius 1
	Circle circle1 = new Circle();
	System.out.println("The area of the circle of radius "
			   + circle1.radius + " is " + circle1.getArea());

	// Create a circle with radius 25
	Circle circle2 = new Circle(25);
	System.out.println("The area of the circle of radius "
			   + circle2.radius + " is " + circle2.getArea());

	// Create a circle with radius 125
	Circle circle3 = new Circle(125);
	System.out.println("The area of the circle of radius "
			   + circle3.radius + " is " + circle3.getArea());

	// Modify circle radius
	circle2.radius = 100; // or circle2.setRadius(100)
	System.out.println("The area of the circle of radius "
			   + circle2.radius + " is " + circle2.getArea());


	// Now do stuff with rectangles!
	Rectangle r1 = new Rectangle(4, 40);
	Rectangle r2 = new Rectangle(3.5, 35.9);

	//Get the stuff for the first rectangle
	System.out.println("Rectangle 1:"
			   + "\n\tWidth: " + r1.getWidth()
			   + "\n\tHeight: " + r1.getHeight()
			   + "\n\tArea: " + r1.getArea()
			   + "\n\tPerimeter: " + r1.getPerimeter());

	//Get the stuff for the second rectangle
	System.out.println("Rectangle 2:"
			   + "\n\tWidth: " + r2.getWidth()
			   + "\n\tHeight: " + r2.getHeight()
			   + "\n\tArea: " + r2.getArea()
			   + "\n\tPerimeter: " + r2.getPerimeter());
    }
}