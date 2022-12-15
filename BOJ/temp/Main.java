package temp;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[])throws Exception { 
	    String x = "";
	    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    String line = br.readLine();
	    
	    int bomb = 0, raz = 0;
	    for(int i=0;i<line.length();i++){
	      
	      if(line.charAt(i) == '(' ){
	        ++bomb;
	      }else if(line.charAt(i) == ')' ){
	        ++raz;
	      }
	    }

	    if(bomb == raz){
	      x = "YES";
	    }else{
	      x = "NO";
	    }

	    System.out.println(x);
	  }
}
