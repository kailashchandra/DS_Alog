class RvrseStrRecJava {
  public static void main(String[] args) {
    String s = "abcdef";
    char arr[] = s.toCharArray();

    System.out.println(reverseStringRec(arr, 0, s.length()-1));

    s = "abcdef";
    arr = s.toCharArray();

    System.out.println(reverseStrOnePointer(arr, 0));
  }

  public static String reverseStringRec(char arr[], int start, int end) {
    if(start > end) return new String(arr);
    
    //swaping char
    char temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;

    return reverseStringRec(arr, ++start, --end);
  }

  //using one pointer
  public static String reverseStrOnePointer(char arr[], int start) {

    if(start > arr.length-1-start) return new String(arr);
    
    //swaping char
    char temp = arr[start];
    arr[start] = arr[arr.length-1-start];
    arr[arr.length-1-start] = temp;

    return reverseStrOnePointer(arr, ++start);
  }
}