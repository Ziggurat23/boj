
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
//카드2
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=1;i<=N;i++) {
        	queue.add(i);
        }

        while(queue.size() > 1) {
            queue.poll(); // 첫 번째 카드를 버립니다.
            queue.add(queue.poll()); // 다음 카드를 뒤로 옮깁니다.
        }

       System.out.println(queue.poll());

        
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}

}
