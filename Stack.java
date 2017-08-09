public class Stack   {
  public static final int CAPACITY = 1000;
  private int capacity;
  private Object[] S;
  private int top = -1;

  public Stack(){
    this(CAPACITY);
  }

  public Stack(int cap){
    this.capacity = cap;
    S = new Object[this.capacity];
  }


  public int size(){
    return top+1;
  }


  public boolean isEmpty(){
    return (top < 0);
  }


  public boolean isFull(){
    return (top == S.length - 1);
  }


  public Object top()   {
    if(isEmpty()){
     System.out.println("Stack is full");
     return null;
    }

    else {
      return S[top];
    }
  }


  public void push(Object obj)  {
    if(isFull()){
      System.out.println("Stack is full");
    }

    else {
      S[++top] = obj;
    }
  }


  public Object pop()  {
    Object element;

    if(isEmpty()){
        System.out.println("Stack is empty");
        return null;
    }

    else {
      element = S[top];
      S[top] = null;
      top--;
      return element;
    }
  }

}
