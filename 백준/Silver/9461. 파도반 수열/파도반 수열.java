import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
//파도반 수열
static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp = new long[101];
        
        // 테스트 개수
        int N = Integer.parseInt(br.readLine());
        
        //반복
        for(int i=0;i<N;i++) {
        int M = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(waveFunc(M))+"\n");
        //초기화
        Arrays.fill(dp, 0);
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    public static long waveFunc(int num) {
    	dp[1]=1;
    	dp[2]=1;
    	dp[3]=1;
    	dp[4]=2;
    	dp[5]=2;
    	dp[6]=3;
    	dp[7]=4;
    	dp[8]=5;
    	dp[9]=7;
    	dp[10]=9;
    	for(int i=11;i<=num;i++) {
    		dp[i]=dp[i-2]+dp[i-3];
    	}
    	return dp[num];
    }


}
