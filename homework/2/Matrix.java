/*
Author: Michael Aldridge
Class: CS2336
Section: 001
Assignment: Homework 2, Question 1
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Matrix {
    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	Random rand = new Random();

	// make a matrix of the appropriate size
	System.out.print("Input a size for the square matrix: ");
	int matrixSize = keyboard.nextInt();
	int[][] matrix = new int[matrixSize][matrixSize];

	//fill said matrix with 1's and 0's
	for(int i=0; i<matrix.length; i++) {
	    for(int j=0; j<matrix[i].length; j++) {
		matrix[i][j] = ((rand.nextInt()%2==1)?1:0); //place either a 1 or a 0 at the index
	    }
	}

	//print the matrix
	for(int i=0; i<matrix.length; i++) {
	    for(int j=0; j<matrix[i].length; j++) {
		System.out.print(matrix[i][j] + " ");
	    }
	    System.out.print('\n');
	}

	//its worth pointing out that the following method doesn't actually detect the edge case
	//of when there are the same number of rows in multiple columns, in this case it will simply
	//select the first instance of a maximum it comes too.  While this is a flawed approach, I am
	//not certain it can be easily solved without substantial restructuring, and the assignment
	//does not have any statements that this case should be accounted for.

	//figure out which row has the most ones
	int rowCount = 0;
	int rowMax = 0;
	int rowMaxIndex = 0;

	for(int i=0; i<matrix.length; i++) {
	    rowCount = 0; //reset row count each time

	    for(int j=0; j<matrix[i].length; j++) {
		rowCount += matrix[i][j];
	    }

	    if(rowCount > rowMax) { //if the current row has more than the max, save it instead
		rowMax = rowCount;
		rowMaxIndex = i;
	    }
	}
	System.out.println("The row with the most 1's is row " + (rowMaxIndex+1) + ".");

	//figure out which column has the most ones (same as above)
	int colCount = 0;
	int colMax = 0;
	int colMaxIndex = 0;

	for(int i=0; i<matrix.length; i++) {
	    colCount = 0;

	    for(int j=0; j<matrix[i].length; j++) {
		colCount += matrix[j][i];
	    }

	    if(colCount > colMax) {
		colMax = colCount;
		colMaxIndex = i;
	    }
	}
	System.out.println("The column with the most 1's is column " + (colMaxIndex+1) + ".");
	System.out.println("These are displayed below:");

	
	//finally split out the array and columns with the most and show only those;
	for(int i=0; i<matrix.length; i++) {
	    for(int j=0; j<matrix[i].length; j++) {
		if((j != colMaxIndex) && (i != rowMaxIndex)) { //if both are met blank the number
		    System.out.print("  "); //need to print spaces to keep the spacing
		    continue;
		} else {
		    System.out.print(matrix[i][j] + " ");
		}	
	    }
	    System.out.print('\n');
	}
    }
}