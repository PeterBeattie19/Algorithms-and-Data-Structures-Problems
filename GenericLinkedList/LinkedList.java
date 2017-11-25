public class LinkedList <E>{
  Node<E> head;
  Node<E> tail;
  private int size;

  public LinkedList(){
    this.size = 0;
  }

  public void insert(E value){
    size++;
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
    size--;
    Node<E> oldhead = head;
    head = head.next;
    return oldhead.getData();
  }

  public E pop(){
    return remove();
  }

  public E remove(){
    //  Node<E> returnNode = tail
    size--;

    if(head.next == null){
      Node<E> r = head;
      head = null;public class LinkedList <E>{
  Node<E> head;
  Node<E> tail;
  private int size;

  public LinkedList(){
    this.size = 0;
  }

  public void insert(E value){
    size++;
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
    size--;
    Node<E> oldhead = head;
    head = head.next;
    return oldhead.getData();
  }

  public E pop(){
    return remove();
  }

  public E remove(){
    //  Node<E> returnNode = tail
    size--;

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

  public void insert(E value, int index){
    if(index < 0 || index > this.size){
      System.out.print("IndexOutOfBoundsException");
      return;
    }

    if(index == this.size){
      insert(value);
      return;
    }

    int count = 0;
    Node<E> temp = head;
    while(count < index-1){
      temp = temp.next;
      count++;
    }

    Node<E> next = temp.next; //Value to the left of new Node
    temp.next = new Node<E>(value); //previous node points to new node
    temp.next.next = next; //new node points to the next node in list
    return;

  }

  public int size(){
    return this.size;
  }

  public boolean contains(E obj){
    if(head == null) return false;

    Node<E> temp = head;

    while(temp != null){
      if(temp.getData() == obj) return true;
      temp = temp.next;
    }
    return false;
  }

  public E peekFirst(){
    return head.getData();
  }

  public E peekLast(){
    return head;
  }
}

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

  public void insert(E value, int index){
    if(index < 0 || index > this.size){
      System.out.print("IndexOutOfBoundsException");
      return;
    }

    if(index == this.size){
      insert(value);
      return;
    }

    int count = 0;
    Node<E> temp = head;
    while(count < index-1){
      temp = temp.next;
      count++;
    }

    Node<E> next = temp.next; //Value to the left of new Node
    temp.next = new Node<E>(value); //previous node points to new node
    temp.next.next = next; //new node points to the next node in list
    return;

  }

  public int size(){
    return this.size;
  }

}
