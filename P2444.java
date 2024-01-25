package boj;

import java.util.Scanner;

public class P2444 {
// 별 찍기 - 7
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=1;i<=N;i++) {
			for(int j=0;j<N-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i*2-1;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for(int i=1;i<=N;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<(N-i)*2-1;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

}
