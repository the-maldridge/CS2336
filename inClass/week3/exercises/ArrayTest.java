public class ArrayTest {
    static public int getSomeData(int[] dat, int index) throws ArrayIndexOutOfBoundsException {
	if(index>dat.length) {
	    throw new ArrayIndexOutOfBoundsException();
	} else {
	    return dat[index];
	}
    }

    public static void main(String[] args) {
	int data[] = new int[5];

	try {
	    getSomeData(data, 6);
	} catch(ArrayIndexOutOfBoundsException e) {
	    System.out.println("Access to out of bounds element");
	}	
    }
}