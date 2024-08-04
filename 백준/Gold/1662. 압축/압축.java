import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
 
 
public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    
    public static void main(String[] args) throws IOException{
        char[] arr = br.readLine().toCharArray();
        
        Stack<Integer> unitSt = new Stack<>();
        unitSt.push(1);
        int res = 0;
        
        for (int i=0; i<arr.length; i++) {
            if(arr[i]=='(') {
                res-=unitSt.peek();
                unitSt.push(unitSt.peek()*(arr[i-1]-'0'));
            }
            else if(arr[i]==')') {
                unitSt.pop();
            }
            else {
                res+=unitSt.peek();
            }
        }
        
        System.out.println(res);
            }
 
    private static int stoi(String input) {
        return Integer.parseInt(input);
    }
}
