import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
//다리 놓기
	public static void main(String[] args) throws IOException{
		//조합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int K = Integer.parseInt(st.nextToken());
        	int N = Integer.parseInt(st.nextToken());
        	
        	long result = combination(N, K);
        	bw.write(String.valueOf(result)+"\n");
        }
        
        
        
        
        //자원반납
        bw.flush();
        bw.close();
        br.close();
		
	}
	public static long combination(int n, int k) {
        long result = 1;
        k = Math.min(k, n - k);

        for (int i = 1; i <= k; i++) {
            result *= n - k + i;
            result /= i;
        }

        return result;
    }
}
