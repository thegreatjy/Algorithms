package Bj_2559;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0, K = 0;

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        int temp = 0;
        int[] sum = new int[N];  // 누적합 배열
        for(int i=0; i<N; i++){
            temp = Integer.parseInt(line[i]);
            if(i == 0) {
                sum[i] = temp;
                continue;
            }
            sum[i] = sum[i-1] + temp;
        }

        int result = sum[K-1];
        for(int i=K; i<N; i++){
            // temperature[i-K+1] ~ temperature[i]의 합
            result = Math.max(result, sum[i] - sum[i-K]);
        }

        System.out.println(result);
    }
}