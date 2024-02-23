import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;



//회전하는 큐
public class Main {
	 public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        Deque<Integer> deque = new ArrayDeque<>();
	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        //초기 덱
	        for(int i=1; i<=N; i++) {
	            deque.addLast(i);
	        }
	        
	        
	        StringTokenizer st2 = new StringTokenizer(br.readLine());
	        int [] arr = new int[M];
	        int totalMoves = 0;
	        //타겟 값
	        for(int i=0;i<M;i++) {
	        	arr[i]=Integer.parseInt(st2.nextToken());
	        }
	        
			
			  for(int target : arr) { 
				  int index = findIndex(deque, target);
				  int rightMoves = index;
				  int leftMoves = deque.size() - index;
				  int min = Math.min(rightMoves,leftMoves); 
				  totalMoves += min; 
				  for(int i=0;i<min;i++) {
					if (min == rightMoves) {
						deque.addLast(deque.pollFirst());
					} else {
						deque.addFirst(deque.pollLast());
					}
				  }
				  // 뽑아내기
				  deque.removeFirst(); 
			  }
			
	        bw.write(totalMoves+"\n");
	        //자원반납
	        bw.flush();
	        bw.close();
	        br.close();
	    }
	 
	    // 순회하며 큐에서 원소의 인덱스 찾기 (0부터 시작)
	    private static int findIndex(Deque<Integer> deque, int target) {
	        int index = 0;
	        for (int item : deque) {
	            if (item == target) {
	                return index;
	            }
	            index++;
	        }
	        // 원소가 없는 경우
	        return -1; 
	    }
}
