package boj;

import java.util.Scanner;

public class P9063 {
//대지
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long maxX= Integer.MIN_VALUE ;
		long maxY= Integer.MIN_VALUE ;
		long minX= Integer.MAX_VALUE;
		long minY= Integer.MAX_VALUE;
		
		for (int i=0;i<N;i++) {
			long x= sc.nextLong();
			long y= sc.nextLong();
			
			if (maxX<x) {
				maxX=x;
			}
			if (maxY<y) {
				maxY=y;
			}
			if (minX>x) {
				minX=x;
			}
			if (minY>y) {
				minY=y;
			}
		}

		System.out.println((maxX-minX)*(maxY-minY));
        // 자원반납
        sc.close();
	}

}
