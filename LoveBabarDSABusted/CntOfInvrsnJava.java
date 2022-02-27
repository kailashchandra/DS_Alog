class CntOfInvrsnJava {
  public static void main(String[] args) {
    int arr[] = new int[] {9,1,7,5,0};
    int count = mergeSort(arr, 0, 4);
    System.out.println();
    //printing array
    for(int ele : arr) {
      System.out.print(ele+" ");
    }
    System.out.println();
    System.out.println("count of inversion : "+count);
  }

  public static int mergeSort(int arr[], int s, int e) {
    int count = 0;
    //base case
    //= because if only one element then no need to break it down.
    if(s >= e) return count;
    int mid = s+(e-s)/2;
    //getting start and end point, so that we can break the array. in mergeArr method and merge back in sorted way
    count += mergeSort(arr, s, mid);
    count += mergeSort(arr, mid+1, e);
    //here we actually break down the array and then merge back in sorted way.
    //optimized version of breakNmergeArr
    count += breakNmergeArrOptmzd(arr, s, e);

    return count;
  }

  public static int breakNmergeArrOptmzd(int arr[], int s, int e) {
    //we got start and end now will divide into two halfs by calculating mid point.
    int swap = 0;
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
        swap += (mid-indx1+1);
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

    return swap;
  }


  //gap technique to solve merge two sorted arr in same space.
}