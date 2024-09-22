package Bj_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int result = 0;

    public static void dfs(int curIdx, int sum, int[] nums, int s){
        // 종료
        if(curIdx >= nums.length){
            if(sum == s){
                ++result;
            }
            return;
        }

        // 탐색
        dfs(curIdx+1, sum + nums[curIdx], nums, s);
        dfs(curIdx+1, sum, nums, s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, s;
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        s = Integer.parseInt(line[1]);
        int[] nums = new int[n];
        line = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(line[i]);
        }

        dfs(0, 0, nums, s);

        // 원하는 합이 0이면, 수열 중 아무것도 선택 안 해서 총합이 0이 되는 경우 한번 제거
        if(s==0) result--;

        System.out.println(result);
    }
}
