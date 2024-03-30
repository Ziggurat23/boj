

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//안전 영역
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 배열 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int[][] picture = new int[n][n];
		int[][] vis = new int[n][n];
		Queue<Pair> queue = new ArrayDeque<>(); 
		// 방향 지정
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		
		
		// 초기 배열 입력
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				picture[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//그림의 수
		int count = 0;
		//최대 숫자
		int maxCount = 0; 
		
		
		for(int h = 0 ; h <= 101 ; h++) {
			//그림의 수
			count = 0;
			vis = new int[n][n];
			for(int i = 0 ;i<n;i++) {
				for(int j=0;j<n;j++) {
					
					// 방문한 적이 있거나 물에 잠기었다면				
					if(vis[i][j]==1 || picture[i][j]<=h) {
						continue;
					}
					//안전지대 증가
					count++;
					// 큐 비우기
					queue.clear();
					//초기 위치 반문
					vis[i][j]=1;
					queue.add(new Pair(i,j));
					//위치 순회
					while(!queue.isEmpty()) {
						//그림 길이 증가
						// 현재위치 X Y 위치
						Pair cur = queue.poll();
						// 4방향 체크
						for(int dir=0;dir<4;dir++) {
							//현재 위치에서 x위치 변경
							int nx = cur.getX()+dx[dir];
							//현재 위치에서 y위치 변경
							int ny = cur.getY()+dy[dir];
							
							//범위 벗어나거나
							if(nx<0 || ny<0 || nx>=n || ny>=n) {
								continue;
							}
							// 방문한적이 있거나 물에 잠겼거나
							if(vis[nx][ny]==1||picture[nx][ny]<=h) {
								continue;
							}
							//방문 표시
							vis[nx][ny]=1;
							//해당 위치 queue에 넣어줌
							queue.add(new Pair(nx,ny));
						}
					}
				}
				maxCount=Math.max(maxCount, count);
			}
		}
		
		bw.write(maxCount+"\n");
		
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
