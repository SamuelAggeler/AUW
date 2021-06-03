package CE.Week2;
import java.util.*;

public class CountTheDivisors {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test1.in");
        Out.compareTo("public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        // In.close();
    }
    public static void testCase() {
        // Input using In.java class
        int n = In.readInt();
        long max = (long)Math.pow(10,10);
        Set <Long> Teiler = new HashSet<Long>();
        
        for(int i=0; i < n; i++) {
          Teiler.add(In.readLong());
        }

        long[] Teilerunique = new long[Teiler.size()];
        int counter = 0;
        for(Long i : Teiler) {
          Teilerunique[counter] = i;
          counter++;
        }
        Set<ArrayList<Long>> PowerSet = powerset(Teilerunique);
        
        long sum0 = 0;
        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;
        long sum4 = 0;
        long sum5 = 0;
        long sum6 = 0;
        long sum7 = 0;
        long sum8 = 0;
        long sum9 = 0;

        
        for(ArrayList subSet : PowerSet) {
          //System.out.println(subSet);
          
          if(subSet.size() ==1) {
            long gcd = (Long)subSet.get(0);
            long lcm = (Long)subSet.get(0);
                          if(lcm == 0) {
                lcm = 1;
              }
            sum0 = sum0 + max/lcm;
          }
          
          if(subSet.size() == 2) {
              long gcd = gcd((Long)subSet.get(0),(Long)subSet.get(1));
              long lcm = ((Long)subSet.get(0)*(Long)subSet.get(1)) /gcd;
              //System.out.println(gcd);
              if(lcm == 0) {
                lcm = 1;
              }
              
              sum1 =  sum1 + max/lcm;
          }
          if(subSet.size() ==3) {
            long gcd = gcd(gcd((Long)subSet.get(0),(Long)subSet.get(1)),(Long) subSet.get(2));
            long lcm = ((Long)subSet.get(0)*(Long)subSet.get(1)*(Long)subSet.get(2)) /gcd;
            
              if(lcm == 0) {
                lcm = 1;
              }
            
            sum2 =  sum2 + max/lcm;
        
          }
              if(subSet.size() == 4) {
            long gcd1 = gcd((Long)subSet.get(0),(Long)subSet.get(1));
            long gcd2 = gcd((Long)subSet.get(1),(Long)subSet.get(2));
            long gcd3 = gcd((Long)subSet.get(2),(Long)subSet.get(3));

            long gcd = gcd(gcd(gcd1,gcd2),gcd3);
            long lcm = ((Long)subSet.get(0)*(Long)subSet.get(1)*(Long)subSet.get(2)*(Long)subSet.get(3)) /gcd;
            
                          if(lcm == 0) {
                lcm = 1;
              }
              
            sum3 =  sum3 + max/lcm;
            }
            
            if(subSet.size() == 5) {
            long gcd1 = gcd((Long)subSet.get(0),(Long)subSet.get(1));
            long gcd2 = gcd((Long)subSet.get(2),(Long)subSet.get(3));
            long gcd3 = gcd((Long)subSet.get(3),(Long)subSet.get(4));

            long gcd = gcd(gcd(gcd1,gcd2),gcd3);
            long lcm = ((Long)subSet.get(0)*(Long)subSet.get(1)*(Long)subSet.get(2)*(Long)subSet.get(3)*(Long)subSet.get(4)) /gcd;
            
                          if(lcm == 0) {
                lcm = 1;
              }
              
            sum4 =  sum4 + max/lcm;
            }
            if(subSet.size() == 6) {
            long gcd1 = gcd((Long)subSet.get(0),(Long)subSet.get(1));
            long gcd2 = gcd((Long)subSet.get(2),(Long)subSet.get(3));
            long gcd3 = gcd((Long)subSet.get(3),(Long)subSet.get(4));
            long gcd4 = gcd((Long)subSet.get(4),(Long)subSet.get(5));

            long gcd = gcd(gcd(gcd(gcd1,gcd2),gcd3),gcd4);
            long lcm = ((Long)subSet.get(0)*(Long)subSet.get(1)*(Long)subSet.get(2)*(Long)subSet.get(3)*(Long)subSet.get(4)*(Long)subSet.get(5)) / gcd;
            
                          if(lcm == 0) {
                lcm = 1;
              }
            sum5 =  sum5 + max/lcm;
            }
            if(subSet.size() == 7) {
            long gcd1 = gcd((Long)subSet.get(0),(Long)subSet.get(1));
            long gcd2 = gcd((Long)subSet.get(2),(Long)subSet.get(3));
            long gcd3 = gcd((Long)subSet.get(3),(Long)subSet.get(4));
            long gcd4 = gcd((Long)subSet.get(4),(Long)subSet.get(5));
            long gcd5 = gcd((Long)subSet.get(5),(Long)subSet.get(6));

            long gcd = gcd(gcd(gcd(gcd(gcd1,gcd2),gcd3),gcd4),gcd5);
            long lcm = ((Long)subSet.get(0)*(Long)subSet.get(1)*(Long)subSet.get(2)*(Long)subSet.get(3)*(Long)subSet.get(4)*(Long)subSet.get(5)*(Long)subSet.get(6)) /gcd;
              
                            if(lcm == 0) {
                lcm = 1;
              }
            sum6 =  sum6 + max/lcm;
            }
            if(subSet.size() == 8) {
            long gcd1 = gcd((Long)subSet.get(0),(Long)subSet.get(1));
            long gcd2 = gcd((Long)subSet.get(2),(Long)subSet.get(3));
            long gcd3 = gcd((Long)subSet.get(3),(Long)subSet.get(4));
            long gcd4 = gcd((Long)subSet.get(4),(Long)subSet.get(5));
            long gcd5 = gcd((Long)subSet.get(5),(Long)subSet.get(6));
            long gcd6 = gcd((Long)subSet.get(6),(Long)subSet.get(7));

            long gcd = gcd(gcd(gcd(gcd(gcd(gcd1,gcd2),gcd3),gcd4),gcd5),gcd6);
            long lcm = ((Long)subSet.get(0)*(Long)subSet.get(1)*(Long)subSet.get(2)*(Long)subSet.get(3)*(Long)subSet.get(4)*(Long)subSet.get(5)*(Long)subSet.get(6)*(Long)subSet.get(7))/gcd;
              
                            if(lcm == 0) {
                lcm = 1;
              }
            sum7 =  sum7 + max/lcm;
            }
            
            if(subSet.size() == 9) {
            long gcd1 = gcd((Long)subSet.get(0),(Long)subSet.get(1));
            long gcd2 = gcd((Long)subSet.get(2),(Long)subSet.get(3));
            long gcd3 = gcd((Long)subSet.get(3),(Long)subSet.get(4));
            long gcd4 = gcd((Long)subSet.get(4),(Long)subSet.get(5));
            long gcd5 = gcd((Long)subSet.get(5),(Long)subSet.get(6));
            long gcd6 = gcd((Long)subSet.get(6),(Long)subSet.get(7));
            long gcd7 = gcd((Long)subSet.get(7),(Long)subSet.get(8));

            long gcd = gcd(gcd(gcd(gcd(gcd(gcd(gcd1,gcd2),gcd3),gcd4),gcd5),gcd6),gcd7);
            long lcm = ((Long)subSet.get(0)*(Long)subSet.get(1)*(Long)subSet.get(2)*(Long)subSet.get(3)*(Long)subSet.get(4)*(Long)subSet.get(5)*(Long)subSet.get(6)*(Long)subSet.get(7)*(Long)subSet.get(8))/gcd;
              
                            if(lcm == 0) {
                lcm = 1;
              }
            sum8 =  sum8 + max/lcm;
            }
            if(subSet.size() == 10) {
            long gcd1 = gcd((Long)subSet.get(0),(Long)subSet.get(1));
            long gcd2 = gcd((Long)subSet.get(2),(Long)subSet.get(3));
            long gcd3 = gcd((Long)subSet.get(3),(Long)subSet.get(4));
            long gcd4 = gcd((Long)subSet.get(4),(Long)subSet.get(5));
            long gcd5 = gcd((Long)subSet.get(5),(Long)subSet.get(6));
            long gcd6 = gcd((Long)subSet.get(6),(Long)subSet.get(7));
            long gcd7 = gcd((Long)subSet.get(7),(Long)subSet.get(8));
            long gcd8 = gcd((Long)subSet.get(8),(Long)subSet.get(9));

            long gcd = gcd(gcd(gcd(gcd(gcd(gcd(gcd(gcd1,gcd2),gcd3),gcd4),gcd5),gcd6),gcd7),gcd8);
            long lcm = ((Long)subSet.get(0)*(Long)subSet.get(1)*(Long)subSet.get(2)*(Long)subSet.get(3)*(Long)subSet.get(4)*(Long)subSet.get(5)*(Long)subSet.get(6)*(Long)subSet.get(7)*(Long)subSet.get(8)*(Long)subSet.get(9))/gcd;
              
                            if(lcm == 0) {
                lcm = 1;
              }
            
          sum9 =  sum9 + max/lcm;
          }
          
        
        }
        if(Teiler.size()==1) {
          Out.println(max - sum0);
        }
        
        if(Teiler.size()==2) {
          Out.println(max - sum0 + sum1 );
        }

        if(Teiler.size()==3) {
          Out.println(max - sum0 + sum1 - sum2);
        }
        if(Teiler.size()==4) {
          Out.println(max - sum0 + sum1 - sum2 + sum3);
        }
        if(Teiler.size()==5) {
          Out.println(max - sum0 + sum1 - sum2 + sum3 - sum4);
        }
        if(Teiler.size()==6) {
          Out.println(max - sum0 + sum1 - sum2 + sum3 - sum4 + sum5);
        }if(Teiler.size()==7) {
          Out.println(max - sum0 + sum1 - sum2 + sum3 - sum4 + sum5 - sum6);
        }
        if(Teiler.size()==8) {
          Out.println(max - sum0 + sum1 - sum2 + sum3 - sum4 + sum5 - sum6 + sum7);
        }
        if(Teiler.size()==9) {
          Out.println(max - sum0 + sum1 - sum2 + sum3 - sum4 + sum5 - sum6 + sum7 - sum8);
        }
        if(Teiler.size()==10) {
          Out.println(max - sum0 + sum1 - sum2 + sum3 - sum4 + sum5 - sum6 + sum7 - sum8 + sum9);
        }

    

    }
    static Set<ArrayList<Long>> powerset(long[] arr) {
      
      
      int n = arr.length;
      
      Set<ArrayList<Long>> result = new HashSet<ArrayList<Long>>();
      
      for(int i=0; i < (1<<n); i++){
        ArrayList<Long> test = new ArrayList<Long>();
            for (int j = 0; j < n; j++){
                if ((i & (1 << j)) > 0){
                  test.add(arr[j]);
            }
        }
        result.add(test);
    } 
    return result;
  }
  
    private static long gcd(long x, long y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
}
