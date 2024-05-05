package Bj_15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Node {
        int r;
        int c;

        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int minSumOfChDistance = Integer.MAX_VALUE;
    static List<Node> house;
    static List<Node> chicken;

    public static void dfs(int current, List<Integer> leftChicken){
        // 종료 -> 도시 치킨 거리 값 구함
        if(leftChicken.size() >= M){
            calculate(leftChicken);
            return;
        }

        for(int i=current; i<chicken.size(); i++){
            // 현재 위치의 치킨집 폐업 X
            leftChicken.add(i);
            dfs(i + 1, leftChicken);
            leftChicken.remove(leftChicken.size() - 1);
            // 현재 위치의 치킨집 폐업 O 하여 반복문 continue
        }
    }

    // 도시 치킨 거리 구하기
    public static void calculate(List<Integer> leftChicken){
        int sum = 0, min = Integer.MAX_VALUE;

        // 각 집마다의 치킨 거리를 구하여 누적합 sum을 구한다.
        int chD = 0;
        Node chNode, hNode;
        for(int i=0; i<house.size(); i++){
            hNode = house.get(i);
            min = Integer.MAX_VALUE;
            for(Integer l: leftChicken){
                chNode = chicken.get(l);
                chD = Math.abs(hNode.r - chNode.r) + Math.abs(hNode.c - chNode.c);
                min = Math.min(min, chD);
            }
            sum += min;
        }

        minSumOfChDistance = Math.min(sum, minSumOfChDistance);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        int[][] map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        // 도시 map을 돌면서 치킨집, 집 목록 저장하기
        for(int i=0; i<N; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(line[j]);
                if(map[i][j] == 1){
                    house.add(new Node(i, j));
                }else if(map[i][j] == 2){
                    chicken.add(new Node(i, j));
                }
            }
        }

        List<Integer> leftChicken = new ArrayList<>();  // 폐업하지 않고 남아있는 치킨집 번호 리스트

        // 치킨집 조합
        dfs(0, leftChicken);
        System.out.print(minSumOfChDistance);
    }
}
