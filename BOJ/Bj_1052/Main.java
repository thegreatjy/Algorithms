package Bj_1052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int result = 0;
        // n을 2진수로 변환하여 1의 개수를 센다.
        while(Integer.bitCount(n) > k){
            ++n;
            ++result;
        }

        System.out.print(result);

        /*
        while (Integer.bitCount(n) > k) {
            ans += n & (-n);
            n += n & (-n);
        }
         */
    }
}
