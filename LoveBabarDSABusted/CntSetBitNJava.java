class CntSetBitNJava {
  public static void main(String[] args) {
    long M = 1000000007;
    int no = 30;
    System.out.println(cntSetBitFrmZeroToN(no, M));
  }

  public static int cntSetBitFrmZeroToN(int no, long M) {
    if(no <= 1) return no;
    int x = findX(no);
    int twoPowXMinusOne = modFst(2l, x-1, M);
    int twoPowX = modFst(2l, x, M);

    return (x*twoPowXMinusOne)+(no-twoPowX+1)+cntSetBitFrmZeroToN(no-twoPowX, M);
  }

  public static int findX(int no) {
    int x = 0;
    while((1 << x) <= no) {
      x++;
    }
    return x-1;
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
}