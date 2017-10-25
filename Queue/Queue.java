public class Queue {
  Node head;
  Node tail;

  public boolean isEmpty(){
    return (head==null);
  }

  public int peek() throws NullPointerException{
    return head.data;
  }

  public void add(int data){
    Node insert = new Node(data);

    if(tail != null){
      tail.next = insert;
    }

    tail = insert;

    if(head==null) head = insert;
  }

  public int remove() throws NullPointerException {
    int data = head.data;

    head = head.next;

    if(head==null){
      tail = null;
    }

    return data;
  }
}
