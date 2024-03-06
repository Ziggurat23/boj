import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
//쇠막대기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int sum = 0;
    	String str = br.readLine();
    	Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray();
        
        for(int i=0;i<charArr.length;i++) {
        	
    		if(!stack.isEmpty() && charArr[i] == ')') {
    			stack.pop();
    			if( charArr[i-1] == '(') {
    				sum += stack.size();
    			} else {
    				// 쇠막대기 끝쪽
    				sum++;
    			}
    		} else {
    			stack.push(charArr[i]);
    		}

        	
        }
        bw.write(sum + "\n");
    	//자원반납
    	bw.flush();
    	bw.close();
    	br.close();

	}
}
