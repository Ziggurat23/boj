import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//상범빌딩
    // 방향 벡터: x, y, z 축 이동 (6방향: 앞, 뒤, 좌, 우, 상, 하)
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 무한 루프를 통해 여러 테스트 케이스 처리
        while (true) {
            // h, m, n 입력 받기 (층, 행, 열)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 입력 종료 조건
            if (h == 0 && m == 0 && n == 0) {
                break;
            }

            // 3차원 배열 초기화
            int[][][] dist = new int[n][m][h];
            Queue<Pair> queue = new ArrayDeque<>();

            Pair start = null; // 시작 위치
            Pair end = null; // 종료 위치

            // 입력을 받으며 배열 초기화
            for (int k = 0; k < h; k++) {
                for (int i = 0; i < n; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < m; j++) {
                        char ch = line.charAt(j);
                        if (ch == 'S') { // 시작 위치
                            queue.offer(new Pair(i, j, k));
                            dist[i][j][k] = 0;
                        } else if (ch == 'E') { // 종료 위치
                            end = new Pair(i, j, k);
                            dist[i][j][k] = -1; // 탈출 지점도 초기에는 도달하지 않은 상태
                        } else if (ch == '.') {
                            dist[i][j][k] = -1; // 이동 가능 위치
                        } else {
                            dist[i][j][k] = -2; // 벽
                        }
                    }
                }
                br.readLine(); // 층 사이의 공백 라인 처리
            }


         // BFS 실행
            while (!queue.isEmpty()) {
                Pair current = queue.poll();

                // 'E'에 도달한 경우
                if (current.x == end.x && current.y == end.y && current.z == end.z) {
                    bw.write("Escaped in " + dist[current.x][current.y][current.z] + " minute(s).\n");
                    break;
                }

                // 6방향으로의 이동 탐색
                for (int dir = 0; dir < 6; dir++) {
                    int nx = current.x + dx[dir];
                    int ny = current.y + dy[dir];
                    int nz = current.z + dz[dir];

                    // 이동 범위 체크
                    if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h || dist[nx][ny][nz] != -1) {
                        continue;
                    }

                    // 다음 위치로 이동
                    dist[nx][ny][nz] = dist[current.x][current.y][current.z] + 1;
                    queue.offer(new Pair(nx, ny, nz));
                }
            }

            // 'E'에 도달하지 못한 경우
            if (end != null && dist[end.x][end.y][end.z] == -1) {
                bw.write("Trapped!\n");
            }
        }

        // 출력 스트림 정리
        bw.flush();
        bw.close();
        br.close();
    }

    // 3차원 좌표를 나타내기 위한 Pair 클래스
    static class Pair {
        int x, y, z;

        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }
}
