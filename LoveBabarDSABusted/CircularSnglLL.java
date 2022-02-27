class CircularSnglLL {

  static class CSLL {
    public int data;
    public CSLL next;

    public CSLL(int data) {
      this.data = data;
    }
  }

  public static void printLL(CSLL tail) {
    if(tail == null) return;
    CSLL temp = tail;
    System.out.println();
    do {
      System.out.print(temp.data+" ");
      temp = temp.next;
    } while (temp != tail);
    System.out.println();
  }

  public static int lengthLL(CSLL tail) {
    int len = 0;
    if(tail == null) return 0;
    CSLL temp = tail;
    System.out.println();
    do {
      len++;
      temp = temp.next;
    } while (temp != tail);
    System.out.println();
    return len;
  }

  public static CSLL addNode(CSLL tail, int ele, int d) {
    //create new node
    CSLL tmp = new CSLL(d);
    //empty list
    if(tail == null) {
      tail = tmp;
      tmp.next = tail;
      return tail;
    } else {
      //non empty list
      CSLL curr = tail.next;
      while(curr.data != ele) {
        if(curr == tail) break;
        curr = curr.next;
      }
      //found data
      //adding in middle
      tmp.next = curr.next;
      curr.next = tmp;
      //adding at last
      if(curr == tail) tail = tmp;
      return tail;
    }
  }

  public static CSLL deleteBasedOnValue(CSLL tail, int value) {
    if(tail == null) return tail;

    CSLL pre = tail;
    CSLL curr = tail.next;
    //both pointing to single ele.
    if(curr == pre && curr.data == value) return null;
    else if(curr == pre) return tail;

    while(curr.data != value) {
      curr = curr.next;
      pre = pre.next;
    }
    pre.next = curr.next;
    if(tail == curr) tail = pre;

    return tail;
  }

  /*public static DLL deleteBasedOnPos(DLL head, int pos) {
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
  }*/

  public static void main(String[] args) {
    CSLL tail = null;
    printLL(tail);
    System.out.println(lengthLL(tail));
    
    tail = addNode(tail, 2, 1);
    tail = addNode(tail, 1, 2);
    printLL(tail);
    System.out.println(lengthLL(tail));
    /*tail = deleteBasedOnValue(tail, 1);
    printLL(tail);
    System.out.println(lengthLL(tail));*/

    System.out.println("adding at tail");
    tail = addNode(tail, 2, 3);
    printLL(tail);
    System.out.println(lengthLL(tail));

    System.out.println("adding at middle");
    tail = addNode(tail, 2, 5);
    printLL(tail);
    System.out.println(lengthLL(tail));

    System.out.println("deleting node based on value");
    tail = deleteBasedOnValue(tail, 3);
    tail = deleteBasedOnValue(tail, 5);
    printLL(tail);
    System.out.println(lengthLL(tail));

    /*System.out.println("deleting node");
    head = deleteBasedOnPos(head, 3);
    head = deleteBasedOnPos(head, 5);
    printLL(head);
    System.out.println(lengthLL(head));*/
  }
}