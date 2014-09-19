public class Secretary extends Employee {
    Secretary(int id, String first, String last, double pay) {
	super(id, first, last, pay);
    }

    double raise() {
	return salary+salary*0.05;
    }
}