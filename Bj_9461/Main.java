package Bj_9461;

import java.util.*;

public class Main {
	static ArrayList<Long> Pdv=new ArrayList<>(Arrays.asList(0L, 1L, 1L, 1L));
	
	//Pdv에서 i번째 값을 리턴한다. 없으면 계산
	public static long search_Pdv(int i) {
		
		if(i>=Pdv.size()) {
			for(int a=Pdv.size(); a<=i; a++) {
				long temp=Pdv.get(a-2)+Pdv.get(a-3);
				Pdv.add(temp);
			}
		}
		return Pdv.get(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		int arr[]=new int[T];
		StringBuilder sb=new StringBuilder();
		
		for(int i=0; i<T; i++) {
			arr[i]=scan.nextInt();
			sb.append(search_Pdv(arr[i])+"\n");
		}
		System.out.print(sb.toString().trim());
	}

}
