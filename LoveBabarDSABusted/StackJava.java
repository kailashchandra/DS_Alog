public class StackJava {

  class StackDemo {
    public int size;
    public int top = -1;
    public int[] arr;

    public StackDemo(int size) {
      this.size = size;
      this.arr = new int[size];
    }

    public void push(int data) {
      //check for overflow stack
      if(top+1 >= size) {
        System.out.println("StackOverflow !!");
        return;
      }
      arr[++top] = data;
    }

    public int pop() {
      if(top <= -1) {
        System.out.println("stack underflow !!");
        return -1;
      }
      return arr[top--];
    }

    public int peek() {
      if(top <= -1) {
        System.out.println("stack underflow !!");
        return -1;
      }
      return arr[top];
    }

    public boolean isEmpty() {
      return top == -1;
    }
  }

  //Stack using Linked list
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  class StackLL {
    public Node head;

    StackLL(Node node) {
      this.head = node;
    }

    public void push(int data) {
      //check for overflow stack
      /*if(top+1 >= size) {
        System.out.println("StackOverflow !!");
        return;
      }*/
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
    }

    public int pop() {
      if(head == null) {
        System.out.println("stack underflow !!");
        return -1;
      }
      int data = head.data;
      head = head.next;
      return data;
    }

    public int peek() {
      if(head == null) {
        System.out.println("stack underflow !!");
        return -1;
      }
      return head.data;
    }

    public boolean isEmpty() {
      return head == null;
    }
  }
  
  public static void main(String[] args) {
    /*StackJava sj = new StackJava();
    StackJava.StackDemo sd = sj.new StackDemo(4);
    System.out.println("empty check "+sd.isEmpty());
    sd.push(1);
    sd.push(2);
    System.out.println("Pop operation on 2 "+sd.pop());
    sd.push(3);
    System.out.println("Peek operation on 3 "+sd.peek());
    System.out.println("Peek operation on 3 "+sd.peek());
    sd.push(4);
    sd.push(5);
    sd.push(6);
    System.out.println("empty check "+sd.isEmpty());
    System.out.println("Pop operation "+sd.pop());
    System.out.println("Pop operation "+sd.pop());
    System.out.println("Pop operation "+sd.pop());
    System.out.println("Pop operation "+sd.pop());
    System.out.println("Pop operation "+sd.pop());
    System.out.println("Pop operation "+sd.pop());
    System.out.println("empty check "+sd.isEmpty());*/


    //using linked list
    StackJava sj = new StackJava();
    StackJava.StackLL sl = sj.new StackLL(null);
    System.out.println("empty check "+sl.isEmpty());
    sl.push(1);
    sl.push(2);
    System.out.println("Pop operation on 2 "+sl.pop());
    sl.push(3);
    System.out.println("Peek operation on 3 "+sl.peek());
    System.out.println("Peek operation on 3 "+sl.peek());
    sl.push(4);
    sl.push(5);
    sl.push(6);
    System.out.println("empty check "+sl.isEmpty());
    System.out.println("Pop operation "+sl.pop());
    System.out.println("Pop operation "+sl.pop());
    System.out.println("Pop operation "+sl.pop());
    System.out.println("Pop operation "+sl.pop());
    System.out.println("Pop operation "+sl.pop());
    System.out.println("Pop operation "+sl.pop());
    System.out.println("empty check "+sl.isEmpty());
  }
}
