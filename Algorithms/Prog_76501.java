package Algorithms;

import java.math.BigInteger;

public class Prog_76501 {
	
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        BigInteger sum=new BigInteger("0");
        
        for(int i=0;i<signs.length;i++) {
        	if(signs[i]) {//양수이면 
        		sum=sum.add(BigInteger.valueOf(absolutes[i]));
        	}else {//음수이면 
        		
        		sum=sum.subtract(BigInteger.valueOf(absolutes[i]));
        	}
        }
        return sum.intValue();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]abs= {1,2,3};
		boolean[] s= {false, false, true};
		
		int result=solution(abs, s);
		System.out.println(result);
	}

}
