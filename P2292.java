package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2292 {
// 벌집
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long N = Integer.parseInt(br.readLine());
        
        long i = 1;
        while (N>1) {
        	N=N-6*i;	
        	i++;
		}
        System.out.println(i);
        
        
        bw.flush();
        bw.close();
        br.close();
	}

}
