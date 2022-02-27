class DoublyLLDemoJava {

  static class DLL {
    public int data;
    public DLL pre;
    public DLL next;

    public DLL(int data) {
      this.data = data;
    }
  }

  public static void printLL(DLL head) {
    DLL temp = head;
    System.out.println();
    while(temp != null) {
      System.out.print(temp.data+" ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static int lengthLL(DLL head) {
    int len = 0;
    DLL temp = head;
    while(temp != null) {
      len++;
      temp = temp.next;
    }
    return len;
  }

  public static DLL addNodeAtHead(DLL head, DLL newNode) {
    if(head == null) return newNode;
    newNode.next = head;
    head.pre = newNode;
    head = newNode;
    return head;
  }

  public static DLL addAtTail(DLL head, DLL newNode) {
    if(head == null) return newNode;
    DLL last = head;
    while(last.next != null) {
      last = last.next;
    }
    last.next = newNode;
    newNode.pre = last;

    return head;
  }

  public static DLL insertAtMiddle(DLL head, DLL newNode, int position) {
    if(position == 1) return addNodeAtHead(head, newNode);

    DLL tmp = head;
    int curr = 1;
    while(tmp != null && curr < position-1) {
      curr++;
      tmp = tmp.next;
    }

    newNode.next = tmp.next;
    tmp.next.pre = newNode;
    newNode.pre = tmp;
    tmp.next = newNode;

    return head;
  }

  public static DLL deleteBasedOnPos(DLL head, int pos) {
    if(pos == 1 && head != null) return head.next;
    int curr = 1;
    DLL last = head;

    while(last != null && curr < pos-1) {
      curr++;
      last = last.next;
    }
    if(last.next != null)
      last.next = last.next.next;
    if(last.next != null && last.next.next != null)
      last.next.next.pre = last;

    return head;
  }

  public static DLL deleteBasedOnValue(DLL head, int value) {
    if(head == null) return head;
    if(head.data == value) return head.next;
    DLL last = head;
    DLL tmp = head.next;
    while(tmp != null) {
      if(tmp.data == value) break;
      last = tmp;
      tmp = tmp.next;
    }
    if(last.next != null)
      last.next = last.next.next;
    if(last.next.next != null)
      last.next.next.pre = last;

    return head;
  }

  public static DLL reverseList(DLL head) {
    DLL last = null;
    DLL curr = head;
    while(curr != null) {
      DLL tmp = curr.next;
      curr.next = last;
      if(last != null) last.pre = curr;
      last = curr;
      curr = tmp;
    }
    return last;
  }

  public static DLL reverseList2(DLL head) {
    DLL tmp = null;
    DLL curr = head;
    while(curr != null) {
      tmp = curr.pre;
      curr.pre = curr.next;
      curr.next = tmp;
      curr = curr.pre;
    }

    if(tmp != null) head = tmp.pre;
    return head;
  }

  public static void main(String[] args) {
    DLL head = new DLL(4);
    printLL(head);
    System.out.println(lengthLL(head));
    
    head = addNodeAtHead(head, new DLL(10));
    head = addNodeAtHead(head, new DLL(8));
    printLL(head);
    System.out.println(lengthLL(head));

    System.out.println("adding at tail");
    head = addAtTail(head, new DLL(1));
    head = addAtTail(head, new DLL(2));
    printLL(head);
    System.out.println(lengthLL(head));

    System.out.println("adding at middle");
    head = insertAtMiddle(head, new DLL(50), 3);
    printLL(head);
    System.out.println(lengthLL(head));

    /*System.out.println("deleting node");
    head = deleteBasedOnPos(head, 3);
    head = deleteBasedOnPos(head, 5);
    printLL(head);
    System.out.println(lengthLL(head));

    System.out.println("deleting node based on value");
    head = deleteBasedOnValue(head, 8);
    head = deleteBasedOnValue(head, 10);
    printLL(head);
    System.out.println(lengthLL(head));*/

    System.out.println("reversing linked list : ");
    //head = reverseList(head);
    head = reverseList2(head);
    printLL(head);
  }
}