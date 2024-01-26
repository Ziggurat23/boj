import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//queuestack
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new LinkedList<>();
        //자료구조 크기
        int N = Integer.parseInt(br.readLine());
        boolean[] listOfDS = new boolean[N];
        int[] listOfElement = new int[N];
        //자료구조 수열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	if(Integer.parseInt(st.nextToken())==0) {
        		listOfDS[i]=true;
        	};
        }
        //원소 수열
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	if(listOfDS[i]) {
        		queue.add(Integer.parseInt(st2.nextToken()));
        	} else {
        		st2.nextToken();
        	}
        }
        //삽입 수열 크기
        int M = Integer.parseInt(br.readLine());
        //자료구조 수열
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
        	int element=Integer.parseInt(st3.nextToken());
        	//값 찾기
            queue.addFirst(element);
            bw.write(queue.pollLast() + " "); 
        }
        
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}

}
