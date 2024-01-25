package boj;

import java.util.Scanner;

public class P2745 {
// 진법 변환
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String baseStr= sc.next();
        long calcNum=Long.parseLong(baseStr, sc.nextInt());
        System.out.println(calcNum);
        
        sc.close();
	}

}
