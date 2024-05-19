package boj;



import java.util.Scanner;

public class P2908 {
// 상수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder num1 = new StringBuilder(sc.next());
		StringBuilder num2 = new StringBuilder(sc.next());
		int intNum1=Integer.parseInt(num1.reverse().toString());
		int intNum2=Integer.parseInt(num2.reverse().toString());
		
		System.out.println(intNum1>intNum2?intNum1:intNum2);
	
		
		sc.close();
	}

}
