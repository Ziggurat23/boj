import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
//좋은 단어
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //첫번째 줄 입력
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        
        for(int i=0;i<N;i++) {
        	String str = br.readLine();
            Stack<Character> stack = new Stack<>();
        	//문자 하나씩 넣기
        	for(char ch:str.toCharArray()) {
        		
        		if(!stack.isEmpty() && stack.peek()==ch) {
        			stack.pop();
        		} else {
        			stack.push(ch);
        		}
        	}
        	
        	if(stack.isEmpty()) {
        		sum++;
        	}
        	
        	
        }
        bw.write(sum+ "\n");
    	//자원반납
    	bw.flush();
    	bw.close();
    	br.close();

	}
}
