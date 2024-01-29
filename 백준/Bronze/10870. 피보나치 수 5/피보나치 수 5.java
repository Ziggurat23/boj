import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
//피보나치 수 5
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        bw.write(String.valueOf(fibonacci(N)));
        
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}
	
	public static long fibonacci (long num) {
		if(num==0) {
			return 0;
		} else if(num==1) {
			return 1;
		} else {
			return fibonacci(num-1)+fibonacci(num-2);
		}
			
		
	}
}
