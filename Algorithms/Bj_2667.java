package Algorithms;

import java.util.*;

public class Bj_2667 {
	static int N;
	static int map[][];
	static boolean visit[][];
	static ArrayList<Integer> mem;
	static int conn[][]= {{0,-1}, {0, 1}, {-1, 0}, {1, 0}};
	static int cnt=0;
	
	
	public static int search(int r, int c ) {
		if(map[r][c]==1 && !visit[r][c]) {
			//방문
			visit[r][c]=true;
			cnt++;
			//상하좌우 탐색
			for(int i=0;i<4;i++) {
				int newr=r+conn[i][0];
				int newc=c+conn[i][1];
				if(newr>=0 && newr<N && newc>=0 && newc<N) {
					search(newr, newc);
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			String str=scan.next();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}

		visit=new boolean[N][N];
		mem=new ArrayList<Integer>();
		cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				cnt=0;
				int temp=search(i,j);
				if(temp!=0) {
					mem.add(temp);
				}
			}
		}
        
        Collections.sort(mem);
		System.out.println(mem.size());
		for(int c:mem) System.out.println(c);

	}


}
