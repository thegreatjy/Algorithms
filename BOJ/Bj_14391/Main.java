package Bj_14391;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            line[0] =  br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line[0].charAt(j) - '0';
            }
        }

        int result = 0;
        // 0000 0000 0000 0000 ~ 1111 1111 1111 1111 (1<<(N+M))
        for(int comb=0; comb<(1<<(N*M)); comb++){
            int sum = 0;    // comb의 경우, 각 조각의 합
            int order = 1;  // 자리수

            // 가로 계산
            for(int row=0; row<N; row++){
                order = 1;
                for(int col=M-1; col>=0; col--){    // 뒤에서부터 숫자 확인
                    int idx = col + row*M;  // (row, col) -> 1차원 배열로 늘렸을 때, 위치(인덱스)

                    if((comb & (1<<idx)) > 0){  // comb의 idx 위치가 1이면, 가로로 더함
                        sum += map[row][col] * order;
                        order *= 10;
                    }else{  // 0이라면 자리수 초기화
                        order = 1;
                    }
                }
            }

            // 세로 계산
            for(int col=0; col<M; col++){
                order = 1;
                for(int row=N-1; row>=0; row--){    // 아래에서부터 숫자 확인
                    int idx = col + row*M;

                    if((comb & (1<<idx)) == 0){  // comb의 idx 위치가 0이면, 세로로 더함
                        sum += map[row][col] * order;
                        order *= 10;
                    }else{  // 1이라면 자리수 초기화
                        order = 1;
                    }
                }
            }

            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}
