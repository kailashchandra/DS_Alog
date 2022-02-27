class EKO {
  public static void main(String[] args) {
    //int m = 7;
    int m = 20;
    //int arr[] = new int[] { 20, 15, 10, 17 };
    int arr[] = new int[] { 4, 42, 40, 26, 46 };


    System.out.println(findHeight(arr, m));
  }

  public static int findHeight(int arr[], int m) {
    int start = 0;
    int end = findMax(arr);
    int ans = -1;

    while(start <= end) {
      int mid = start+(end-start)/2;

      int sum = findSum(arr, mid);
      
      if(sum >= m) {
        ans = mid;
        start = mid+1;
      } else {
        end = mid-1;
      }
    }
    return ans;
  }

  public static int findMax(int arr[]) {
    int max = -1;
    for(int i=0;i<arr.length;i++) {
      max = Math.max(arr[i], max);
    }
    return max;
  }

  public static int findSum(int arr[], int mid) {
    int sum = 0;
    for(int i =0;i<arr.length;i++) {
      if(arr[i] > mid) {
        sum += (arr[i]-mid);
      }
    }
    return sum;
  }
}