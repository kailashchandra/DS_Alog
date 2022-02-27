class FctModJava {
  public static void main(String[] args) {
    long M = 1000000007;
    long x = 212;

    System.out.println(factMod(x, M));
  }
  
  public static int factMod(long x, long m) {
    long res = 1;
    while(x-- >= 1l) {
      res = ((res)%m * (x)%m)%m;
    }
    return (int)res;
  }  
}