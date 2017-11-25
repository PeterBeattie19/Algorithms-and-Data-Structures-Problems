public class LinkedList <E>{
  Node<E> head;
  Node<E> tail;

  public void insert(E value){
    if(head == null) {
      head = new Node<E>(value);
      tail = head;
      return;
    }

    Node<E> temp = head;
    while(temp.next != null){
      temp = temp.next;
    }

    temp.next = new Node<E>(value);
    tail = temp.next;
    return;
  }

  public void push(E value){
    insert(value);
    return;
  }

  public E poll(){
    Node<E> oldhead = head;
    head = head.next;
    return oldhead.getData();
  }

  public E pop(){
    return remove();
  }


  public E remove(){
    //  Node<E> returnNode = tail
    if(head.next == null){
      Node<E> r = head;
      head = null;
      return r.getData();
    }
      Node<E> temp = head.next;
      Node<E> prev = head;

      while(temp.next!= null){
        prev = temp;
        temp = temp.next;
      }

      prev.next = null;
      tail = prev;
      return temp.getData();

  }

  public void printList(){
    Node<E> temp = head;

    while(temp != null){
      System.out.print(temp.getData() +" ");
      temp = temp.next;
    }
    System.out.println();
    return;
  }

}
