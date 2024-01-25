package boj;

import java.util.Scanner;

public class P1436 {
//영화감독 숌
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int order=0;
        for(int i =0;i<=Integer.MAX_VALUE;i++) {
        	String str=String.valueOf(i);
        	if(str.indexOf("666")>=0) {
        		order++;
        		if(order==num) {
        			System.out.println(i);
        			sc.close();
        			return;
        		}
        	}
        }
        
	}

}
