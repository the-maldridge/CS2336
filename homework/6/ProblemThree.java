import java.util.Scanner;

public class ProblemThree {
    public static void main(String[] args) {
	Scanner kbd = new Scanner(System.in);

	System.out.print("Enter a word or phrase: ");
	String searchStr = kbd.nextLine();
	System.out.print("Enter a character to search for: ");
	char searchChar = kbd.next().charAt(0);

	System.out.println("There are " + count(searchStr, searchChar) + " occurences of " + searchChar + " in " + searchStr + ".");
    }

    public static int count(String str, char ltr) {
	if(str.length() <=0) {
	    return 0;
	} else {
	    if(str.charAt(0) == ltr) {
		return 1 + count(str.substring(1), ltr);
	    } else {
		return 0 + count(str.substring(1), ltr);
	    }
	}
    }
}