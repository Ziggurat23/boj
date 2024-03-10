import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//숨바꼭질
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//수빈이 위치
		int N = Integer.parseInt(st.nextToken());
		//동생 위치
		int K = Integer.parseInt(st.nextToken());
		
		
		int[] dist= new int [200000];
		for(int i=0;i<dist.length;i++) {
			dist[i]=-1;
		}
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		//초기 위치
		dist[N] = 0;
		queue.add(N);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			//다음 위치 작성
			int[] nextPositions = {cur - 1, cur + 1, 2 * cur};
			for(int next : nextPositions) {
				//범위 벗어남
				if(next < 0 || next >= 200000) {
					continue;
				}
				//이미 가본 곳, 이미 가본 곳을 방문한다면 사실상 손해이기 때문에 스킵
				if(dist[next] != -1) {
					continue;
				}
				dist[next] = dist[cur]+1;
				queue.add(next);
			}
			
		}
		// 동생 위치까지 길이  
		bw.write(dist[K]+"\n");
		
		//자원반납
		bw.flush();
		bw.close();
		br.close();
	}
}
