public class QueueJava {

  class QueueDemo {
    public int size;
    public int front = 0;
    public int rear = 0;
    public int[] arr;

    public QueueDemo(int size) {
      this.size = size;
      this.arr = new int[size];
    }

    public void add(int data) {
      //check for overflow Queue
      if(rear == size) {
        System.out.println("Queue overfloow !!");
        return;
      }
      arr[rear++] = data;
    }

    public int poll() {
      if(front == rear) {
        System.out.println("Queue underflow !!");
        front = 0;
        rear = 0;
        return -1;
      }
      
      return arr[front++];
    }

    public int peek() {
      if(front == rear) {
        System.out.println("Queue underflow !!");
        front = 0;
        rear = 0;
        return -1;
      }
      return arr[front];
    }

    public boolean isEmpty() {
      return front == rear;
    }
  }

  //Queue using Linked list
  
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  
  class QueueLL {
    public Node head;
    public Node tail;

    QueueLL(Node node) {
      this.head = node;
      this.tail = head;
    }

    public void add(int data) {
      //check for overflow stack
      Node newNode = new Node(data);
      if(head == null) {
        head = newNode;
        tail = head; 
      } else {
        tail.next = newNode;
        tail = newNode;
      }
    }

    public int poll() {
      if(head == null) {
        System.out.println("Queue underflow !!");
        return -1;
      }
      int data = head.data;
      head = head.next;
      return data;
    }

    public int peek() {
      if(head == null) {
        System.out.println("Queue underflow !!");
        return -1;
      }
      return head.data;
    }

    public boolean isEmpty() {
      return head == null;
    }
  }
  
  public static void main(String[] args) {
    /*QueueJava qj = new QueueJava();
    QueueJava.QueueDemo qd = qj.new QueueDemo(4);
    System.out.println("empty check "+qd.isEmpty());
    qd.add(1);
    qd.add(2);
    System.out.println("Poll operation on 1 "+qd.poll());
    qd.add(3);
    System.out.println("Peek operation on 2 "+qd.peek());
    qd.add(4);
    qd.add(5);
    qd.add(6);
    System.out.println("empty check "+qd.isEmpty());
    System.out.println("poll operation "+qd.poll());
    System.out.println("poll operation "+qd.poll());
    System.out.println("poll operation "+qd.poll());
    System.out.println("poll operation "+qd.poll());
    System.out.println("poll operation "+qd.poll());
    System.out.println("poll operation "+qd.poll());
    System.out.println("empty check "+qd.isEmpty());*/


    //using linked list
    
    QueueJava qj = new QueueJava();
    QueueJava.QueueLL ql = qj.new QueueLL(null);
    System.out.println("empty check "+ql.isEmpty());
    ql.add(1);
    ql.add(2);
    System.out.println("poll operation "+ql.poll());
    ql.add(3);
    System.out.println("Peek operation "+ql.peek());
    ql.add(4);
    ql.add(5);
    ql.add(6);
    System.out.println("empty check "+ql.isEmpty());
    System.out.println("poll operation "+ql.poll());
    System.out.println("poll operation "+ql.poll());
    System.out.println("poll operation "+ql.poll());
    System.out.println("poll operation "+ql.poll());
    System.out.println("poll operation "+ql.poll());
    System.out.println("poll operation "+ql.poll());
    System.out.println("empty check "+ql.isEmpty());
  }
}
