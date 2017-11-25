public class Node<E>{
  private E data;
  Node<E> next;

  public Node(E n){
    this.data = n;
  }

  public E getData(){
    return this.data;
  }

  public  void setData( E n){
    this.data = n;
  }
}
