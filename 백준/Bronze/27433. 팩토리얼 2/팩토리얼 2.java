import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
//팩토리얼 2
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        bw.write(String.valueOf(factorial(N)));
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}
	
	public static long factorial(long num) {
		if(num==0) {
			return 1;
		} else {
			return num*factorial(num-1);
		}
			
		
	}
}
