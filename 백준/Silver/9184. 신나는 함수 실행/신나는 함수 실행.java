import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
//신나는 함수 실행
	
	private static int[][][] dp = new int[51][51][51];
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
        	
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1 &&c==-1) break;
            bw.write("w("+a+", "+b+", "+c+") = "+wFunction(a, b, c)+"\n");
        }


		
		// 자원 반납
        bw.flush();
        bw.close();
        br.close();
	}
	
	public static int wFunction(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0) {
			return 1;
		}
		if(a> 20 || b> 20 || c >20) {
			return wFunction(20, 20, 20);
		} 
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            dp[a][b][c] = wFunction(a, b, c - 1) + wFunction(a, b - 1, c - 1) - wFunction(a, b - 1, c);
        } else {
            dp[a][b][c] = wFunction(a - 1, b, c) + wFunction(a - 1, b - 1, c) + wFunction(a - 1, b, c - 1) - wFunction(a - 1, b - 1, c - 1);
        }
        return dp[a][b][c];
	}
	
	
}
