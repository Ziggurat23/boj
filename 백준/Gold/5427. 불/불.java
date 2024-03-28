

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            boolean isValid = false;

            String[][] board = new String[R][C];
            int[][] dist1 = new int[R][C]; // 지훈이에 대한 거리
            int[][] dist2 = new int[R][C]; // 불에 대한 거리

            Queue<Pair> queueJ = new ArrayDeque<>();
            Queue<Pair> queueF = new ArrayDeque<>();

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < R; i++) {
                String line = br.readLine();
                for (int j = 0; j < C; j++) {
                    board[i][j] = String.valueOf(line.charAt(j));
                    dist1[i][j] = -1; // 초기화
                    dist2[i][j] = -1; // 초기화

                    if (board[i][j].equals("@")) {
                        queueJ.add(new Pair(i, j));
                        dist1[i][j] = 0;
                    } else if (board[i][j].equals("*")) {
                        queueF.add(new Pair(i, j));
                        dist2[i][j] = 0;
                    }
                }
            }

            while (!queueF.isEmpty()) {
                Pair cur = queueF.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.getX() + dx[dir];
                    int ny = cur.getY() + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (dist2[nx][ny] >= 0 || board[nx][ny].equals("#")) continue;

                    dist2[nx][ny] = dist2[cur.getX()][cur.getY()] + 1;
                    queueF.add(new Pair(nx, ny));
                }
            }

            while (!queueJ.isEmpty()) {
                Pair cur = queueJ.poll();
                if (cur.getX() == 0 || cur.getY() == 0 || cur.getX() == R - 1 || cur.getY() == C - 1) {
                    bw.write((dist1[cur.getX()][cur.getY()] + 1) + "\n");
                    isValid = true;
                    break;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.getX() + dx[dir];
                    int ny = cur.getY() + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (dist1[nx][ny] >= 0 || board[nx][ny].equals("#")) continue;
                    if (dist2[nx][ny] != -1 && dist2[nx][ny] <= dist1[cur.getX()][cur.getY()] + 1) continue;

                    dist1[nx][ny] = dist1[cur.getX()][cur.getY()] + 1;
                    queueJ.add(new Pair(nx, ny));
                }
            }

            if (!isValid) {
                bw.write("IMPOSSIBLE\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
