public class proposal {
    public static void main(String[] args) {
	String message = "Absurd proposal";
	int times = (int)(args[0]);
	propose(message, times);
    }

    public static int propose(String msg, int times) {
	if(times>=1) {
	    System.out.println(msg);
	    return propose(msg, --times);
	} else {
	    return 0;
	}
    }
}