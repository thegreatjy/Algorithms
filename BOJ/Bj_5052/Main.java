package Bj_5052;

import java.util.*;
import java.io.*;

public class Main {
	public static int func(String[] phone) {
		int len = phone.length;
		Arrays.sort(phone);
		for(int i=0;i<len-1;i++) {
			if(phone[i+1].startsWith(phone[i])) {
				return 0;
			}
		}
		
		return 1;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int t, n;
		String[] phone;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		
		for(int a=0;a<t;a++) {
			n = Integer.parseInt(br.readLine());
			phone = new String[n];
			for(int i=0;i<n;i++) {
				phone[i] = br.readLine();
			}
			int res = func(phone);
			
			if(res==0)		bw.write("NO\n");
			else if(res==1)		bw.write("YES\n");
		}
		
		bw.flush();
		bw.close();
	}
}
