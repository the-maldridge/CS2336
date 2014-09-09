
public class TestOverloading {
  public static void main(String[] args) {
    OverloadA a = new OverloadA();
    a.p(10);
    a.p(10.0);
  }
}

class OverloadB {
  public void p(double i) {
    System.out.println(i * 2);
  }
}

class OverloadA extends OverloadB {
  // This method overloads the method in B
  public void p(int i) {
    System.out.println(i);
  }
}
    
