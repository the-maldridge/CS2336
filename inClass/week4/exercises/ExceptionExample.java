import java.util.InputMismatchException;
import java.util.Scanner;

class ExceptionExample {
    public static void main(String[] args) {
	Scanner kbd = new Scanner(System.in);
	int foo = 0;
	while(true) {
	    try {
		System.out.print("Input an integer: ");
		foo = kbd.nextInt();
		if(foo != (int)foo) {
		    throw new InputMismatchException();
		}
		System.out.println("you entered: " + foo);
		System.exit(0);
	    } catch(InputMismatchException e) {
		foo = 0;
		System.out.println("Incorrect entry. Please try again.");
		kbd.next();
		//throw e;
	    }
	}
    }
}