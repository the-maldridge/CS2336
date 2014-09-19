public class SalesAssociate extends Employee {
    double commision;

    SalesAssociate(int id, String first, String last, double pay, double commision) {
	super(id, first, last, pay);
	this.commision = commision;
    }

    double raise() {
	return salary+commision;;
    }
}