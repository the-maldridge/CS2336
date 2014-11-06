public class TestGenericStack {
    public static void main(String[] args){
        GenericStack<String> stack1= new GenericStack<String>();
        GenericStack<Integer> stack2= new GenericStack<Integer>();
        stack1.push("Washington DC");
        stack1.push("San Francisco");
        stack1.push("Napels");
        stack2.push(3);
        stack2.push(11);
        stack2.push(1);
        
        System.out.println("stack 1 is: " + stack1);
        System.out.println("stack 2 is: " + stack2);
        
        stack1.pop();
        stack2.pop();
        
        System.out.println("After pop the stack contents are:");
        System.out.println("stack 1 is: " + stack1);
        System.out.println("stack 2 is: " + stack2);
    }
}
