import java.util.UUID;

public class ProblemOne {
    public static void main(String[] args) {
	LinkedList<Integer> myList = new LinkedList<Integer>();
	for(int i=0; i<100; i++) {
	    myList.add(new Node<Integer>(i));
	}
	System.out.println("The size of the integer list is: " + myList.size());
    
	LinkedList<String> strList = new LinkedList<String>();
	for(int i=0; i<25; i++) {
	    strList.add(new Node<String>(UUID.randomUUID().toString()));
	}
	System.out.println("The size of the string list is: " + strList.size());
    }
}


//just enough of a type specialized LinkedList to host the size function
class LinkedList<E> {
    private Node<E> head = null;

    public void add(Node<E> n) {
	Node search = head;
	if(search != null) {
	    while(search.getNext() != null) {
		search = search.getNext();
	    }
	    search.setNext(n);
	} else {
	    head = n;
	}
    }

    public int size() {
	return size(head);
    }

    public int size(Node n) {
	if(n.getNext() != null) {
	    return this.size(n.getNext()) + 1;
	} else {
	    return 1;
	}
    }
}

class Node<E> {
    private E data;
    private Node next=null;

    public Node(E data) {
	this.data = data;
    }

    public Node getNext() {
	return next;
    }

    public void setNext(Node next) {
	this.next = next;
    }

    public String toString() {
	return data.toString();
    }
}