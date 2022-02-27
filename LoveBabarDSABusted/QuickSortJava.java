class QuickSortJava {
  public static void main(String[] args) {
    int arr[] = new int[] { 8, 10, 17, 1, 3 };
    quickSortJava(arr, 0, 4);
    System.out.println();
    //printing array
    for(int ele : arr) {
      System.out.print(ele+" ");
    }
  }

  public static void quickSortJava(int arr[], int s, int e) {
    //base case
    if(s >= e) return;

    //partition krenge
    int p = partition(arr, s, e);
    
    //left part pe quick sort
    quickSortJava(arr, s, p-1);
    
    //right part pe quick sort
    quickSortJava(arr, p+1, e);
  }

  public static int partition(int arr[], int s, int e) {
    int pivot = arr[s];

    //counting all element < to first element;
    int cnt = 0;
    for(int i=s+1;i<=e;i++) {
      if(pivot >= arr[i]) cnt++;
    }

    int pivotIndex = s + cnt;
    //swapping with pivot index to first ele
    int tmp = arr[s];
    arr[s] = arr[pivotIndex];
    arr[pivotIndex] = tmp;

    int i = s;
    int j = e;
    //putting all less than to left and greater than at right side of pivot.
    while(i < pivotIndex && j > pivotIndex) {
      //either put = here
      while(arr[i] < pivot) i++;
      //or here.
      while(arr[j] >= pivot) j--;

      if(i < pivotIndex && j > pivotIndex) {
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }
    }

    return pivotIndex;
  }
}