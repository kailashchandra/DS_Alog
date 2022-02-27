class SayDigitJava {
  public static void main(String[] args) {
    int n = 100000;
    String arr[] = new String[]{ "Zero", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten" };
    System.out.println();
    sayDigit(n, arr);
  }

//Head Recursion.
  public static void sayDigit(int n, String arr[]) {
    //base case;
    if(n == 0) return;

    //processing part1
    int digit = n%10;

    //RR.
    sayDigit(n/10, arr);

    //processing part 2
    System.out.print(arr[digit]+" ");
  }
  
}