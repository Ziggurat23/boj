package boj;

import java.util.Scanner;

public class P10950 {
// A + B - 3
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int caseNum = sc.nextInt();
		int A,B,result;
		for (int i=0;i<caseNum;i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			result = A + B;
			System.out.println(result);
		}

	}

}
