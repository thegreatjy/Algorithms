package Bj_1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] A;
	static boolean[][] visit;
	static List list;
	static int R, C, max;
	//사방위 
	static int[] row= {-1, 0, 1, 0};
	static int[] col= {0, 1, 0, -1};
		
	public static void func(int r, int c, List<Integer> listt) {
		if(!listt.contains(A[r][c])) {
			listt.add(A[r][c]);

			if(listt.size()>max) {
				max=listt.size();
			}
			for(int i=0;i<4;i++) {
				int nr=r+row[i];
				int nc=c+col[i];
				if(nr>=0 && nr<R && nc>=0 && nc<C) {
					func(nr, nc, listt);
				}
			}
			listt.remove(listt.size()-1);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		A=new int[R][C];
		visit=new boolean[R+1][C+1];
		for(int i=0;i<R;i++) {
			String line=br.readLine();
			for(int j=0;j<C;j++) {
				A[i][j]=line.charAt(j)-'A';
			}
		}

		list=new ArrayList<Integer>();
		func(0, 0, list);
		System.out.println(max);
	}

}