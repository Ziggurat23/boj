import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum=0;
        int flip;
        for(int j=0;j<3;j++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i= 0;i<4;i++) {
            	flip=Integer.parseInt(st.nextToken());
            	sum+=flip;
            }
        	switch (sum) {
			case 0:
				bw.write("D\n");
				break;
			case 1:
				bw.write("C\n");
				break;
			case 2:
				bw.write("B\n");
				break;
			case 3:
				bw.write("A\n");
				break;
			case 4:
				bw.write("E\n");
				break;
			default:
				break;
			}
        	sum=0;
        }
        
  

        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}

}
