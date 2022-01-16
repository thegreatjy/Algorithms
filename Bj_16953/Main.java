package Bj_16953;

import java.util.*;

public class Main {
	static long A, B, result;
	
	static void func(long i, int cnt) {
		if(i==B) {
			result= cnt+1;
			return ;
		}
		if(i>B)	 return;
		
		func(i*2, cnt+1);
		func(i*10+1, cnt+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		A=scan.nextInt();
		B=scan.nextInt();
		result=-1;
		func(A, 0);
		System.out.println(result);
	}

}
