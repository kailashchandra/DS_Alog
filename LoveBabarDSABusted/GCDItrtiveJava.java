class GCDItertiveJava {
  public static void main(String[] args) {
    int a = 24;
    int b = 48;

    System.out.println(gcd(a,b));
  }
  
  public static int gcd(int a, int b) {
    if(a == 0) return b;
    if(b == 0) return a;
    while(a != b) {
      if(a>b) a -= b;
      else b -= a;
    }
    return a;
  }

  
}