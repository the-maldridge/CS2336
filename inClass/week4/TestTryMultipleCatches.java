class TestMultipleTryCatch {
    public static void main (String[] args) {
        int count=10;
        int myArray[] = new int[count];

        try {
            for (int i = 1; i <count; i++) {
                myArray[i] = i;
                System.out.print(myArray[i] + " ");
            }

            System.out.println("\nNew array is: ");
            for (int j=0; j<count; j++) {
                myArray[j] = j / j;
                System.out.print(myArray[j] + " ");
            }
        } 
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println ("\nCannot reach a non existing array index");
        } 
        catch (ArithmeticException e){
            System.out.println ("\nDivision by zero error");
        }
    }
}