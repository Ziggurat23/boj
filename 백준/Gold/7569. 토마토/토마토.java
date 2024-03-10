import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//토마토 - 3차원
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 배열 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		// 미로 배열
		int[][][] board= new int[n][m][h];
		// 거리 배열
		int[][][] dist = new int[n][m][h];
		Queue<Pair> queue = new ArrayDeque<>(); 
		// 방향 지정
		int dx[] = {1,0,-1,0,0,0};
		int dy[] = {0,1,0,-1,0,0};
		int dz[] = {0,0,0,0,1,-1};
		
		// 초기 배열 입력
		// 1이 초기 위치
		// 0이 움직일 수 있는 공간
		// -1이 움직일 수 없는 공간
		// 3차원인데 높이를 순서대로 입력을 받으므로 높이 루프를 가장 바깥으로
		for(int k = 0; k < h; k++) {
		    for(int i = 0; i < n; i++) {
		        st = new StringTokenizer(br.readLine());
		        for(int j = 0; j < m; j++) {
		            board[i][j][k] = Integer.parseInt(st.nextToken());
		            if(board[i][j][k] == 1) {
		                queue.add(new Pair(i, j, k));
		                dist[i][j][k] = 0; 
		            } else if(board[i][j][k] == 0) {
		                dist[i][j][k] = -1; 
		            }
		        }
		    }
		}



		//위치 순회
		while(!queue.isEmpty()) {
			// 현재위치 X Y Z 위치
			Pair cur = queue.poll();
			// 4방향 체크
			for(int dir=0;dir<6;dir++) {
				//현재 위치에서 x위치 변경
				int nx = cur.getX()+dx[dir];
				//현재 위치에서 y위치 변경
				int ny = cur.getY()+dy[dir];
				//현재 위치에서 z위치 변경
				int nz = cur.getZ()+dz[dir];
				//범위 벗어나거나
				if(nx<0 || ny<0 || nz<0 || nx>=n || ny>=m || nz>=h ) {
					continue;
				}
				// 방문한적이 있거나 길이 아니거나
				if(dist[nx][ny][nz]>=0||board[nx][ny][nz]==-1) {
					continue;
				}
				// 현재 길이에서 다음 위치에 길이 추가
				dist[nx][ny][nz]= dist[cur.getX()][cur.getY()][cur.getZ()]+1;
				//해당 위치 queue에 넣어줌
				queue.add(new Pair(nx,ny,nz));
			}
		}
				
		int sol = 0;

		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0 ; k < h ; k++) {
					if(dist[i][j][k]==-1) {
						bw.write("-1");
						//자원반납
						bw.flush();
						bw.close();
						br.close();
						return;
					}
					sol = Math.max(sol, dist[i][j][k]);
				}
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
		private int z;
		
		public Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
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
		public int getZ() {
			return z;
		}
		public void setZ(int z) {
			this.z = z;
		}

		
	}
} 
