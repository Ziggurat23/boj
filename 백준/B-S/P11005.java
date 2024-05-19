package boj;

import java.util.Scanner;

public class P11005 {
// 진법 변환 2
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long baseStr= sc.nextLong();
        String calcNum=Long.toString(baseStr, sc.nextInt());
        System.out.println(calcNum.toUpperCase());
        
        sc.close();
	}

}
