package Bj_17413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String str=bf.readLine();
		StringBuilder in=new StringBuilder(str);
		
		char ch;
		int s=0; int f=0;
		boolean word=true;//true이면 단어, false이면 tag
		
		for(int i=0; i<in.length(); i++) {
			ch=in.charAt(i);
			if(word && ch=='<') {
				word=false;
				f=i;
				if(s>=0 && s<in.length() && f>=0 && f<in.length()) {
					str=in.substring(s, f);
					StringBuilder sb=new StringBuilder(str);
					sb=sb.reverse();
					in.replace(s, f, sb.toString());
				}
			}
			if(word && ch==' ') {
				f=i;
				if(s>=0 && s<in.length() && f>=0 && f<in.length()) {
					str=in.substring(s, f);
					StringBuilder sb=new StringBuilder(str);
					sb=sb.reverse();
					in.replace(s, f, sb.toString());
					s=i+1;
				}
			}
			if(!word && ch=='>') {
				word=true;
				s=i+1;
			}
			if(word && i==in.length()-1) {//마지막 단어
				f=i;
				if(s>=0 && s<in.length() && f>=0 && f<in.length()) {
					str=in.substring(s, f+1);
					StringBuilder sb=new StringBuilder(str);
					sb=sb.reverse();
					in.replace(s, f+1, sb.toString());
				}
			}
		}
		
		System.out.print(in.toString());
	}

}
