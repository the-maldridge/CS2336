import java.util.Scanner;
import java.util.Stack;

public class isPalindrome {
    public static void main(String[] args) {
	Scanner kbd = new Scanner(System.in);

	System.out.print("Input a possible palindrome: ");
	String foo = kbd.nextLine();
	String bar="";
	//String bar = new StringBuilder(foo).reverse().toString();
	Stack stk = new Stack();

	for(int i=0; i<foo.length(); i++) {
	    stk.push(foo.charAt(i));
	}

	for(int i=0; i<foo.length(); i++) {
	    bar = bar + stk.pop();
	}

	if(foo.equals(bar)) {
	    System.out.println(foo + " is a palindrome!");
	} else {
	    System.out.println(foo + " is not a palindrome!");
	}
    }
}