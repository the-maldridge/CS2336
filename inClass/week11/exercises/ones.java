import java.util.Scanner;
public class ones {
    public static void main(String[] args) {
	Scanner kbd = new Scanner(System.in);
	System.out.print("Input a number: ");
	
	int number = kbd.nextInt();
	int ones = successiveDivide(number);

	System.out.println("There are " + ones  + " 1's in " + number);
    }

    public static int successiveDivide(int number) {
	if(number!=0) {
	    if(number%2==1) {
		return number%2 + successiveDivide(number/2);
	    } else {
		return successiveDivide(number/2);
	    }
	} else {
	    return 0;
	}
    }
}