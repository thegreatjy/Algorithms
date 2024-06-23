package JumpGameVII;

public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length() - 1) == '1') return false;

        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        int farthest = 0;

        for(int i=0; i<s.length(); i++){
            if(!dp[i])  continue;

            // jump
            // farthest까진 체크가 되어있으므로 그 이후부터 체크를 한다.
            for(int j=Math.max(i+minJump, farthest); j<=Math.min(i+maxJump, s.length()-1); j++){
                if(s.charAt(j) == '0')  dp[j] = true;
            }
            farthest = Math.min(i+maxJump, s.length()-1);
        }

        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        //String s = "01101110";
        String s = "0000000000";
        int minJump = 2, maxJump = 5;
        boolean res = new Solution().canReach(s, minJump, maxJump);
        System.out.println(res);
    }
}
