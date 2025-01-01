package CanIWin;

/**
 * 비트마스킹 공부
 *
 * i번째 비트를 1로 만들기
 * => 비트 | (1<<i)
 * (예) 01010(2) -> 01011(2)
 * 01010 | (1<<0) = 01010 | 00001 = 01011
 *
 * i번째 비트를 0으로 만들기
 * => 비트 & !(1<<i)
 * (예) 01010(2) -> 01000(2)
 * 01010 & !(1<<1) = 01010 & !(00010) = 01010 & 11101 = 01000
 */

public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean result = false;

        if(desiredTotal > maxChoosableInteger * (maxChoosableInteger + 1) / 2){ // dt > 1부터 mCI까지의 합 -> 불가능
            return false;
        }

        Boolean[] dp = new Boolean[1<<(maxChoosableInteger+1)];

        result = func(0, dp, 0, maxChoosableInteger, desiredTotal);
        return result;
    }

    /**
     * dp[mask] 반환
     * @param mask: 현재까지 사용된 숫자 기록
     * @param dp: dp[i]: i숫자 기록일 경우, 승부 여부
     */
    public boolean func(int mask, Boolean[] dp, int sum, int maxChoosableInteger, int desiredTotal){
        if(dp[mask] != null){
            return dp[mask];
        }

        dp[mask] = false;
        for(int i=1; i<=maxChoosableInteger; i++){
            if((mask & (1<<i)) == 0){ // 숫자 i가 아직 사용되지 않았을 경우
                if(sum + i >= desiredTotal){
                    dp[mask] = true;
                }else{
                    // player2: 현재 플레이어인 player1이 i를 사용했을 때, player2의 승부 결과
                    boolean player2 = func(mask|(1<<i), dp, sum+i, maxChoosableInteger, desiredTotal);
                    if(!player2){
                        dp[mask] = true;
                    }
                }
            }

            if(dp[mask]){
                break;
            }
        }

        return dp[mask];
    }

    public static void main(String[] args) {
        int maxChoosableInteger = 10;
        int desiredTotal = 0;
        /*
        int maxChoosableInteger = 10;
        int desiredTotal = 11;
         */

        boolean result = new Solution().canIWin(maxChoosableInteger, desiredTotal);
        System.out.println(result);
    }
}
