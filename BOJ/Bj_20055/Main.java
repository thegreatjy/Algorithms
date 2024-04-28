package Bj_20055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static boolean status = true;

    public static void rotate(int[] arr){
        // 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
        int n = arr.length;

        int temp = arr[n-1];
        for(int i=n-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    public static void moveRobot(int[] durability, int[] robots){
        // 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
        // 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.

        for(int i=robots.length-2; i>=0; i--){
            if(robots[i] == 0) continue;

            int next = (i+1);
            if(robots[next] == 1 || durability[next] <= 0)   continue;

            // 로봇 이동
            robots[next] = 1;
            robots[i] = 0;
            // 내구도
            --durability[next];
        }
    }

    public static void checkDurability(int[] durability){
        // 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
        int cnt = 0;
        for(int d: durability){
            if(d == 0)      ++cnt;
            if(cnt >= k)    break;
        }

        if(cnt >= k){
            status = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] durability = new int[2*n];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()){
            durability[i++] = Integer.parseInt(st.nextToken());
        }

        int[] robots = new int[n];
        int stage = 0;
        checkDurability(durability);
        while(status) {
            ++stage;

            // 1
            rotate(durability);
            rotate(robots);
            robots[0] = 0;
            robots[n-1] = 0;    // 내리는 위치에 있는 로봇을 내림
            // 2
            moveRobot(durability, robots);
            // 3
            // 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (durability[0] > 0) {
                robots[0] = 1;
                --durability[0];
            }
            // 4
            checkDurability(durability);
        }

        System.out.print(stage);
    }
}
