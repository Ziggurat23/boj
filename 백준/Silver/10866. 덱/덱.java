import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

//덱
public class Main {
	 public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        int N = Integer.parseInt(br.readLine());
	        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

	        
	        for(int i=0; i<N;i++) {
	        	String str = br.readLine();
	        	
	        	
	            // "push"로 시작하는 경우의 처리
	            if (str.length() >= 10 && str.substring(0, 10).equals("push_front")) {
	                String valueStr = str.substring(11,str.length()); 
	                int value = Integer.parseInt(valueStr.trim()); 
	                deque.addFirst(value);
	            } else if(str.length() >= 9 && str.substring(0, 9).equals("push_back")) {
	                String valueStr = str.substring(10,str.length()); 
	                int value = Integer.parseInt(valueStr.trim()); 
	                deque.addLast(value);
	        	}else{
	            // 그 외 경우	
	            	switch (str) {
	            	
					case "pop_front":
						if(deque.isEmpty()) {
							System.out.println(-1);
						} else {
							System.out.println(deque.removeFirst());
						}
						break;
					case "pop_back":
						if(deque.isEmpty()) {
							System.out.println(-1);
						} else {
							System.out.println(deque.removeLast());
						}
						break;
					case "size":
						System.out.println(deque.size());
						break;
					case "empty":
						if(deque.isEmpty()) {
							System.out.println(1);
						} else {
							System.out.println(0);
						}
						break;
					case "front":
						if(deque.isEmpty()) {
							System.out.println(-1);
						} else {
							System.out.println(deque.peekFirst());
						}
						break;
					case "back":
						if(deque.isEmpty()) {
							System.out.println(-1);
						} else {
							System.out.println(deque.peekLast());
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
