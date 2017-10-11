import java.util.*;

public class RemoveDuplicateChars {
  public static void main(String[] args) {
    String s = removeDups("RemoveRemove");

    System.out.println(s);
  }

  public static String removeDups(String s){
    Set<Character> set = new HashSet<Character>();

    for(int i = 0; i<s.length(); i++){
      set.add(s.charAt(i));
    }

    Iterator it = set.iterator();
    String newString = "";

    while(it.hasNext()){
      newString = newString + String.valueOf(it.next());
    }

    return newString;
  }
}
