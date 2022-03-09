class DivideCSLLIntoTwoHalf {

  static class CSLL {
    public int data;
    public CSLL next;

    public CSLL(int data) {
      this.data = data;
    }
  }
  //this can be used to find list is circluar or not ?
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

  public static void twoHalf(CSLL head) {
    if(head == null || head.next == null) System.out.println("Empty list");

    if(head.next == head) System.out.println("single node"+head.data);
    CSLL slow = head;
    CSLL fast = head;
    while(fast.next != head && fast.next.next != head) {
      slow = slow.next;
      fast = fast.next.next;
    }

    if(fast.next.next == head) fast = fast.next;

    CSLL head2 = slow.next;
    slow.next = head;
    fast.next = head2;

    System.out.println("Printing first half of List");
    printLL(head);
    System.out.println("Printing 2nd half of List");
    printLL(head2);
  }

  public static void main(String[] args) {
    CSLL tail = null;
    tail = addNode(tail, 2, 1);
    tail = addNode(tail, 1, 2);

    System.out.println("adding at tail");
    tail = addNode(tail, 2, 3);
    printLL(tail);
    
    System.out.println("adding at middle");
    tail = addNode(tail, 2, 5);
    printLL(tail);

    twoHalf(tail.next);
  }
}