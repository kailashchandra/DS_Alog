class ModFstExpJava {
  public static void main(String[] args) {
    long M = 1000000007;
    long x = 4;
    int n = 2;

    System.out.println(modFst(x,n, M));

    System.out.println(fstExpRec(x,n, M));
  }
  //(x^n)
  public static int modFst(long x, int n, long M) {
    long res = 1;
    while(n > 0) {
      if((n&1) == 1) {
        res = ((res)%M * (x)%M)%M;
      }
      x = (x%M * x%M)%M;
      n = n>>1;
    }
    return (int)res;
  }

  //x^n using recursion
  public static int fstExpRec(long x, long n, long M) {
    //base case
    if(n == 0) return 1;
    if(n == 1) return (int)x;

    //recursive call
    int ans = (int)(fstExpRec(x, n>>1, M)%M);

    //processing
    if((n&1) ==  0)
      return ans*ans;
    else return (int)(x*ans*ans);
  }
  
}