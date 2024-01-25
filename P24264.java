package boj;

import java.util.Scanner;

public class P24264 {
//알고리즘 수업 - 알고리즘의 수행 시간 3
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n= sc.nextInt();
//		O(N);
		System.out.println((long)Math.pow(n, 2));
		System.out.println(2);
		
		//자원반납
		sc.close();
	}

}
