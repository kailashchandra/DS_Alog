class MergeSortJava {
  public static void main(String[] args) {
    int arr[] = new int[] {9,1,7,5,0};
    mergeSort(arr, 0, 4);
    System.out.println();
    //printing array
    for(int ele : arr) {
      System.out.print(ele+" ");
    }
  }

  public static void mergeSort(int arr[], int s, int e) {
    //base case
    //= because if only one element then no need to break it down.
    if(s >= e) return;

    int mid = s+(e-s)/2;

    //getting start and end point, so that we can break the array. in mergeArr method and merge back in sorted way
    mergeSort(arr, s, mid);
    mergeSort(arr, mid+1, e);

    //here we actually break down the array and then merge back in sorted way.
    //breakNmergeArr(arr, s, e);
    
    
    //optimized version of breakNmergeArr
    breakNmergeArrOptmzd(arr, s, e);
  }

  public static void breakNmergeArr(int arr[], int s, int e) {
    //we got start and end now will divide into two halfs by calculating mid point.
    int mid = s+(e-s)/2;

    //will create two array for both 1st n 2nd half array n copy ele of original array to this two array.
    int len1 = mid-s+1;
    int len2 = e-mid;
    int arr1[] = new int[len1];
    int arr2[] = new int[len2];

    //coping ele from original arr to arr1 n arr2
    int mainArrIndx = s;
    for(int i=0;i<len1;i++) 
      arr1[i] = arr[mainArrIndx++];

    mainArrIndx = mid+1;
    for(int i=0;i<len2;i++) 
      arr2[i] = arr[mainArrIndx++];

    //merge two sorted array logic.
    mainArrIndx = s;
    int indx1 = 0;
    int indx2 = 0;
    while(indx1 < len1 && indx2 < len2) {
        if(arr1[indx1] < arr2[indx2]){
          arr[mainArrIndx++] = arr1[indx1++];
        }
        else{
          arr[mainArrIndx++] = arr2[indx2++];
        }
    }

    //copy first array k element ko
    while(indx1 < len1) {
      arr[mainArrIndx++] = arr1[indx1++];
    }

    //copy kardo second array k remaining element ko
    while(indx2 < len2) {
      arr[mainArrIndx++] = arr2[indx2++];
    }
  }


  public static void breakNmergeArrOptmzd(int arr[], int s, int e) {
    //we got start and end now will divide into two halfs by calculating mid point.
    int mid = s+(e-s)/2;

    //merge two sorted array logic.
    int indx1 = s;
    int indx2 = mid+1;

    //creating new array
    int tmp[] = new int[e-s+1];
    int mainArrIndx = 0;

    while(indx1 <= mid && indx2 <= e) {
      if(arr[indx1] < arr[indx2]){
        tmp[mainArrIndx++] = arr[indx1++];
      }
      else{
        tmp[mainArrIndx++] = arr[indx2++];
      }
    }

    //copy first array k element ko
    while(indx1 <= mid) {
      tmp[mainArrIndx++] = arr[indx1++];
    }

    //copy kardo second array k remaining element ko
    while(indx2 <= e) {
      tmp[mainArrIndx++] = arr[indx2++];
    }

    //copy back to main arr
    for(int i=s;i<=e;i++) {
      arr[i] = tmp[i-s];
    }
  }


  //gap technique to solve merge two sorted arr in same space.
}