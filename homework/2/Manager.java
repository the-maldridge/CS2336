public class Manager extends Employee {
    Manager(int id, String first, String last, double pay) {
	super(id, first, last, pay);
    }

    double raise() {
	return salary+salary*0.10;
    }
}