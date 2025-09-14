package ConvertIntegertotheSumofTwoNoZeroIntegers;

public class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];

        for(int a=1; a<n; a++){
            int b = n-a;

            if(isNoZeroInteger(a) && isNoZeroInteger(b)){
                result[0] =  a;
                result[1] =  b;
                break;
            }
        }

        return result;
    }

    public boolean isNoZeroInteger(int n){
        boolean noZeroInteger = true;

        while(n > 0){
            if(n%10 == 0){
                noZeroInteger = false;
                break;
            }

            n = n/10;
        }

        return noZeroInteger;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] result = new Solution().getNoZeroIntegers(n);

        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}