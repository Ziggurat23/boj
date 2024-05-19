package boj;

import java.util.Scanner;

public class P11653 {
// 소인수분해
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		int i=2;
		while (num>1) {
			if(num%i==0) {
				System.out.println(i);
				num=num/i;
				i=1;
			}
			i++;
		}

		//자원반납
		sc.close();
	}

}
