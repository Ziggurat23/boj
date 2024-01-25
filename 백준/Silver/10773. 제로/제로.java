import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
//제로
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> stack = new ArrayDeque<>();
        int K= Integer.parseInt(br.readLine());
        int sum=0;
        for(int i=0; i<K; i++) {
        	int order=Integer.parseInt(br.readLine());
        	if(order==0) {
        		stack.pop();
        	} else {
        		stack.push(order);
        	}
        }
        for(int a:stack) {
        	sum+=a;
        }
        bw.write(String.valueOf(sum));
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}

}
