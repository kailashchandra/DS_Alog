class LinkedListDemoJava {

  static class LLNode {
    public int data;
    public LLNode next;

    public LLNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static LLNode addNodeAtHead(LLNode head, LLNode newNode) {
    newNode.next = head;
    head = newNode;

    return head;
  }

  public static LLNode addAtTail(LLNode head, LLNode newNode) {
    if(head == null) return newNode;
    LLNode pre = head;
    while(pre.next != null) {
      pre = pre.next;
    }
    pre.next = newNode;

    return head;
  }

  public static LLNode insertAtMiddle(LLNode head, LLNode newNode, int position) {
    LLNode tmp = head;
    int curr = 1;
    while(tmp != null && curr < position-1) {
      curr++;
      tmp = tmp.next;
    }
    newNode.next = tmp.next;
    tmp.next = newNode;
    return head;
  }

  public static LLNode deleteBasedOnPos(LLNode head, int pos) {
    if(pos == 1 && head != null) return head.next;
    int curr = 1;
    LLNode pre = head;
    while(pre != null && curr < pos-1) {
      curr++;
      pre = pre.next;
    }
    if(pre.next != null)
      pre.next = pre.next.next;
    return head;
  }

  public static LLNode deleteBasedOnValue(LLNode head, int value) {
    if(head == null) return head;
    if(head.data == value) return head.next;
    LLNode pre = head;
    LLNode tmp = head.next;
    while(tmp != null) {
      if(tmp.data == value) break;
      pre = tmp;
      tmp = tmp.next;
    }
    if(pre.next != null)
      pre.next = pre.next.next;
    return head;
  }

  public static void printLL(LLNode head) {
    LLNode temp = head;
    System.out.println();
    while(temp != null) {
      System.out.print(temp.data+" ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static LLNode kReverse(LLNode head, int k) {
		if(head == null) return head;
        
        LLNode pre = null;
        LLNode forward = null;
        LLNode curr = head;
        int count = 0;
        
        while(count < k && curr != null) {
            forward = curr.next;
   			    curr.next = pre;
            pre = curr;
            curr = forward;
            count++;
        }
        
        if(curr != null) {
            head.next = kReverse(curr, k);
        }
        
        return pre;
	}

  public static void main(String[] args) {
    LLNode head = new LLNode(4);
    printLL(head);
    
    head = addNodeAtHead(head, new LLNode(10));
    head = addNodeAtHead(head, new LLNode(8));
    head = addNodeAtHead(head, new LLNode(7));
    head = addNodeAtHead(head, new LLNode(6));

    printLL(head);
    System.out.println("adding at tail");

    head = addAtTail(head, new LLNode(1));
    head = addAtTail(head, new LLNode(2));
    head = addAtTail(head, new LLNode(3));
    head = addAtTail(head, new LLNode(5));
    printLL(head);

    System.out.println("adding at middle");
    head = insertAtMiddle(head, new LLNode(50), 3);
    printLL(head);

    System.out.println("deleting node");
    head = deleteBasedOnPos(head, 3);
    head = deleteBasedOnPos(head, 5);
    printLL(head);

    System.out.println("deleting node based on value");
    head = deleteBasedOnValue(head, 3);
    head = deleteBasedOnValue(head, 5);
    printLL(head);
  }
}