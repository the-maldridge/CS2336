
public class Member {
    private int memberID;
    private String fName, lName;
    private double donationAmount;
        
    public Member() {
        this(1000, "John", "Smith", 250.0);
    }
    public Member(String fn, String ln) {
        this(1001, fn, ln, 500.0);
    }
    public Member(int memberID, String fName, String lName, double donationAmount) {
        this.memberID = memberID;
        this.fName = fName;
        this.lName = lName;
        this.donationAmount= donationAmount;
    }
    
    public void displayMemberInfo(){
        System.out.println("MemberID          = " + memberID);
        System.out.println("Member First Name = " + fName);
        System.out.println("Member Last Name  = " + lName);
        System.out.println("Member Donation   = " + donationAmount);
    }

    
    @Override
    public String toString(){
        return ("MemberID          = " + memberID + 
                "\nMember First Name = " + fName +
                "\nMember Last Name  = " + lName + 
                "\nMember Donation   = " + donationAmount);
    }
}