package Bj_2578;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판
        String line;
        String[] nums;
        int[][] map = new int[5][5];
        char c;
        for(int i=0; i<5; i++){
            nums = br.readLine().split(" ");
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(nums[j]);
            }
        }

        // 사회자 호명 순서
        int[][] order = new int[5][5];
        for(int i=0; i<5; i++){
            nums = br.readLine().split(" ");
            for(int j=0; j<5; j++){
                order[i][j] = Integer.parseInt(nums[j]);
            }
        }

        // 빙고 x 처리
        int result = 0;
        for(int i=0; i<5; i++){
            if(result != 0)    break;
            for(int j=0; j<5; j++){
                visit(map, order[i][j]);
                if(func(map)){
                    result = 5*i + j + 1;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    // 빙고판 map에서 num을 지운다.
    public static void visit(int[][] map, int num){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(num != map[i][j])    continue;

                map[i][j] = -1;
                break;
            }
        }
    }

    // 빙고판 map에서 빙고를 찾는다.
    public static boolean func(int[][] map){
        boolean result = false;

        int row = 0, col = 0, down = 0, up = 0, bingo = 0;

        for(int i=0; i<5; i++){
            row = 0;
            col = 0;
            for(int j=0; j<5; j++){
                // 가로 빙고
                row = row + map[i][j];
                // 세로 빙고
                col = col + map[j][i];
                // 오른쪽 아래 대각선
                if(i == j){
                    down = down + map[i][j];
                }
                // 오른쪽 위 대각선
                if(i + j == 4){
                    up = up + map[i][j];
                }

            }

            if(row == -5){
                ++bingo;
            }
            if(col == -5){
                ++bingo;
            }
            if(down == -5){
                ++bingo;
            }
            if(up == -5){
                ++bingo;
            }

            if(bingo >= 3){
                result = true;
                break;
            }
        }

        return result;
    }
}
