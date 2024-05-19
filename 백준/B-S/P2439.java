package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2439 {
// 별 찍기 - 2
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
		int n = Integer.parseInt(br.readLine()); 
		for(int i=1;i<=n;i++) {
			for(int k=0;k<n-i;k++) {
				System.out.print(" ");
			}
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}

	}

}
