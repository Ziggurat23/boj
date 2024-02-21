import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//큐
public class Main {
	 public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        int N = Integer.parseInt(br.readLine());
	        Queue<Integer> queue = new LinkedList<Integer>();

	        
	        for(int i=0; i<N;i++) {
	        	String str = br.readLine();
	        	
	        	
	            // "push"로 시작하는 경우의 처리
	            if (str.length() >= 4 && str.substring(0, 4).equals("push")) {
	                String valueStr = str.substring(5,str.length()); 
	                int value = Integer.parseInt(valueStr.trim()); 
	                queue.offer(value);
	            } else {
	            // 그 외 경우	
	            	switch (str) {
	            	
					case "pop":
						if(queue.isEmpty()) {
							System.out.println(-1);
						} else {
							System.out.println(queue.poll());
						}
						break;
					case "size":
						System.out.println(queue.size());
						break;
					case "empty":
						if(queue.isEmpty()) {
							System.out.println(1);
						} else {
							System.out.println(0);
						}
						break;
					case "front":
						if(queue.isEmpty()) {
							System.out.println(-1);
						} else {
							System.out.println(queue.peek());
						}
						break;
					case "back":
						if(queue.isEmpty()) {
							System.out.println(-1);
						} else {
							//맨 끝 요소를 확인하기 위해서 Queue를 연결리스트로 선언하고 필요할때마다 형변환
							int lastElement = ((LinkedList<Integer>) queue).peekLast();
							System.out.println(lastElement);
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
