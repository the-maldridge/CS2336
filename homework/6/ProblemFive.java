import java.util.Scanner;

public class ProblemFive {
    public static void main(String[] args) {
	Scanner kbd = new Scanner(System.in);

	System.out.print("Input a word: ");
	String word = kbd.next();

	System.out.println("There are " + countUpper(word) + " uppercase letters in that word.");
    }

    public static int countUpper(String word) {
	if(word.length() >0) {
	    if(Character.isUpperCase(word.charAt(0))) {
		return countUpper(word.substring(1)) + 1;
	    } else {
		return countUpper(word.substring(1)) + 0;
	    }
	} else {
	    return 0;
	}
    }
}