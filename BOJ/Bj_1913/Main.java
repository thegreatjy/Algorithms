package Bj_1913;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] rows = {1, 0, -1, 0};  // 아래, 오른쪽, 위, 왼쪽
    static int[] cols = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] result = new int[n][n];
        int r = 0, c = 0, last = n*n + 1, dir = 0, newR, newC, resultR = 0, resultC = 0;
        while(true){
            result[r][c] = last - 1;
            last = result[r][c];

            if(result[r][c] == num){  // 찾음
                resultR = r;
                resultC = c;
            }

            if(r == n/2 && c == n/2){   // 중앙
                break;
            }

            // 좌표 이동
            newR = r + rows[dir];
            newC = c + cols[dir];
            if(newR < 0 || newR >= n || newC < 0 || newC >= n || result[newR][newC] != 0) {   // 범위에서 벗어나게 되면 방향을 바꿔야 한다. 혹은 이미 방문한 적이 있으면 방향을 바꾼다.
                dir = (dir + 1) % 4;
            }
            r += rows[dir];
            c += cols[dir];
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append((resultR + 1) + " " + (resultC + 1));

        System.out.println(sb.toString());
    }
}