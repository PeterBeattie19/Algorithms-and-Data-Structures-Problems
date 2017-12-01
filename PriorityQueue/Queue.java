public class PriorityQueue {
  Node head;

  public boolean isEmpty(){
    return (head==null);
  }

  public int peek(){
    return head.data;
  }

  public void add(int data){
    if(isEmpty() == true){
      head = new Node(data);
      return;
    }

    Node insert = new Node(data); //Node to be put in Queue
    Node current = head;
    Node prev = head;

    while(current.data > data && current.next!=null){
      prev = current;
      current = current.next;
    }

    if(current.next == null){
      current.next = insert;
      return;
    }

    prev.next = insert;
    insert.next = current;
    return;
  }

  public int remove() { //THIS METHOD ASSUMES NO NULL POINTER EXCEPTIONS
    Node oldhead = head;
    head = head.next;
    return oldhead.data;
  }
}
