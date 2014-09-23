public class TestCustomNegativeWeightException {

    public static void main(String[] args)  {
     
        double weight = getWeight();

        try {
            readWeight();
        }
        catch (NegativeWeightException nwe){
            System.out.println("A custom defined exception is thrown: " + nwe);
            System.out.println("\nnwe.getMessage(): " + nwe.getMessage());
        }
        
    }
    
    static void readWeight() throws NegativeWeightException {
        double weight = getWeight(); 
        if (weight < 0.0){
            throw new NegativeWeightException(weight);
        }
    }
       
    static double getWeight()  {
        return -150.0;
    }
}