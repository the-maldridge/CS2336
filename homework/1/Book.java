/*
Author: Michael Aldridge
Class: CS2336
Section: 001
Assignment: Homework 1, Question 1.B
*/

public class Book {
    private String title;
    private String author;

    public Book () {}

    public Book(String title, String author) {
	this.title = title;
	this.author = author;
    }

    public String toString() {
	return title + '\n' + author;
    }
}