package prg_12980;

// 5;48-6;21 참고

import java.util.*;

public class Solution {
    static int num=0, batteryMin = Integer.MAX_VALUE;

    public int solution(int n) {
        int ans = 0;

        while(n>0){
            if(n%2 == 1){
                // 점프
                ans++;
                n--;
            }else{
                // 2칸 순간이동
                n = n/2;
            }
        }

        return ans;
    }

}