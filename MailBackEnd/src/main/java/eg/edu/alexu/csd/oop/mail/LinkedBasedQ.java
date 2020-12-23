package eg.edu.alexu.csd.oop.mail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "empty" })
public class LinkedBasedQ implements IQueue,ILinkedBased{



    private Node head;
    private Node rear;
    private int size;

    public Node getHead() {
        return head;
    }

    public Node getRear() {
        return rear;
    }

    public int getSize() {
        return size;
    }

    public void show(){
        Node node=head;
        for(int i=0;i<size;i++){
            System.out.println(node.getElement());
            node=node.getNext();
        }
    }


    @Override
    public void enqueue(Object item) {
        if(item==null) {
            throw new NullPointerException();
        }
        Node node=new Node();
        node.setElement(item);
        if(size==0){
            head=node;
            rear=node;
        }else {
            rear.setNext(node);
        }
        rear=node;
        size++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty())
            throw new RuntimeException("Empty Queue");

        Object temp=head.getElement();
        head=head.getNext();
        size--;
        if(isEmpty())
            rear=null;
        return temp;

    }

    @Override
    public boolean isEmpty() {
        if(size==0)
            return true;

        return false;
    }

    @Override
    public int size() {
        return size;
    }
}