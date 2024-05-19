package boj;

import java.util.Scanner;

public class P5086 {
//배수와 약수
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=1;
		int M=1;
		while(true) {
			N = sc.nextInt();
			M = sc.nextInt();
			if(N==0 && M==0) {
				sc.close();
				return;
			}
			if(N>=M) {
				if(N%M==0) {
					System.out.println("multiple");
				} else {
					System.out.println("neither");
				}
			}  else {
				if(M%N==0) {
					System.out.println("factor");
				} else {
					System.out.println("neither");
				}
			}
		}
	}

}
