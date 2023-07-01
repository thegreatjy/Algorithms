package bj_16236;

import java.io.*;
import java.util.*;

public class Main {
	public static class node{
		int r, c;
		int dist;
		node(int r, int c, int dist){
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	//현재 상어의 위치에서 가장 가까운 물고기 좌표와 거리를 리턴한다
	public static int[] bfs(int sharkR, int sharkC, int size, int[][] maps, int N) {
		int[] fish = {-1, -1, -1};
		int[] rows = {-1, 0, 0, 1};
		int[] cols = {0, -1, 1, 0};
		Queue<node> q = new LinkedList<>();
		q.add(new node(sharkR, sharkC, 0));
		
		node nd;
		int newR = 0, newC = 0;
		int[][] dist = new int[N][N];
		int closestR = -1, closestC = -1, closestDist = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			nd = q.poll();
			for(int i=0;i<4;i++) {
				newR = nd.r + rows[i];
				newC = nd.c + cols[i];
				if(newR<0 || newR>=N || newC<0 || newC>=N || dist[newR][newC] != 0) {
					continue;
				}
				
				if(maps[newR][newC] == 0 || maps[newR][newC] == size) {
					//지나갈 수만 있다
					dist[newR][newC] = nd.dist + 1;
					q.add(new node(newR, newC, dist[newR][newC]));
				}else if(0<maps[newR][newC] && maps[newR][newC]<size) {
					//물고기를 먹을 수 있다.
					dist[newR][newC] = nd.dist + 1;
					q.add(new node(newR, newC, dist[newR][newC]));
					
					//가장 가까운 물고기인지 확인
					if(dist[newR][newC] < closestDist) {
						closestDist = dist[newR][newC];
						closestR = newR;
						closestC = newC;
					}else if(dist[newR][newC] == closestDist) {
						if(newR < closestR) {
							closestR = newR;
							closestC = newC;
						}else if(newR == closestR) {
							if(newC < closestC) {
								closestC = newC;
							}
						}
					}
				}else {
					//상어 크기보다 물고기 크기가 더 크다
					dist[newR][newC] = -1;
				}
			}
		}
		
		fish[0] = closestR;
		fish[1] = closestC;
		fish[2] = closestDist;
		
		return fish;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int secs = 0;
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] lines;
		int[][] maps = new int[N][N];
		//상어 크기, 위치
		int size = 2, sharkR = 0, sharkC = 0;
		//fish 개수
		int numOfFish = 0;
		for(int i=0;i<N;i++) {
			lines = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				maps[i][j] = Integer.parseInt(lines[j]);
				if(maps[i][j] == 9) {
					sharkR = i;
					sharkC = j;
					maps[i][j] = 0;
				}else if(maps[i][j] != 0) {
					numOfFish++;
				}
			}
		}
		
		//calculate
		int[] closestFish = new int[3];
		int fishR = 0, fishC = 0;
		int eatenFish = 0;
		while(numOfFish>0) {
			//현재 상어의 위치에서 가장 가까운 물고기의 좌표를 구한다
			closestFish = bfs(sharkR, sharkC, size, maps, N);
			//먹을 수 있는 물고기가 없다
			if(closestFish[0]==-1)	break;
			fishR = closestFish[0];
			fishC = closestFish[1];
			//물고기를 먹는다
			maps[fishR][fishC] = 0;
			eatenFish++;
			numOfFish--;
			//상어 이동
			sharkR = fishR;
			sharkC = fishC;
			//거리 이동 시간
			secs += closestFish[2];
			//상어 크기 증가
			if(eatenFish == size) {
				size++;
				eatenFish = 0;
			}
		}
		
		System.out.println(secs);
	}
}