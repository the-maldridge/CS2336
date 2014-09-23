public class TestCircleWithException {
  public static void main(String[] args) {
    try {
      CircleWithException c1 = new CircleWithException(5);
      CircleWithException c2 = new CircleWithException(-5);
      CircleWithException c3 = new CircleWithException(0);
    }
    catch (IllegalArgumentException ex) {
      System.out.println(ex);
      
      //ebru
      //ex.printStackTrace();
      System.out.println("\nex.getMessage(): " + ex.getMessage());
      System.out.println("\nex.toString(): " + ex.toString());
    }

    System.out.println("Number of objects created: " +
      CircleWithException.getNumberOfObjects());
  }
}