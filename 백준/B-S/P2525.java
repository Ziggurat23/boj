package boj;

import java.util.Scanner;

public class P2525 {
// 오븐 자동 시계
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int calcHour=A;
		int calcMinute=B+C;
		if(calcMinute>=60) {
			calcHour=calcHour+(calcMinute/60);
			calcMinute=(calcMinute%60);
			
		}
		if(calcHour>=24) {
			calcHour-=24;
		} 
		System.out.println(calcHour+" "+calcMinute);
	}

}
