package uglyNumber2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Integer> ts = new TreeSet<>();
        Integer result = 1;
        ts.add(1);

        for(int i=0; i<n; i++){
            Integer ugly = ts.pollFirst();
            result = ugly;

            ts.add(ugly * 2);
            ts.add(ugly * 3);
            ts.add(ugly * 5);
        }

        return result.intValue();
    }
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int result = new Solution().nthUglyNumber(n);
    	System.out.print(result);
    }
}
