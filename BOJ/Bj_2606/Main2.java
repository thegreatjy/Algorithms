package Bj_2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        String[] line;
        int n, m;
        int[] parent = new int[vertex+1];
        for(int i=0; i<=vertex; i++){
            parent[i] = i;
        }

        for(int i=0; i<edge; i++){
            line = br.readLine().split(" ");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);

            union(n, m, parent);
        }

        // find(i)해서 1 인 노드들을 카운트
        int cnt = 0;
        for(int i=1; i<=vertex; i++){
            if(i==1)    continue;
            if(find(i, parent) == find(1, parent)){
                ++cnt;
            }
        }

        System.out.println(cnt);
    }

    // n, m을 같은 조직으로 만듦
    // n <- m   (n<=m)
    public static void union(int n, int m, int[] parent){
        int parentN = find(n, parent);
        int parentM = find(m, parent);

        if(parentN != parentM){
            if(parentM >= parentN){
                parent[parentN] = parentM;
            }else{
                parent[parentM] = parentN;
            }
        }
    }

    // n의 부모를 찾음
    public static int find(int n, int[] parent){
        int current = n;
        int result = 0;

        while(true){
            result = parent[current];

            if(result == current){
                break;
            }

            current = result;
        }

        return result;
    }
}
