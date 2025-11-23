package CountOperationstoObtainZero;

public class Solution {
    public int countOperations(int num1, int num2) {
        int cnt = 0;

        while(true){
            if(num1 == 0 || num2 == 0) break;

            if(num1 >= num2){
                num1 = num1 - num2;

            } else{
                num2 = num2 - num1;
            }
            ++cnt;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int num1 = 2, num2 = 3;
        int result = new Solution().countOperations(num1, num2);
        System.out.print(result);
    }
}