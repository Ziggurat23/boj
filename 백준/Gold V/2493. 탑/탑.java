
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
//탑
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0 ; i < N ; i++ ) {
        	int height = Integer.parseInt(st.nextToken());
        	
        	
        	while(!stack.isEmpty() && stack.peek()[1]<height) {
        		stack.pop();
        	}
        	if(stack.empty()) {
        		bw.write(0+" ");
        	} else {
        		bw.write(stack.peek()[0]+" ");
        	}
        	
        	stack.push(new int[] {i+1,height});
        	
        	
        }
        
        //자원 반납
        bw.flush();
        bw.close();
        br.close();
	}

}
