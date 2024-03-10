import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//불!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 배열 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		// 미로 배열
		String[][] board= new String[R][C];
		// 거리 배열
		//지훈이에 대한 거리
		int[][] dist1 = new int[R][C];
		//불에 대한 거리
		int[][] dist2 = new int[R][C];
		//지훈이 큐
		Queue<Pair> queueJ = new ArrayDeque<>();
		//불 큐
		Queue<Pair> queueF = new ArrayDeque<>(); 
		// 방향 지정
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};

		
		// 초기 배열 입력
		// J , F이 초기 위치
		// .이 움직일 수 있는 공간
		// #이 움직일 수 없는 공간
	    for(int i = 0; i < R; i++) {
	    	String line = br.readLine();
	        for(int j = 0; j < C; j++) {
	        	board[i][j] = String.valueOf(line.charAt(j)); 
	            if(board[i][j].equals("J")) {
	                queueJ.add(new Pair(i, j));
	                dist1[i][j] = 0; 
	            } else if(board[i][j].equals("F")) {
	            	queueF.add(new Pair(i, j));
	                dist2[i][j] = 0; 
	            }else if(board[i][j].equals(".")) {
	            	dist1[i][j] = -1; 
	            	dist2[i][j] = -1; 
	            }
	        }
	    }

		//불에 대한 BFS
		while(!queueF.isEmpty()) {
			// 현재위치 X Y Z 위치
			Pair cur = queueF.poll();
			// 4방향 체크
			for(int dir=0;dir<4;dir++) {
				//현재 위치에서 x위치 변경
				int nx = cur.getX()+dx[dir];
				//현재 위치에서 y위치 변경
				int ny = cur.getY()+dy[dir];
				//범위 벗어나거나
				if(nx<0 || ny<0  || nx>=R || ny>=C  ) {
					continue;
				}
				// 방문한적이 있거나 길이 아니거나
				if(dist2[nx][ny]>=0||board[nx][ny].equals("#")) {
					continue;
				}
				// 현재 길이에서 다음 위치에 길이 추가
				dist2[nx][ny]= dist2[cur.getX()][cur.getY()]+1;
				//해당 위치 queue에 넣어줌
				queueF.add(new Pair(nx,ny));
			}
		}
		
		//지훈이에 대한 BFS
		while(!queueJ.isEmpty()) {
			// 현재위치 X Y Z 위치
			Pair cur = queueJ.poll();
			// 4방향 체크
			for(int dir=0;dir<4;dir++) {
				//현재 위치에서 x위치 변경
				int nx = cur.getX()+dx[dir];
				//현재 위치에서 y위치 변경
				int ny = cur.getY()+dy[dir];
				// 지훈이가 범위를 벗어났다는 건 탈출했다는 소리
				if(nx<0 || ny<0  || nx>=R || ny>=C  ) {
					bw.write((dist1[cur.getX()][cur.getY()]+1)+"\n");
					
					//자원반납
					bw.flush();
					bw.close();
					br.close();
					
					return;
				}
				// 방문한적이 있거나 길이 아니거나
				if(dist1[nx][ny]>=0||board[nx][ny].equals("#")) {
					continue;
				}
				//불보다 늦게 갔을 경우
				//불이 지나간 곳이여야하고 
				if(dist2[nx][ny]!= -1 
				// 4방향에서 불이 먼저 지나갔다면 그곳은 지훈이가 지나가지 못한다.	
				&& dist2[nx][ny] <= dist1[cur.getX()][cur.getY()]+1) {
					continue;
				}
				// 현재 길이에서 다음 위치에 길이 추가
				dist1[nx][ny]= dist1[cur.getX()][cur.getY()]+1;
				//해당 위치 queue에 넣어줌
				queueJ.add(new Pair(nx,ny));
			}
		}

		//지훈이가 탈출을 못하고 루프를 빠져나올 경우
		bw.write("IMPOSSIBLE"+"\n");
		
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
