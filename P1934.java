package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1934 {
//최소공배수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		int T = Integer.parseInt(br.readLine());
		
		for (int i =0;i < T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.add((Math.abs(A*B))/GCD(A,B));
		}
		for(int num:list) {
			System.out.println(num);
		}
		
		//자원반납
		br.close();
		
	}
	public static int GCD(int a, int b) {
		if(b==0) {
			return a;
		} else {
			return GCD(b,a%b);
		}
		
	}
	
	
}
