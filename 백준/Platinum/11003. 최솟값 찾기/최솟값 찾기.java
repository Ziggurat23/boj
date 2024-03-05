import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
//최솟값 찾기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //첫번째 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        //두번째 줄 입력
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(st2.nextToken());
        }
        
        for(int i=0;i<N;i++) {
        	//해당 요소보다 작으면 덱에 있는 요소들 제거
        	while(!deque.isEmpty()&&arr[deque.peekLast()]>=arr[i]){
        		deque.pollLast();
        	}
        	
        	//덱에 추가
 
        	deque.addLast(i);
        	
        	
        	//인덱스 벗어나면 제거

        	if(deque.peekFirst()<=i-L) {
        		deque.pollFirst();
        	}

        	
        	//출력

        	bw.write(arr[deque.peekFirst()]+" ");

        }
        
    	//자원반납
    	bw.flush();
    	bw.close();
    	br.close();

	}

}
