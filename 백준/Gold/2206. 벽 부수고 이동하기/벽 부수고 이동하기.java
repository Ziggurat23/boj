
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 상하좌우 방향을 나타내는 배열
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 위한 BufferedWriter 객체 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받은 문자열을 공백을 기준으로 분리하기 위한 StringTokenizer 객체 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 맵의 행 크기 N 입력 받기
        int N = Integer.parseInt(st.nextToken());
        // 맵의 열 크기 M 입력 받기
        int M = Integer.parseInt(st.nextToken());
        // 맵을 저장할 2차원 배열 생성
        int[][] map = new int[N][M];
        // 방문 여부를 저장할 3차원 배열 생성
        // visited[x][y][0]: 벽을 부수지 않고 (x, y) 위치에 도달했는지 여부
        // visited[x][y][1]: 벽을 부수고 (x, y) 위치에 도달했는지 여부
        boolean[][][] visited = new boolean[N][M][2];

        // 맵 정보 입력 받기
        for (int i = 0; i < N; i++) {
            // 한 줄씩 문자열로 입력 받음
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                // 문자를 숫자로 변환하여 맵 배열에 저장
                // '0' -> 0, '1' -> 1
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS 함수 호출하여 최단 경로 길이 계산
        int result = bfs(map, visited, N, M);

        // 결과 출력
        bw.write(String.valueOf(result));

        // 자원 반납
        bw.flush();
        bw.close();
        br.close();
    }

    // BFS 함수
    public static int bfs(int[][] map, boolean[][][] visited, int N, int M) {
        // BFS에 사용할 큐 생성
        Queue<Node> queue = new ArrayDeque<>();

        // 시작 위치 (0, 0)을 큐에 삽입하고 방문 처리
        // 시작 위치의 거리는 1, 벽을 부순 횟수는 0
        queue.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        // 큐가 빌 때까지 BFS 수행
        while (!queue.isEmpty()) {
            // 큐에서 현재 노드를 꺼냄
            Node cur = queue.poll();

            // 현재 노드가 도착 위치인 경우 (N-1, M-1)
            if (cur.x == N - 1 && cur.y == M - 1) {
                // 현재까지의 거리를 반환하고 종료
                return cur.dist;
            }

            // 상하좌우 방향으로 이동
            for (int i = 0; i < 4; i++) {
                // 다음 위치 계산
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 맵의 범위를 벗어나는 경우 건너뜀
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                // 다음 위치가 벽이 아니고 아직 방문하지 않은 경우
                if (map[nx][ny] == 0 && !visited[nx][ny][cur.breakWall]) {
                    // 다음 위치를 방문 처리하고 큐에 삽입
                    visited[nx][ny][cur.breakWall] = true;
                    queue.offer(new Node(nx, ny, cur.dist + 1, cur.breakWall));
                }
                // 다음 위치가 벽이고 벽을 부순 적이 없는 경우
                else if (map[nx][ny] == 1 && cur.breakWall == 0) {
                    // 벽을 부수고 다음 위치를 방문 처리하고 큐에 삽입
                    visited[nx][ny][1] = true;
                    queue.offer(new Node(nx, ny, cur.dist + 1, 1));
                }
            }
        }

        // 도착 위치에 도달하지 못한 경우 -1 반환
        return -1;
    }

    // 노드 클래스
    static class Node {
        int x;          // 노드의 x 좌표
        int y;          // 노드의 y 좌표
        int dist;       // 시작 위치로부터의 거리
        int breakWall;  // 벽을 부순 횟수 (0 또는 1)

        // 생성자
        public Node(int x, int y, int dist, int breakWall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.breakWall = breakWall;
        }

        // getter, setter 메서드
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

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public int getBreakWall() {
            return breakWall;
        }

        public void setBreakWall(int breakWall) {
            this.breakWall = breakWall;
        }
    }
}