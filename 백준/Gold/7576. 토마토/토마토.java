import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//토마토
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 배열 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		// 미로 배열
		int[][] board= new int[n][m];
		// 거리 배열
		int[][] dist = new int[n][m];
		Queue<Pair> queue = new ArrayDeque<>(); 
		// 방향 지정
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		
		
		// 초기 배열 입력
		// 1이 초기 위치
		// 0이 움직일 수 있는 공간
		// -1이 움직일 수 없는 공간
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				//시작 위치일 경우 1
				//초기 위치
				if(board[i][j]==1) {
					queue.add(new Pair(i,j));
				} else if(board[i][j] == 0) {
					dist[i][j] = -1;
				}
				
			}
		}


		//위치 순회
		while(!queue.isEmpty()) {
			// 현재위치 X Y 위치
			Pair cur = queue.poll();
			// 4방향 체크
			for(int dir=0;dir<4;dir++) {
				//현재 위치에서 x위치 변경
				int nx = cur.getX()+dx[dir];
				//현재 위치에서 y위치 변경
				int ny = cur.getY()+dy[dir];
				
				//범위 벗어나거나
				if(nx<0 || ny<0 || nx>=n || ny>=m) {
					continue;
				}
				// 방문한적이 있거나 길이 아니거나
				if(dist[nx][ny]>=0||board[nx][ny]==-1) {
					continue;
				}
				// 현재 길이에서 다음 위치에 길이 추가
				dist[nx][ny]= dist[cur.getX()][cur.getY()]+1;
				//해당 위치 queue에 넣어줌
				queue.add(new Pair(nx,ny));
			}
		}
				
		int sol = 0;
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(dist[i][j]==-1) {
					bw.write("-1");
					//자원반납
					bw.flush();
					bw.close();
					br.close();
					return;
				}
				sol = Math.max(sol, dist[i][j]);
			}
		}

		//최대 길이 출력
		bw.write(sol+"\n");
		
		//자원반납
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static class Pair{
		private int x;
		private int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
	}
} 
