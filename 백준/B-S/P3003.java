package boj;

import java.util.Scanner;

public class P3003 {
//킹, 퀸, 룩, 비숍, 나이트, 폰
	public static void main(String[] args) {
		int[] arr= {1,1,2,2,2,8};
		Scanner sc= new Scanner(System.in);
		for(int i=0;i<6;i++) {
			System.out.print((arr[i]-sc.nextInt())+" ");
			
		}
		

	}

}
