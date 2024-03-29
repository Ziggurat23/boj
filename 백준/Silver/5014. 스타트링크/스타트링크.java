

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//스타트링크
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//빌딩크기
		int F = Integer.parseInt(st.nextToken());
		//강호 위치
		int S = Integer.parseInt(st.nextToken());
		//면접장
		int G = Integer.parseInt(st.nextToken());
		//윗층버튼
		int U = Integer.parseInt(st.nextToken());
		//아래층버튼
		int D = Integer.parseInt(st.nextToken());
		
		
		int[] dist= new int [F+1];
		for(int i=0;i<dist.length;i++) {
			dist[i]=-1;
		}
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		//초기 위치
		dist[S] = 0;
		queue.add(S);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();

			//다음 위치 작성
			int[] nextPositions = { cur + U , cur - D};
			for(int next : nextPositions) {
				//범위 벗어남
				if(next < 1 || next > F) {

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
		if(dist[G]==-1) {
			bw.write("use the stairs");
		} else {
			bw.write(dist[G]+"\n");
		}
		
		
		//자원반납
		bw.flush();
		bw.close();
		br.close();
	}
}
