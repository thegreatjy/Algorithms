package Bj_11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] sums = new int[n + 1];
        sums[0] = 0;
        sums[1] = nums[0];
        for(int i=2; i<=n; i++){
            sums[i] = sums[i-1] + nums[i - 1];
        }

        int i, j;
        for(int a=0; a<m; a++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            sb.append(sums[j] - sums[i - 1]+"\n");
        }

        System.out.print(sb.toString().trim());
    }
}
