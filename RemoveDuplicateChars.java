import java.util.*;

public class RemoveDuplicateChars {
  public static void main(String[] args) {
    String s = removeDups("RemoveRemove");

    System.out.println(s);
  }

  public static String removeDups(String s){
    Set<Character> set = new HashSet<Character>();
     String newString = "";

    for(int i = 0; i<s.length(); i++){
      if(set.add(s.charAt(i))!=false) newString = newString + String.valueOf(s.charAt(i));
    }

    return newString;
  }
}
