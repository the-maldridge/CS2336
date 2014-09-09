
class BaseClass{
    protected int numberBase;
    
    public BaseClass() {
	numberBase = -33;
    }
    
    public BaseClass(int numberBase){
	this.numberBase = numberBase;
	System.out.println("Executing BaseClass constructor.");
    }
    
    public void display(){
	System.out.println("Data field of BaseClass is:"  + numberBase);
    }
}
