public class LinkedList{
  NodeL head;

  //CONSTRUCTORS
  public LinkedList(int data){
    head = new NodeL(data);
  }
  public LinkedList(){}
  
  public boolean isEmpty(){
    return (head==null); 
  }

    //insert a node into the end of the list.
  public void insert(int data){

    if(head==null) head = new NodeL(data); //if the list is empty then set the head equal to the node to be inserted.

    else {
    NodeL temp = head;

    while(temp.next!=null){
      temp = temp.next;
    }   //Loop until we reach the end of the list

    temp.next = new NodeL(data); // temp is the last value in the list, we point it to the node we want to insert.
                                //We construct a new node with the data value passed in from the argument of this method.
  }
}

  public void delete(int n){ //Finds the link to be deleted, points previous link to next link, (finds the link by using the data variable in the node class)
    NodeL prev = head;
    NodeL cur = head;

    while(cur.data!=n){  //loop until we reach a node with the key value equal to n.
      prev = cur;
      cur = cur.next;
    }

    prev.next = cur.next; //when we find the node to be deleted we point the previous node to the next node in the list.
  }

  public NodeL returnHead() { return this.head; } //Returns the head node of the linked list 

  public void reverseList() {
    this.head = ReversePrivate(this.head); } //Public method to reverse a list, calls private method

  private NodeL ReversePrivate(NodeL head) {
    NodeL current = head.next; //Every time we loop we point this node to the previous one.
    NodeL prev = head;         //previous node, to be pointed at.
    NodeL temp = head.next.next; //after we point current to the previous node, we then set it to the next node, after current.
    this.head.next = null; //the current head is now pointing to null since it will be the last node.
    boolean check = true; //Value used for looping

    while(check==true){
        current.next = prev; //current now points to the previous node
        prev = current; //prev moves up by one
        current = temp; //current moves up by one

        if(temp.next==null){ //we have reached the end of the list
            head = temp;//The head of the list is now the last node of the previous list, note the this.head part(we want to change the list in the class not the method arguement)
            head.next = prev; // point the new head to the second last value in the old list
            check = false; //end loop
        }

        else temp = temp.next;
    }

    return head;
  }

  public int count(NodeL head){ //Returns the number of elements in the linked list
    if(head==null) return 0; //if head is null, we have reached the end of the list, or the list is empty

    else return 1 + count(head.next); //recursive step,  keep adding one until the head is null.
  }

  private void printPrivateReverse(NodeL head){
    if(head.next!=null) printPrivateReverse(head.next); //recurse to the end of the list, then start printing

    System.out.print(head.data +" ");
  }

  private void printPrivateForward(NodeL head){ //Print an element then jump to the next node, until a node is null.
    NodeL temp = head;
    do{
      System.out.print(temp.data +" ");
      temp = temp.next;
    }
    while(temp !=null);
  }

  public void printReverse(){
    printPrivateReverse(head);
  }

  public void printForward(){
    printPrivateForward(head);
  }

  public void insertAt(int data, int pos){ privateInsertAt(this.head,pos,data); }

  private void privateInsertAt(NodeL head, int pos, int data){
  int size = count(head); //Size of the list

  if(size<pos || pos<0){
    System.out.println("Out of Bounds");
    return;
  } //If the position to be inserted into is out of bounds then there is an error, return

  if(head==null  ){
     insert(data);
     return;
   } //If the list is empty then inset into the start of the list

  if(pos==0){
    NodeL insert = new NodeL(data);
    insert.next = head;
    this.head = insert;
    return;
  } //If we are inserting into the start of the list (pos==0) then create a new head and point it to the old head.

  else if(pos==size){
     insert(data);
     return;
   } //If we are inserting into the end of the list then point the last node to a new node.

  else {
    NodeL current = head;
    int count = 1;
    NodeL prev = current;

    while(count<=pos){ //We loop until we reach the position to be inserted into.
      prev = current;
      current = current.next;
      count++;
    }

    NodeL insert = new NodeL(data); //Node to be inserted

    prev.next = insert; //point the previous node to the new node
    insert.next = current;//Point the new node to the next one, in the old list this would have been the node after prev. 
    return;
  }
  }
}
