package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1193 {
//분수찾기
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long N = Integer.parseInt(br.readLine());
        
        long i = 0;
        while (N>0) {
        	N-=i;
        	i++;
		}
        i--;
        N=N+i;

        if(i%2==0) {
        	System.out.println(N+"/"+(i-N+1));
        } else {
        	System.out.println((i-N+1)+"/"+N);
        }
        
        bw.flush();
        bw.close();
        br.close();

	}

}
