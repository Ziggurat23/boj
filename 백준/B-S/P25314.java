package boj;

import java.util.Scanner;

public class P25314 {
// 코딩은 체육과목입니다.
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int dataType = sc.nextInt();
		if (dataType>0 && dataType%4==0) {
			for(int i=0;i<dataType/4;i++) {
					System.out.print("long ");
			}
			System.out.print("int");
		}
	}

}
