import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
//스택
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            
            // "push"로 시작하는 경우의 처리
            if (str.length() >= 4 && str.substring(0, 4).equals("push")) {
                String valueStr = str.substring(5); 
                int value = Integer.parseInt(valueStr.trim()); 
                stack.push(value);
            } else {
            // 그 외 경우	
            	switch (str) {
            	
				case "pop":
					if(stack.empty()) {
						System.out.println(-1);
					} else {
						System.out.println(stack.pop());
					}
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					if(stack.empty()) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					break;
				case "top":
					if(stack.empty()) {
						System.out.println(-1);
					} else {
						System.out.println(stack.peek());
					}

					break;
				default:
					break;
				}
                
                
            }
        }

        
        //자원반납
        bw.flush();
        bw.close();
        br.close();


	}

}
