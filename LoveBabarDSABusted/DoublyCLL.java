class DoublyCLL {

  static class CDLL {
    public int data;
    public CDLL next;
    public CDLL pre;

    public CDLL(int data) {
      this.data = data;
    }
  }

  public static void printLL(CDLL tail) {
    if(tail == null) return;
    CDLL temp = tail;
    System.out.println();
    do {
      System.out.print(temp.data+" ");
      temp = temp.next;
    } while (temp != tail);
    System.out.println();
  }

  public static int lengthLL(CDLL tail) {
    int len = 0;
    if(tail == null) return 0;
    CDLL temp = tail;
    System.out.println();
    do {
      len++;
      temp = temp.next;
    } while (temp != tail);
    System.out.println();
    return len;
  }

  public static CDLL addNode(CDLL tail, int ele, int d) {
    //create new node
    CDLL tmp = new CDLL(d);
    //empty list
    if(tail == null) {
      tail = tmp;
      tmp.next = tail;
      tail.pre = tmp;
      return tail;
    } else {
      //non empty list
      CDLL curr = tail.next;
      while(curr.data != ele) {
        if(curr == tail) break;
        curr = curr.next;
      }
      //found data
      //adding in middle
      tmp.next = curr.next;
      curr.next.pre = tmp;
      curr.next = tmp;
      tmp.pre = curr;
      //adding at last
      if(curr == tail) tail = tmp;
      return tail;
    }
  }

  public static CDLL deleteBasedOnValue(CDLL tail, int value) {
    if(tail == null) return tail;

    CDLL last = tail;
    CDLL curr = tail.next;
    //both pointing to single ele.
    if(curr == last && curr.data == value) return null;
    else if(curr == last) return tail;

    while(curr.data != value) {
      curr = curr.next;
      last = last.next;
    }
    last.next = curr.next;
    curr.pre = last;
    if(tail == curr) tail = last;

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
    CDLL tail = null;
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