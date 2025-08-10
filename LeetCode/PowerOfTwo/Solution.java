package PowerOfTwo;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean result = false;

        if(n <= 0)  return false;

        String bin = Integer.toBinaryString(n);
        if(bin.length() >=1 && bin.charAt(0) == '1'){
            String zeros = (bin.length() == 1) ? "" : bin.substring(1, bin.length());
            if(!zeros.contains("1")){
                result = true;
            }
        }
        return result;
        // return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        boolean res = new Solution().isPowerOfTwo(1);
        System.out.printf("res: %b", res);
    }
}
