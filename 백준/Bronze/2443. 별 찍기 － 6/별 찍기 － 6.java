import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
//별 찍기 - 6
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        for(int i=N;i>=0;i--) {
        	//공백
            for (int j = 0; j < N-i; j++) {
            	System.out.print(" ");
            }
            //별
            for(int k = 0;k<2*i-1;k++) {
            	System.out.print("*");
            }
            System.out.print("\n");
        };
        
        
        //자원반납
        bw.flush();
        bw.close();
        br.close();

	}
}
