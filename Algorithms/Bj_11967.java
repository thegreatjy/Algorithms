package Algorithms;
import java.util.*;

public class Bj_11967 {
	static int count, N;
	static boolean[][] mapSwitch;//스위치 유무
	static boolean[][] mapLight;//불 켜져있는지
	static boolean[][] visit;//방문 여부 
	static ArrayList<node>[][] switchs;//스위치
	//사방위 
	static int[] row= {-1, 0, 1, 0};
	static int[] col= {0, 1, 0, -1};
	
	public static int func(int r, int c) {
		Queue<node> q=new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			Arrays.fill(visit[i], false);
		}
		//현재 위치 r,c 방문 표기 
		visit[r][c]=true;
		q.offer(new node(r,c));
		int cnt=0;
		boolean flag=false;
		
		while(!q.isEmpty()) {
			node headNd=q.poll();
			
			//현재 위치(headNd)에서 켤 수 있는 스위치(nd)를 모두 켠다.
			for(int i=0;i<switchs[headNd.x][headNd.y].size();i++) {
				node nd=switchs[headNd.x][headNd.y].get(i);
				//불이 꺼져있으면 불을 킨다.
				if(!mapLight[nd.x][nd.y]) {
					mapLight[nd.x][nd.y]=true;
					cnt++;
					flag=true;
				}
			}
			
			for(int i=0;i<4;i++) {
				int nx=headNd.x+row[i];
				int ny=headNd.y+col[i];
				if(nx>=1&&nx<=N&&ny>=1&&ny<=N) {
					//상하좌우에서 불이 켜져있고 방문한 적이 없으면 방문
					if(mapLight[nx][ny]&&!visit[nx][ny]) {
						visit[nx][ny]=true;
						q.offer(new node(nx, ny));
					}
				}
			}
		}
		
		//스위치를 켠 적이 있으면 처음(1,1)부터 다시 계산해보기 
		if(flag) {
			cnt=cnt+func(1,1);
		}
		return cnt;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		int m=scan.nextInt();
		
		mapSwitch=new boolean[N+1][N+1];
		mapLight=new boolean[N+1][N+1];
		visit=new boolean[N+1][N+1];
		switchs=new ArrayList[N+1][N+1];
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=N;j++) {
				switchs[i][j]=new ArrayList<node>();
			}
		}
		int x,y,a,b;
		for(int i=0;i<m;i++) {
			x=scan.nextInt();y=scan.nextInt();
			a=scan.nextInt();b=scan.nextInt();
			switchs[x][y].add(new node(a,b));
		}
		mapLight[1][1]=true;
		count=1;
		System.out.println(func(1,1)+1);
	}
}

class node {
	int x;
	int y;
	
	node(int x, int y){
		this.x=x;
		this.y=y;
	}
}