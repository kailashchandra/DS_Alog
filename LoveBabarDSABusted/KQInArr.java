class KQInArr {
  int k;
  int n;
  int arr[];
  int front[];
  int rear[];
  int next[];
  int freespot;
  
  public KQInArr(int n, int k) {
    //initialize all the 5 variable.+ arr
    this.n = n;
    this.k = k;
    arr = new int[n];
    front = new int[k];
    rear = new int[k];
    
    for(int i=0;i<k;i++) {
      front[i] = -1;
      rear[i] = -1;
    }

    next = new int[n];

    for(int i=0;i<n;i++) {
      next[i] = i+1;
    }
    next[n-1] = -1;
    freespot = 0;
  }

  public void enqueue(int data, int qn) {
    //check for overflow.
    if(freespot == -1) {
      System.out.println("overflow condition");
      return;
    }
    
    //find index where we want to insert
    int index = freespot;
    
    //update freespot
    freespot = next[index];
    
    //handle 1st elemnt insertion because front & rear = -1;
    if(front[qn-1] == -1) front[qn-1] = index;
    else {
      //link pre ele to new ele.
      next[rear[qn-1]] = index;
    }

    //update next to -1 which represent end of queue;
    next[index] = -1;

    //update rear
    rear[qn-1] = index;
    
    //add ele at index
    arr[index] = data;
  }

  public int dequeue(int qn) {
    //check empty 
    if(front[qn-1] == -1) {
      System.out.println("empty q");
      return -1;
    }

    //find index where we want to do pop();
    int index = front[qn-1];

    //update front;
    front[qn-1] = next[index];

    //update next
    next[index] = freespot;

    freespot = index;

    return arr[index];
  }
  
  public static void main(String[] args) {
    KQInArr kQ = new KQInArr(5, 3);
    System.out.println();
    System.out.println(kQ.dequeue(1));
    System.out.println();
    System.out.println(kQ.dequeue(2));
    System.out.println();
    System.out.println(kQ.dequeue(3));

    //enqueue
    kQ.enqueue(10, 1);
    kQ.enqueue(12, 2);
    kQ.enqueue(13, 3);
    kQ.enqueue(20, 1);

    System.out.println(kQ.dequeue(1));
    System.out.println();
    System.out.println(kQ.dequeue(2));
    System.out.println();
    System.out.println(kQ.dequeue(3));
    
    System.out.println();
    System.out.println(kQ.dequeue(1));
    System.out.println();
    System.out.println(kQ.dequeue(2));
    System.out.println();
    System.out.println(kQ.dequeue(3));

    System.out.println();
    System.out.println(kQ.dequeue(1));
  }
}