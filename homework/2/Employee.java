public abstract class Employee {
    int employeeID;
    String firstName;
    String lastName;
    double salary;

    Employee(int employeeID, String firstName, String lastName, double salary) {
	this.employeeID = employeeID;
	this.firstName = firstName;
	this.lastName = lastName;
	this.salary = salary;
    }

    public int getEmployeeID() {
	return employeeID;
    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public double getSalary() {
	return salary;
    }

    abstract double raise();
}