import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
//도키도키 간식드리미
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> botStack = new ArrayDeque<>();
        Deque<Integer> rightStack = new ArrayDeque<>();
        
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	rightStack.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=1;i<=N;i++) {


        	if(!botStack.isEmpty() && botStack.peek()==i) {
        		botStack.pop();
        	} else if(!rightStack.isEmpty()) {
        			int tmp=rightStack.size();
        			for(int j=0;j<tmp;j++) {
        				if(rightStack.peek()==i) {
        					rightStack.pop();
        					break;
        				} else {
        					botStack.push(rightStack.pop());
        				}
        			}
        	}

             
        }
        
       
        //출력
        if(botStack.isEmpty() && rightStack.isEmpty()) {
        	System.out.println("Nice");
        } else {
        	System.out.println("Sad");
        }
        
  
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}

}
