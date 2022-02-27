class BubbleSortJava {
  public static void main(String[] args) {
    //int arr[] = new int[] { 3, 2, 1, 0, 0, -5 };
    int arr[] = new int[] { -5, 0, 0, 1, 2, 3 };
    //bubbleSortArr(arr);
    bubbleSortRec(arr, 6);
    System.out.println();
    for(int a : arr) {
      System.out.print(a+" ");
    }
    System.out.println();
  }

  public static void bubbleSortArr(int arr[]) {
    for(int i=0;i<arr.length-1;i++) {
      int j = 0;
      boolean flag = false;
      while(j < arr.length-1-i) {
        if(arr[j] > arr[j+1]) {
          flag = true;
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
        j++;
      }
      if(!flag) break;
    }
  }

  public static void bubbleSortRec(int arr[], int n) {
    //base case
    if(n <= 1) return;

    boolean swaped = false;
    //processing
    for(int i=0;i<n-1;i++) {
      if(arr[i] > arr[i+1]) {
        swaped = true;
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
      }
    }
    //base case
    if(!swaped) return;

    bubbleSortRec(arr, n-1);
  }
}