import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
// N-Queen 
    static int N;
    static boolean[] col;      // 열
    static boolean[] diag1;    // 대각선1 - 왼쪽위에서 오른쪽 아래로 
    static boolean[] diag2;    // 대각선2 - 오른쪽 위에서 왼쪽 아래로
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        col = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];
        count = 0;

        placeQueens(0);

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void placeQueens(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!col[i] && !diag1[row + i] && !diag2[row - i + N - 1]) {
                col[i] = diag1[row + i] = diag2[row - i + N - 1] = true;
                placeQueens(row + 1);
                col[i] = diag1[row + i] = diag2[row - i + N - 1] = false;
            }
        }
    }
}