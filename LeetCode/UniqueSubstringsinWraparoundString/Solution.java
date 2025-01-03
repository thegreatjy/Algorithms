package UniqueSubstringsinWraparoundString;

class Solution {
    public int findSubstringInWraproundString(String s) {
        // dp[i]: i번째 알파벳으로 끝나는 문자열 중 알파벳 순으로 연속된 문자열의 개수
        int[] dp = new int[26];

        int continuous = 0, diff = 0, tempIdx;
        for(int i=0; i<s.length(); i++){
            if(i == 0){
                continuous = 1;
            }else{
                diff = s.charAt(i) - s.charAt(i-1);

                if(diff == 1 || diff == -25){ // 순환됨
                    ++continuous;
                }else {
                    continuous = 1;
                }
            }

            tempIdx = s.charAt(i) - 'a';
            dp[tempIdx] = Math.max(dp[tempIdx], continuous);
        }

        int result = 0;
        for(int d: dp){
            result += d;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cab";
        int result = new Solution().findSubstringInWraproundString(s);
        System.out.println(result); // 4
    }
}