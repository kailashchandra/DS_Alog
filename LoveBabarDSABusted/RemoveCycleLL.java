import java.util.ArrayList;

/*
https://www.codingninjas.com/blog/2020/09/09/floyds-cycle-detection-algorithm/#:~:text=Floyd's%20cycle%2Dfinding%20algorithm%20is,pointers%20of%20the%20head%20node.
*/

public class RemoveCycleLL {
  public static Node removeLoop(Node head) {
      Node fast = head;
      Node slow = head;
      boolean isLoop = false;
      while(fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
          if(slow == fast) {
              isLoop = true;
              break;
          }
      }
      
      if(isLoop) {
          slow = head;
          
          while(slow != fast) {
              slow = slow.next;
              fast = fast.next;
          }
              Node tmp = slow;
              Node first = slow;
              while(tmp.next != first) {
                  tmp = tmp.next;
              }
              tmp.next = null;
      }
      
      return head;
  }
}