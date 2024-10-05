package Bj_14891;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] result = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[4][8];
        for(int i=0; i<4; i++){
            String line = br.readLine();
            for(int j=0; j<8; j++){
                map[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        int k = Integer.parseInt(br.readLine());
        String[] input;
        int num = 0, dir = 0;
        boolean[] visited;
        for(int i=0; i<k; i++){
            input = br.readLine().split(" ");
            num = Integer.parseInt(input[0]);
            dir = Integer.parseInt(input[1]);
            visited = new boolean[4];
            result = new int[4];

            rotate(num - 1, dir, visited, map);

            // result대로 회전하기
            realRotate(map);
        }

        // sum 구하기
        int sum = 0;
        for(int i=0; i<4; i++){
            if(map[i][0] == 1){
                sum += (int) Math.pow(2, i);
            }
        }
        System.out.println(sum);
    }

    // num 톱니바퀴를 dir로 회전한다.
    public static void rotate(int num, int dir, boolean[] visited, int[][] map){
        // num 톱니를 dir로 회전
        visited[num] = true;
        result[num] = dir;

        switch (num){
            case 0:
                // (0, 2) vs (1, 6) 확인
                if(map[num][2] != map[num+1][6] && !visited[num+1]){
                    // 다르면 회전
                    rotate(num+1, dir * -1, visited, map);
                }
                break;
            case 1:
                // (1, 6) vs (0, 2)
                if(map[num][6] != map[num-1][2] && !visited[num-1]){
                    // 다르면 회전
                    rotate(num-1, dir * -1, visited, map);
                }
                // (1, 2) vs (2, 6)
                if(map[num][2] != map[num+1][6] && !visited[num+1]){
                    // 다르면 회전
                    rotate(num+1, dir * -1, visited, map);
                }
                break;
            case 2:
                // (2, 6) vs (1, 2)
                if(map[num][6] != map[num-1][2] && !visited[num-1]){
                    // 다르면 회전
                    rotate(num-1, dir * -1, visited, map);
                }
                // (2, 2) vs (3, 6)
                if(map[num][2] != map[num+1][6] && !visited[num+1]){
                    // 다르면 회전
                    rotate(num+1, dir * -1, visited, map);
                }
                break;
            case 3:
                // (3, 6) vs (2, 2) 확인
                if(map[num][6] != map[num-1][2] && !visited[num-1]){
                    // 다르면 회전
                    rotate(num-1, dir * -1, visited, map);
                }
                break;
        }
    }

    public static void realRotate(int[][] map){
        for(int i=0; i<4; i++){
            int temp = 0;

            if(result[i] == -1){
                temp = map[i][0];
                for(int j=0; j<=6; j++){
                    map[i][j] = map[i][j+1];
                }
                map[i][7] = temp;
            }else if(result[i] == 1){
                temp = map[i][7];
                for(int j=7; j>=1; j--){
                    map[i][j] = map[i][j-1];
                }
                map[i][0] = temp;
            }
        }
    }
}
