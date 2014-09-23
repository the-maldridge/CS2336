public class NegativeWeightException extends Exception {

    private double weight;

    public NegativeWeightException(double weight){
        super("Invalid weight " + weight); 
        this.weight = weight;
    }

    public String toString(){
        return "Weight cannot be negative" + " " +weight ;
    }
}