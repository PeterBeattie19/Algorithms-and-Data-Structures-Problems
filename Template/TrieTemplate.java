import java.io.*;

public class BingItOn {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Node trie = new Node();
  }

  public static class Node {
    private int numOfChars = 26;
    Node children[] = new Node[numOfChars];
    int size = 0;

    public Node getNode(char c){
      return children[getCharIndex(c)];
    }

    public void setNode(char c, Node n){
      children[getCharIndex(c)] = n;
    }

    public void add(String s, int index){
       size++;
       if(index == s.length()) return;

       char current = s.charAt(index);
       int charCode = getCharIndex(current);
       Node child = getNode(current);

       if(child==null){
         child = new Node();
         setNode(current, child);
       }

       child.add(s, index+1);
    }

    public int findCount(String s, int index){
      if(index == s.length()) return size;

      Node child = getNode(s.charAt(index));

      if(child == null){
        return 0;
      }

      return child.findCount(s, index + 1);
    }

    public int getCharIndex(char c){
      return (c - 'a');
    }
  }

}
