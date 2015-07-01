public class ProblemTwo {
    public static void main(String[] args) {
	for(int i=1; i<=10; i++) {
	    System.out.println("m("+i+"): " + series(1,i));
	}
    }

    private static double series(double i, int l) {
	if(i<=l) {
	    return (i/(i+1)) + series(i+1, l);
	}
	return 0;
    }
}