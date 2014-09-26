import java.util.Scanner;

public class CatException {
    static public void main(String[] args) {
	Scanner kbd = new Scanner(System.in);
	String possibleCat = "";

	System.out.print("What chases a mouse? ");
	try {
	    possibleCat = kbd.nextLine();

	    if(!possibleCat.equalsIgnoreCase("cat")) {
		throw new NotACatException("That is not how you spell cat");
	    }
	} catch(NotACatException e) {
	    System.out.println("Not a cat");
	}
    }
}

class NotACatException extends Exception {
    NotACatException() {}

    NotACatException(String msg) {
	super(msg);
    }
}