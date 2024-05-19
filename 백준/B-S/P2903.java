package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2903 {
// 중앙 이동 알고리즘
	public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double num = Integer.parseInt(br.readLine());
    	double dotSum=Math.pow(Math.pow(2, num)+1, 2);
        System.out.println((int)dotSum);
        
        bw.flush();
        bw.close();
        br.close();
	}
}
