package boj;
import java.util.Scanner;
public class Arithmetic {
	public static void main(String[] args)  {
		
		Scanner sc= new Scanner(System.in);

		int A=sc.nextInt();

		int B=sc.nextInt();
		
		int result1=A+B;
		int result2=A-B;
		int result3=A*B;
		int result4=A/B;
		int result5=A%B;
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		
	}
}

