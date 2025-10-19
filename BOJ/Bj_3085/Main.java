package Bj_3085;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y
    static int N = 0;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int r=0; r<N; r++) {
            String line = br.readLine();
            map[r] = line.toCharArray();
        }

        int maxR = 1;
        for(int r=0; r<N; r++){
            maxR = Math.max(maxR, countMax(map));

            for(int c=0; c<N-1; c++){
                if(map[r][c] != map[r][c+1]){
                    char temp = map[r][c];
                    map[r][c] = map[r][c+1];
                    map[r][c+1] = temp;

                    maxR = Math.max(maxR, countMax(map));

                    map[r][c+1] = map[r][c];
                    map[r][c] = temp;
                }
            }
        }

        int maxC = 1;
        for(int c=0; c<N; c++){
            maxC = Math.max(maxC, countMax(map));

            for(int r=0; r<N-1; r++){
                if(map[r][c] != map[r+1][c]){
                    char temp = map[r][c];
                    map[r][c] = map[r+1][c];
                    map[r+1][c] = temp;

                    maxC = Math.max(maxC, countMax(map));

                    map[r+1][c] = map[r][c];
                    map[r][c] = temp;
                }
            }
        }

        System.out.println(Math.max(maxR, maxC));
    }

    public static int countMax(char[][] map){
        int max = 1;

        // 가로 계산
        int maxH = 1;
        for(int r=0; r<map.length; r++){
            maxH = 1;
            for(int c=0; c<map[r].length-1; c++){
                if(map[r][c] == map[r][c+1]){
                    ++maxH;
                    max = Math.max(max, maxH);
                } else{
                    maxH = 1;
                }
            }
        }

        // 세로 계산
        int maxV = 1;
        for(int c=0; c<map[0].length; c++){
            maxV = 1;
            for(int r=0; r<map.length-1; r++){
                if(map[r][c] == map[r+1][c]){
                    ++maxV;
                    max = Math.max(max, maxV);
                } else{
                    maxV = 1;
                }
            }
        }

        return max;
    }
}
