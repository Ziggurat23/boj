import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
//오큰수
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] arr = new int[N];


        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[1] < height) {
                
                arr[stack.peek()[0]]=height;
                stack.pop();
            }
            
            if(stack.isEmpty()) {
            	arr[i]=-1;
            } 
            	
            
            stack.push(new int[] {i,height});
        }
        // 스택 마무리
        while (!stack.isEmpty()) {
            arr[stack.pop()[0]] = -1;
        }
        
        //출력
        for(int a : arr) {
        	bw.write(a+ " ");
        }
        
        //자원 반납
        bw.flush();
        bw.close();
        br.close();
	}

}
