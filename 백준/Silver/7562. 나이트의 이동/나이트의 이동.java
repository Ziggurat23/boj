
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
// 나이트의 이동
    static int n, m; // 도화지의 세로, 가로 크기
    static int[][] board; // 도화지 정보를 저장할 2차원 배열
    static boolean[][] visited; // 방문 여부를 체크할 2차원 배열
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}; // 상하좌우 이동을 위한 x축 변화량
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1}; // 상하좌우 이동을 위한 y축 변화량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트 케이스
        
        int t = Integer.parseInt(br.readLine()); 
        
        for (int k= 0 ; k < t; k++) {
            n = Integer.parseInt(br.readLine()); // 도화지의 세로 크기 입력받기
            m = n; // 도화지의 가로 크기 입력받기
            board = new int[n][m]; // 도화지 정보를 저장할 2차원 배열 초기화
            visited = new boolean[n][m]; // 방문 여부를 체크할 2차원 배열 초기화

            // 나이트 위치와 끝 위치
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            
            
            
            int minArea = bfs(startX, startY,endX,endY); // 가장 짧은 넓이 반환


            bw.write(minArea + "\n"); // 가장 짧은 넓이 출력
        }
        
        //자원반납
        bw.flush();
        bw.close();
        br.close();
    }

    // BFS 수행 메서드
    private static int bfs(int startX, int startY, int endX, int endY ) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY , 0}); // 시작 좌표를 큐에 삽입 , 길이도 삽입
        visited = new boolean[n][m]; // visit 초기화
        visited[startX][startY] = true; // 시작 좌표 방문 체크
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 큐에서 현재 좌표 꺼내기
            int currentX = current[0];
            int currentY = current[1];
            int moves = current[2];
            if(currentX == endX && currentY == endY) {

            	return moves;
            }
            
            // 8방향으로 이동하며 그림의 넓이 탐색
            for (int i = 0; i < 8; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];
                
                
                
                // 도화지 범위 내에 있고, 그림이 있으며 아직 방문하지 않은 좌표인 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m  && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny, moves+1}); // 다음 좌표를 큐에 삽입
                    visited[nx][ny] = true; // 다음 좌표 방문 체크
                }
            }
        }

        return -1; // 그림의 넓이 반환
     }
} 
