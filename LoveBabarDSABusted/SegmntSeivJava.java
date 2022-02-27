import java.util.*;
class SegmntSeivJava {
  public static void main(String[] args) {
    int l = 110;
    int r = 130;
    for(Integer pr : segmentSev(l, r)) 
      System.out.print(pr+ " ");
  }

  public static List<Integer> segmentSev(int l, int r) {
    List<Integer> result = new ArrayList<>();

    //generating prime till sqrt r;
    int sqrtR = (int)Math.sqrt(r);
    List<Integer> prime = simpleSev(sqrtR);
     //creating dummy arr from l to r;
    boolean dummy[] = new boolean[r-l+1];
    for(int i=0;i<r-l+1;i++) {
      dummy[i] = true;
    }
    //mark all multiple of prime in dummy.
    for(int pr : prime) {
      //finding first multiple
      int firstMultiple = (l/pr)*pr;
      if(firstMultiple < l) firstMultiple += pr;
      
      for(int j = Math.max(pr*pr, firstMultiple); j<=r;j += pr) {
        dummy[j-l] = false;
      }
    }
    //getting all the prime between l to r;
    for(int i=l;i<=r;i++) {
      if(dummy[i-l])
        result.add(i);
    }
    return result;
  }

  public static List<Integer> simpleSev(int n) {
    List<Integer> result = new ArrayList<>();
    if(n < 2) {
      return result;
    }
    boolean sev[] = new boolean[n+1];
    for(int i=2;i<sev.length;i++) {
      sev[i] = true;
    }

    sev[0] = false;
    sev[1] = false;

    for(int i=2;i*i<=n;i++) {
      if(sev[i]) {
        for(int j= i*i;j<=n;j+=i) {
          sev[j] = false;
        }
      }
    }

    for(int i=0;i<sev.length;i++) {
        if(sev[i])          
          result.add(i);
    }
    return result;
  }
}