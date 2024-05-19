package boj;


import java.util.Scanner;

public class P11720 {
//숫자의 합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum=0;
		String strNum = sc.next();
		
		for(int i=0;i<N;i++) {
			sum+=Integer.parseInt(strNum.substring(i,i+1));
					
		}
		System.out.println(sum);
	}

}
