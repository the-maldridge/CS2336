
import java.util.ArrayList;

public class TestEmployee {
    public static void main(String[] args) {
	ArrayList staff = new ArrayList<Employee>();

	System.out.println("Hiring Staff...");
	
	staff.add(new Manager(0000, "Joe", "Manager", 100));
	staff.add(new SalesAssociate(0001, "Walter", "White", 75, 5));
	staff.add(new Secretary(0002, "Susan", "Trump", 60));

	System.out.println("Salary and raises are as follows:");

	for(int i=0; i<staff.size(); i++) {
	    System.out.prinln('\t' + staff.get(i).getFirstName() + " " + staff.get(i).getLastName()
			      + "\n\t\t" + "Old Salary: " + staff.get(i).getSalary()
			      + "\n\t\t" + "New Salary: " + staff.get(i).raise());
	}
    }
}