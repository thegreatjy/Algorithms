package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Bj_1655_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());
		//max 우선순위 큐 + min 우선순위 
		PriorityQueue<Integer> maxPQ=new PriorityQueue<>( (o1, o2) -> o2 - o1 );
		PriorityQueue<Integer> minPQ=new PriorityQueue<Integer>();

		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			int v=Integer.parseInt(br.readLine());
			
			//max, min 큐에 든 숫자의 개수를 동등하게 조절
			if(i%2==0) {
				maxPQ.add(v);
			}else {
				minPQ.add(v);
			}
			//두 큐에 1개 이상의 숫자가 들어있을 때
			//최대큐에서 값과 최소큐에서 값을 비교하여 교체한다
			if(!maxPQ.isEmpty() && !minPQ.isEmpty() && maxPQ.peek()>minPQ.peek()) {
				minPQ.add(maxPQ.poll());
				maxPQ.add(minPQ.poll());
			}
			
			//숫자가 입력될 때마다 중간값을 출력
			sb.append(maxPQ.peek()+"\n");
		}
		System.out.println(sb);
	}

}