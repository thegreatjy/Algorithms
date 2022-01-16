package Bj_1644;
import java.io.*;
import java.util.*;


public class Main {

	static boolean prime[];
	static ArrayList<Integer> primes = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		int result=0;
		int s=0, l=0, sum=0;
		//ArrayList<Integer> primes=new ArrayList<Integer>();

		prime = new boolean[N+1];        
        prime[0] = prime[1] = true;       
        for(int i=2; i*i<=N; i++){
            if(!prime[i]) for(int j=i*i; j<=N; j+=i) prime[j]=true;                
        }            
        for(int i=1; i<=N;i++){
        	if(!prime[i]) primes.add(i);     
        }

		Collections.reverse(primes);
		//System.out.println(primes);
		s=primes.size()-1; l=primes.size()-1;
		int i=l;
		while(i>=0){
			sum=sum+primes.get(i);
			//System.out.println(sum);
			if(sum > N) {
				sum=sum-primes.get(l)-primes.get(i);
				if(l-1<s) {//s==l
					l=i; s=i; 
				}else {
					l=l-1;
				}
				//System.out.println("sum >N] i="+i+" s="+s+" l="+l);
			}else if(sum == N){
				result++;
				//System.out.println("sum==N] i="+i+" s="+s+" l="+l);
				sum=sum-primes.get(l);
				s=i;
				l=l-1;
				i--;
			}else {	//sum < N
				s=i;
				i--;
			}
		}
		System.out.println(result);
	}

}
