class SlctionSrtJava {
  public static void main(String[] args) {
    int arr[] = new int[] { 8, 2, 4, 3, 5, 0, 1 };

    //slctnSort(arr, arr.length);
    slctnSortRec(arr, 0);

    System.out.println();
    for(int i : arr)
      System.out.print(i+" ");
    System.out.println();
  }

  //iterative approach
  public static void slctnSort(int arr[], int n) {
    for(int i=0;i<n-1;i++) {
      int minIndex = i;
      for(int j=i+1;j<n;j++) {
        if(arr[minIndex] > arr[j]) minIndex = j;
      }
      int tmp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = tmp;
    }
  }

  //recursive approach
  public static void slctnSortRec(int arr[], int i) {
    //base case
    if(i >= arr.length-1) return;
    
    //processing
    int minIndex = i;
    for(int j=i+1;j<arr.length;j++) {
      if(arr[minIndex] > arr[j]) minIndex = j;
    }
    int tmp = arr[minIndex];
    arr[minIndex] = arr[i];
    arr[i] = tmp;

    //RR
    slctnSortRec(arr, i+1);
  }
}