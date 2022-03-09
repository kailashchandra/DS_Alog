import java.util.*;
public class RemovDuplicateUnsortLL {
	
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) { 
        //o(n^2) approach-
        /*LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> tmp = null;
        while(curr != null) {
            tmp = curr;
            while(tmp.next != null) {
                if(tmp.next.data == curr.data) tmp.next = tmp.next.next;
                else tmp = tmp.next;
            }
        }
        return head;*/
        
        //o(n) approach -
        HashMap<Integer, Boolean> map = new HashMap<>();
        LinkedListNode<Integer> curr = head;
        if(curr != null) map.put(curr.data, true);
        else return head;
        while(curr.next != null) {
            if(map.containsKey(curr.next.data) && map.get(curr.next.data)) {
                curr.next = curr.next.next;
            } else {
                map.put(curr.next.data, true);
                curr = curr.next;
            }
        }
        return head;
	}
    
    //need to check sorting method as well.(mergeSort)

}