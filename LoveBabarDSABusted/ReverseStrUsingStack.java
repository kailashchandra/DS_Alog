import java.util.*;
public class ReverseStrUsingStack {

  public static String reverseStr(String str) {
    Stack<Character> st = new Stack<>();
    String ans = "";
    for(int i=0;i<str.length();i++) {
      st.push(str.charAt(i));
    }

    while(!st.empty()) {
      ans += st.pop();
    }
    return ans;
  }
  
  
  public static void main(String[] args) {
    System.out.println("ReverseString "+reverseStr("Kailash"));
  }
}
