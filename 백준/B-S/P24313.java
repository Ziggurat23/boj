package boj;

import java.util.Scanner;

public class P24313 {
//알고리즘 수업 - 점근적 표기 1
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1= sc.nextInt();
        int a0= sc.nextInt();
        int c = sc.nextInt();
        int n0 =  sc.nextInt();
        
        if(a1*n0+a0<=c*n0 && c - a1>=0) {
        	System.out.println(1);
        } else {
        	System.out.println(0);
        }

	}

}
