import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        bw.write(String.valueOf(tile01(N)));

        //자원반납
        bw.flush();
        bw.close();
        br.close();
    }

    public static int tile01(int num) {
        if (num == 1) return 1;
        if (num == 2) return 2;

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        return dp[num];
    }
}
