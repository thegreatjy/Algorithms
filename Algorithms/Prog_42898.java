package Algorithms;

public class Prog_42898 {
	static int n, m;
	
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map=new int[n+1][m+1];

        //물 표시 
        for(int i=0;i<(puddles.length);i++) {
        	map[puddles[i][1]][puddles[i][0]]=-1;
        }
        map[1][1]=1;
       
        for(int i=1;i<=n;i++) {
        	for(int j=1;j<=m;j++) {
        		//if(j==1 && j==1)	continue;
        		if(map[i][j]==-1) {
        			map[i][j]=0;
        			continue;
        		}
        		if(i!=1) {//맨 윗줄이 아니라면 
        			map[i][j]+=map[i-1][j]%1000000007;
        		}
        		if(j!=1) {
        			map[i][j]+=map[i][j-1]%1000000007;
        		}
        	}
        }
        return map[n][m]%1000000007;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=4;
		int n=3;
		int[][] p= {{2,2}
		};
		
		int result=solution(m, n, p);
		System.out.println(result);
	}

}
