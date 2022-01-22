package Bj_11866;

import java.util.*;

public class Main{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int k=scan.nextInt();
		
		//N명의 사람
		Queue<Integer> YQ=new LinkedList<>();
		for(int i=0;i<n;i++) {
			YQ.offer(i+1);
		}
		//결과==요세푸스 순열
		LinkedList<Integer> JL=new LinkedList<>();
		
		while(true) {
			//YQ에 남은 원소가 없으면
			//남은 사람이 없으면 종료
			if(YQ.isEmpty()) {
				break;
			}
			//제외할 사람을 구함
			for(int i=0;i<k;i++) {
				int head=YQ.poll();
				//제외할 사람
				if(i==k-1) {
					JL.add(head);
				}else{
					YQ.add(head);
				}
			}
		}
		
		System.out.print('<');
		ListIterator it=JL.listIterator();
		int cnt=1;
		while(it.hasNext()) {
			if(cnt==n) {
				System.out.print(it.next());
			}else {
				System.out.print(it.next()+", ");
			}
			cnt++;
		}
		System.out.print('>');
	}

}
