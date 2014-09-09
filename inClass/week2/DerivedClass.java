
class DerivedClass extends BaseClass{
    private int numberDerived;
    
    public DerivedClass(int n1,int n2){
	super();
	numberDerived = n2;
	System.out.println("Executing DerivedClass constructor.");
    }
    
    public void display(){
	super.display();
	System.out.println("Data fields of DerivedClass are:");
	System.out.println("   numberBase = " + numberBase);
	System.out.println("   numberDerived = " + numberDerived);
    }
}
