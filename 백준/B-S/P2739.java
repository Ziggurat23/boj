package boj;

import java.util.Scanner;

public class P2739 {
//구구단
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int MultiTable = sc.nextInt();
		for(int i=1;i<=9;i++) {
			System.out.println(MultiTable+" * "+i+" = "+(MultiTable*i));
		}
	}

}
