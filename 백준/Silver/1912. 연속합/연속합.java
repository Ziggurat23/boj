import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
//연속합

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 수열 크기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] dp = new long[N];
        
        // 첫 번째 숫자 초기화
        dp[0] = Integer.parseInt(st.nextToken());
        long max = dp[0];
        
        for (int i = 1; i < N; i++) {
            long num = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1] + num, num);

            max = Math.max(max, dp[i]);
        }
        bw.write(max+"");
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}
}
