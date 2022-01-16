package Algorithms;

import java.math.BigInteger;
import java.util.*;

public class Bj_2407 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		
		BigInteger up=new BigInteger("1");
		BigInteger down=new BigInteger("1");
		for(int i=0; i<m; i++) {
			up=up.multiply(BigInteger.valueOf(n-i));
			down=down.multiply(BigInteger.valueOf(i+1));
		}
		up=up.divide(down);
		System.out.print(up);
	}

}
