package boj;

import java.util.Scanner;

public class P10988 {
//팰린드롬인지 확인하기
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str = sc.next();
		String reversed = new StringBuilder(str).reverse().toString();
		System.out.println(str.equals(reversed)?1:0);
		
		
	}

}
