import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
// 적록색약
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 배열 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = n;
		char[][] picture = new char[n][m];
		int[][] vis = new int[n][m];
		Queue<Pair> queue = new ArrayDeque<>(); 
		// 방향 지정
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		
		
		// 초기 배열 입력
		// 1이 색칠된 부분, 움직일 수 있는 공간
		// 0이 색칠이 안된 부분, 움직일 수 없는 공간
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				picture[i][j]= str.charAt(j);
			}
		}
		
		//그림의 수
		int count = 0;
		// 그림의 길이
		int maxLength = 0; 
		
		
		for(int k = 0 ; k<3 ; k++) {
			char[] color= {'R','G','B'};
			for(int i = 0 ;i<n;i++) {
				for(int j=0;j<m;j++) {
					// 방문한 적이 있거나 칠해지지 않았다면				
					if(vis[i][j]==1 || picture[i][j]!=color[k]) {
						continue;
					}
					//그림의 수 증가
					count++;
					// 큐 비우기
					queue.clear();
					//초기 위치
					vis[i][j]=1;
					//현재 이어져있는 그림의 길이를 담을 변수
					int curLength=0;
					queue.add(new Pair(i,j));
					//위치 순회
					while(!queue.isEmpty()) {
						//그림 길이 증가
						curLength++;
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
							if(vis[nx][ny]==1||picture[nx][ny]!=color[k]) {
								continue;
							}
							//방문 표시
							vis[nx][ny]=1;
							//해당 위치 queue에 넣어줌
							queue.add(new Pair(nx,ny));
						}
					}
					
					maxLength=Math.max(maxLength, curLength);
				}
			}
		}
		bw.write(count+" ");
		
		count = 0;
		vis = new int[n][m];
		
		for(int k = 0; k<2; k++) {
			char[] color= {'R','B'};
			for(int i = 0; i<n; i++) {
				for(int j=0; j<m; j++) {
					// 방문한 적이 있거나 칠해지지 않았다면
					if(color[k]=='R') {
						if(vis[i][j]==1 || picture[i][j]== 'B') {
							continue;
						}
					} else {
						if(vis[i][j]==1 || picture[i][j]!=color[k]) {
							continue;
						}
					}
					//그림의 수 증가
					count++;
					
					// 큐 비우기
					queue.clear();
					//초기 위치
					vis[i][j]=1;
					//현재 이어져있는 그림의 길이를 담을 변수
					int curLength=0;
					queue.add(new Pair(i,j));
					//위치 순회
					while(!queue.isEmpty()) {
						//그림 길이 증가
						curLength++;
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
							if(color[k]=='R') {
								if(vis[nx][ny]==1||picture[nx][ny]=='B' ) {
									continue;
								}
							} else {
								if(vis[nx][ny]==1||picture[nx][ny]!=color[k]) {
									continue;
								}
							}
							
							
							

							//방문 표시
							vis[nx][ny]=1;
							//해당 위치 queue에 넣어줌
							queue.add(new Pair(nx,ny));
						}
					}
					
					maxLength=Math.max(maxLength, curLength);
				}
			}
		}
		bw.write(count+" ");
		
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
