package Bj_2512;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    static int N, budget, min, max;
    static int[] request;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        request = new int[N];
        int requestSum = 0;
        String[] line = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            request[i] = Integer.parseInt(line[i]);
            requestSum += request[i];
        }
        budget = Integer.parseInt(br.readLine());

        // 정렬
        Arrays.sort(request);
        min = 0;
        max = request[request.length - 1];

        int result = 0; // 상한액
        if(requestSum <= budget){   // 모든 요청 수용 가능
            result = max;
            System.out.println(result);
            return ;
        }

        // 상한액 result 구하기
        while (true) {
            // 종료
            if(min > max){
                break;
            }
            // 상한액
            result = (min + max) / 2;

            // 상한액을 기준으로한 요청액 총합 구하기
            long sum = 0;
            for(int r: request){
                sum += Math.min(r, result);
            }

            if(sum == budget){
                max = result;
                break;
            }else if(sum < budget){
                min = result + 1;
            }else{
                max = result - 1;
            }
        }
        result = max;

        System.out.println(result);

    }
}
