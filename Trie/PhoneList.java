import java.io.*;
import java.util.*; 

public class PhoneList {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for(int x = 0; x<t; x++){
      int n = Integer.parseInt(br.readLine());
      Node trie = new Node();
      ArrayList<String> arr = new ArrayList<>(); 

      for(int i = 0; i<n; i++){
        String s = br.readLine(); 
        trie.add(s,0); 
        arr.add(s);  
      }

      boolean found = false;
      for(String s: arr){
        if(trie.findCount(s,0) > 1){
          bw.write("NO\n");
          //bw.flush();
          found = true; 
          break;
        }
      }

      if(found)
        continue;  

        bw.write("YES\n");
    }

    bw.flush(); 
  }

  public static class Node {
    private int numOfChars = 10;
    Node children[] = new Node[numOfChars];
    int size = 0;

    public Node getNode(int c){
      return children[c];
    }

    public void setNode(int c, Node n){
      children[c] = n;
    }

    public void add(String s, int index){
       size++;
       if(index == s.length()) return;

       int current = Integer.parseInt(s.substring(index,index+1));
       //int charCode = getCharIndex(current);
       Node child = getNode(current);

       if(child==null){
         child = new Node();
         setNode(current, child);
       }

       child.add(s, index+1);
    }

    public int findCount(String s, int index){
      if(index == s.length()) return size;

      Node child = getNode(Integer.parseInt(s.substring(index,index+1)));

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
