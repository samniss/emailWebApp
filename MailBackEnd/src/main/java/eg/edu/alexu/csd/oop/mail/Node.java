package eg.edu.alexu.csd.oop.mail;

public class Node{
    private Object element;
    private Node next;

    public Node(Object obj,Node n){
        element=obj;
        next=n;
    }

    public Node() {}

    public Object getElement() {
        return element;
    }

    public void setElement(Object obj) {
        element = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }
}