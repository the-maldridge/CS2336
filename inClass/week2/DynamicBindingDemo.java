
public class DynamicBindingDemo {
   public static void main(String args[]) {
         Shape[] arrayShape=new Shape[3];
         arrayShape[0]=new Shape();
         arrayShape[1]=new TriangleShape();
         arrayShape[2]=new SquareShape();
         
         for (int i=0; i<(arrayShape.length); i++) {
             arrayShape[i].draw();
         }
   }
}