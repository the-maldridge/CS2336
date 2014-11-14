import java.util.Scanner;
public class ProblemFour {
    public static void main(String[] args) {
	Scanner kbd = new Scanner(System.in);

	System.out.print("Please input a number to be summed: ");
	long i = kbd.nextInt();
	System.out.println("The sum of the digits is " + sumDigits(i));
    }

    public static int sumDigits(long n) {
	if(n>0) {
	    return sumDigits((n-n%10)/10) + (int)n%10;
	} else {
	    return 0;
	}
    }
}