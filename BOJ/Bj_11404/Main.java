package Bj_11404;

import java.io.*;

public class Main {
	static int n, m;
	static int[][] map;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int a, b, c;
		String[] line = new String[3];
		for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = INF;
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }
		for(int i=0; i<m; i++) {
			line = br.readLine().split(" ");
			a = Integer.parseInt(line[0]) - 1;
			b = Integer.parseInt(line[1]) - 1;
			c = Integer.parseInt(line[2]);
			map[a][b] = Math.min(map[a][b], c);
		}
		
		for(int mid=0; mid<n; mid++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][mid]+map[mid][j] < map[i][j]) {
						map[i][j] = map[i][mid]+map[mid][j];
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if (map[i][j] == INF) {
                    map[i][j] = 0;
                }
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}

/*
package Bj_11404;

import java.io.*;

public class Main {
	static int n, m;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int a, b, c;
		String[] line = new String[3];
		for(int i=0; i<m; i++) {
			line = br.readLine().split(" ");
			a = Integer.parseInt(line[0]) - 1;
			b = Integer.parseInt(line[1]) - 1;
			c = Integer.parseInt(line[2]);
			if(map[a][b]==0)	map[a][b] = c;
			else	map[a][b] = Math.min(map[a][b], c);
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("+==+");
		for(int mid=0; mid<n; mid++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][mid]==0 || map[mid][j]==0)	continue;
					
					if(map[i][mid]+map[mid][j] < map[i][j]) {
						map[i][j] = map[i][mid]+map[mid][j];
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
*/