public class RemoveDuplicateSortedLL {
    public static Node uniqueSortedList(Node head) {
        Node curr = head;
        while(curr != null && curr.next != null) {
            if(curr.data != curr.next.data) {
                curr = curr.next;
            } else {
                curr.next = curr.next.next;
            }
        }
        return head;
    }
}