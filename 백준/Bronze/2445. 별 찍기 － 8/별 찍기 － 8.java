import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
//별 찍기 - 8
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++) {
        	//별
            for(int k = 0;k<i;k++) {
            	System.out.print("*");
            }
        	//공백
            for (int j = 0; j < 2*(N-i); j++) {
            	System.out.print(" ");
            }
            //별
            for(int k = 0;k<i;k++) {
            	System.out.print("*");
            }
            System.out.print("\n");
        };
        for(int i=N-1;i>=1;i--) {
        	//별
        	for(int k = 0;k<i;k++) {
        		System.out.print("*");
        	}
        	//공백
        	for (int j = 0; j < 2*(N-i); j++) {
        		System.out.print(" ");
        	}
        	//별
        	for(int k = 0;k<i;k++) {
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
