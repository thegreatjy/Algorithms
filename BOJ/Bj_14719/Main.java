package Bj_14719;

import java.util.*;
import java.io.*;

public class Main {
	static int H, W;
	static int[] blocks;
	static int[] map;
	static int ret, left, right;

	/*
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		blocks = new int[W];
		blocks[0] = Integer.parseInt(st.nextToken());
		
		int last = blocks[0], lastIdx = 0;
		int sum = 0, result = 0;	//sum : 웅덩이 부피
		boolean state = true;//false:하락 , true:상승
		for(int i=0;i<W;i++) {
			blocks[i] = Integer.parseInt(st.nextToken());

		}
		for(int i=1;i<W;i++) {
			//blocks[i] = Integer.parseInt(st.nextToken());
			//상승 
			if(last<blocks[i]) {
				sum += blocks[i];
				state = true;
			}else if(last>blocks[i]){	//하락 
				//상승세였다가 지금 하락 시작
				if(state) {
					if(i<=1) {
						sum += blocks[i];
						last = blocks[i];
						state = false;
						System.out.println("sum "+sum+" result "+result);
						continue;
					}
					int height = Math.min(blocks[lastIdx], last);
					sum = sum - last;
					sum = (i-lastIdx-2)*height - sum;
					result += sum;
					sum = blocks[i];
					lastIdx = i-1;
				}else {
					sum += blocks[i];
				}
				state = false;
			}else {
				sum += blocks[i];
			}
			last = blocks[i];
			System.out.println("sum "+sum+" result "+result);
		}
		System.out.println("sum "+sum+" result "+result);
		if(sum>0) {
			
			int i = blocks.length;
			int height = Math.min(blocks[lastIdx], last);
			sum = sum - last;
			sum = (i-lastIdx-2)*height - sum;
			result += sum;
			
		}
		
		System.out.println(result);
	}
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		map = new int[W];
		ret = left = right = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int N = Integer.parseInt(st.nextToken());
			map[i] = N;
		}

		// 인덱스마다 모이는 빗물 계산 ( 1번째 기둥과 마지막 기둥의 위치는 제외 )
		for (int i = 1; i < W - 1; i++) {
			left = right = 0;
			// 왼쪽에서 가장 높은 건물의 높이
			for (int j = 0; j < i; j++) {
				left = Math.max(map[j], left);
			}
			// 오른쪽에서 가장 높은 건물의 높이
			for (int j = i + 1; j < W; j++) {
				right = Math.max(map[j], right);
			}
            // 더 낮은 건물을 기준으로 현재 인덱스에 모이는 빗물
			if (map[i] < left && map[i] < right) {
				ret += Math.min(left, right) - map[i];
			}
		}
		System.out.println(ret);
	}
}
