class InsertionSortJava {
  public static void main(String[] args) {
    int arr[] = new int[] { 0, 5, 6, 10, 8, 7, 2 };
    
    //insertionSort(arr);
    insertionSortRec(arr, 1);
    
    System.out.println();
    for(int a : arr) {
      System.out.print(a+" ");
    }
    System.out.println();
  }

//iterative
  public static void insertionSort(int arr[]) { 
    for(int i=1;i<arr.length;i++) {
      int j = i-1;
      int ele = arr[i];
      while(j >= 0) {
        if(arr[j] > ele) {
          arr[j+1] = arr[j];
        } else break;
        j--;
      }
      arr[j+1] = ele;
    }
  }

  //recursive
  public static void insertionSortRec(int arr[], int i) { 
    //base case
    if(i >= arr.length) return;
    
    //processing
    int j = i-1;
    int ele = arr[i];
    while(j >= 0) {
      if(arr[j] > ele) {
        arr[j+1] = arr[j];
      } else break;
        j--;
    }
    arr[j+1] = ele;

    insertionSortRec(arr, i+1);
  }
}