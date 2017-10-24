public class HeapMax {

  private Node heapArray[];
  private int maxSize;
  private int currentSize;

  public Heap(int max){
    this.maxSize = max;
    this.currentSize = 0;
    heapArray = new Node[maxSize];
  }

  public boolean isEmpty(){
    return (currentSize==0);
  }

  public boolean insert(int n){
    if(currentSize==maxSize) return false;

    Node newNode = new Node(n);
    heapArray[currentSize] = newNode;
    trickleUp(currentSize++);
    return true;
  }

  public void trickleUp(int index){
    int parent = (index-1)/2; //Parent of newly inserted node 
    Node bottom = heapArray[index]; //New inserted Node 

    while(index>0 && heapArray[parent].getKey() < bottom.getKey()){ //Loop while we're still in the array and the current node's key is greater than its parent
      heapArray[index] = heapArray[parent]; //Move parent to the index 
      index = parent; //change index to previous parent's index 
      parent = (parent-1)/2; //change parent, move it up the heap 
    }
    heapArray[index] = bottom; //Loop ends and we have found the new location fir the node 
  }

  public Node remove(){
    Node root = heapArray[0];
    heapArray[0] = heapArray[--currentSize];
    trickleDown(0);
    return root;
  }

  public void trickleDown(int index){
    int largerChild;
    Node top = heapArray[index];
    while(index<currentSize/2){
      int leftChild = 2*index+1;
      int rightChild = leftChild+1;

      if(rightChild < currentSize && heapArray[leftChild].getKey()<heapArray[rightChild].getKey()){
        largerChild = rightChild;
      }
      else largerChild = leftChild;

      if(top.getKey()>=heapArray[largerChild].getKey()) break;

      heapArray[index] = heapArray[largerChild];
      index = largerChild;
    }
    heapArray[index] = top;
  }

  public boolean change(int index, int newValue){
    if(index<0 || index>=currentSize) return false;
    int oldValue = heapArray[index].getKey();

    if(oldValue<newValue)
      trickleUp(index);
    else
      trickleDown(index);
    return true;
  }

  public void displayHeap(){
    System.out.print("heapArray: "); // array format
    for(int m=0; m<currentSize; m++){
      if(heapArray[m] != null)
        System.out.print( heapArray[m].getKey() + " ");
      else
        System.out.print( "-- ");
    }
    System.out.println();
    // heap format
    int nBlanks = 32;
    int itemsPerRow = 1;
    int column = 0;
    int j = 0; // current item
    String dots = "...............................";
    System.out.println(dots+dots); // dotted top line
    while(currentSize > 0){
      if(column == 0) // first item in row?
      for(int k=0; k<nBlanks; k++) // preceding blanks
        System.out.print(" ");
        // display item
      System.out.print(heapArray[j].getKey());

      if(++j == currentSize) // done?
        break;
      if(++column==itemsPerRow) // end of row?
      {
        nBlanks /= 2; // half the blanks
        itemsPerRow *= 2; // twice the items
        column = 0; // start over on
        System.out.println(); // new row
      }
      else // next item on row
      for(int k=0; k<nBlanks*2-2; k++)
        System.out.print(" "); // interim blanks
      } // end for
      System.out.println("\n"+dots+dots); // dotted bottom line
    }   	 // end displayHeap()
}
