

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//불
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int k = 0 ; k<T; k++) {
			// 배열 크기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			boolean isValid = false;
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
			// *, @이 초기 위치
			// .이 움직일 수 있는 공간
			// #이 움직일 수 없는 공간
			for(int i = 0; i < R; i++) {
			    String line = br.readLine();
			    for(int j = 0; j < C; j++) {
			        board[i][j] = String.valueOf(line.charAt(j));
			        if(board[i][j].equals("@")) { // 지훈이의 시작 위치
			            queueJ.add(new Pair(i, j));
			            dist1[i][j] = 0; // 시작 지점의 거리는 0
			        } else if(board[i][j].equals("*")) { // 불의 시작 위치
			            queueF.add(new Pair(i, j));
			            dist2[i][j] = 0; // 불의 시작 지점의 거리도 0
			        } else if(board[i][j].equals(".")) { // 이동 가능한 공간
			            dist1[i][j] = -1; // -1로 초기화하여 방문하지 않음을 표시
			            dist2[i][j] = -1;
			        }
			    }
			}

			//불에 대한 BFS
			while(!queueF.isEmpty()) {
			    Pair cur = queueF.poll();
			    for(int dir=0;dir<4;dir++) {
			        int nx = cur.getX() + dx[dir];
			        int ny = cur.getY() + dy[dir];
			        // 배열 범위를 벗어나는 경우는 무시
			        if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			        // 이미 방문했거나 벽인 경우 무시
			        if(dist2[nx][ny] >= 0 || board[nx][ny].equals("#")) continue;
			        // 불이 번질 수 있는 위치의 거리를 업데이트
			        dist2[nx][ny] = dist2[cur.getX()][cur.getY()] + 1;
			        queueF.add(new Pair(nx, ny));
			    }
			}
			
			// 지훈이에 대한 BFS 처리
			while(!queueJ.isEmpty()) {
			    Pair cur = queueJ.poll();
		        // 지훈이가 범위를 벗어나면 탈출한 것으로 처리
                if (cur.getX() == 0 || cur.getY() == 0 || cur.getX() == R - 1 || cur.getY() == C - 1) {
                    bw.write((dist1[cur.getX()][cur.getY()] + 1) + "\n");
                    isValid = true;
                    break;
                }
			    for(int dir=0;dir<4;dir++) {
			        int nx = cur.getX() + dx[dir];
			        int ny = cur.getY() + dy[dir];
			        // 배열 범위를 벗어난 경우는 이동할 수 없으므로 무시
			        if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
			        // 이미 방문했거나 벽인 경우 무시
			        if(dist1[nx][ny] >= 0 || board[nx][ny].equals("#")) continue;
			        // 불이 이미 도달했거나 동시에 도달하는 경우 지훈이가 이동할 수 없음
			        if(dist2[nx][ny] != -1 && dist2[nx][ny] <= dist1[cur.getX()][cur.getY()] + 1) continue;


			        // 지훈이의 위치와 거리를 업데이트
			        dist1[nx][ny] = dist1[cur.getX()][cur.getY()] + 1;
			        queueJ.add(new Pair(nx, ny));
			        

			    }
			    if(isValid) break; // 탈출에 성공했으면 외부 루프도 중단
			}
			
			

			//지훈이가 탈출을 못하고 루프를 빠져나올 경우
			if(!isValid) {
				bw.write("IMPOSSIBLE"+"\n");
			}
		}

		
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
