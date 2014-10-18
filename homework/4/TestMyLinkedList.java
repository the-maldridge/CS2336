// Author: Michael Aldridge
// Class: 2336
// Section: 001
// Running instructions: javac TestMyLinkedList.java && java TestMyLinkedList

public class TestMyLinkedList {
    public static void main(String[] args) {
	// Create a list
	MyLinkedList<Integer> list = new MyLinkedList<Integer>();
	
	//add the requested numbers
	list.add(22);
	list.add(7);
	list.add(4);
	list.add(12);
	list.add(8);
	list.add(11);
	list.add(12);
	list.add(9);
	list.add(1);
	list.add(3);

	//print the list
	System.out.println("List contents: " + list);

	//remove index 0 and print
	list.remove(0);
	System.out.println("List contents: " + list);

	//remove the last index and print
	list.remove(list.size());
	System.out.println("List contents: " + list);

	//search for "12" in the list
	int index12 = list.indexOf(12);
	System.out.println("12 was found at index " + index12);

	//search for "12" and give the last one
	index12 = list.lastIndexOf(12);
	System.out.println("12 was found at index " + index12);

	//show item 3
	System.out.println("Contents of item 3: " + list.get(2));
    }
}