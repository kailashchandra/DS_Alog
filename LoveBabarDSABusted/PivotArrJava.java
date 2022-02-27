class PivotArrJava {
  public static void main(String[] args) {
    int arr[] = new int[] { 8, 10, 17, 1, 3 };
    System.out.println("Recursive : "+findPivot(arr, 0, arr.length-1));
    System.out.println("Iterative : "+findPivotIter(arr));
  }

  public static int findPivot(int arr[], int start, int end) {
    //base case
    if(start > end) return start;
        
    int mid = start + (end-start)/2;
        
    if(arr[mid] >= arr[0])
      return findPivot(arr, mid+1, end);
    else return findPivot(arr, start, mid-1);
  }

  public static int findPivotIter(int arr[]) {
    int start = 0;
    int end = arr.length-1;

    while(start <= end) {
      int mid = start + (end-start)/2;
      if(arr[mid] >= arr[0])
        start = mid+1;
      else end = mid-1;
    }
    return start;
  }
}