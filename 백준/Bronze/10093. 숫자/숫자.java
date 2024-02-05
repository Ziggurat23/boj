import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
//숫자
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        if(N>M) {
        	long temp = N;
        	N = M;
        	M = temp;
        }
        if(N==M) {
        	bw.write("0");
        } else {
        	bw.write((M-N-1)+"\n");
            for(long i=N+1;i<M;i++) {
            	bw.write(i+" ");
            }	
        }
        
        
        
        
        //자원반납
        bw.flush();
        bw.close();
        br.close();

	}

}
