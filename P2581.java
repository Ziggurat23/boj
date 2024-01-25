package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class P2581 {
// 소수
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int sum=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int startNum=sc.nextInt();
		int endNum=sc.nextInt();
		int totalSum=0;
		int min = 2147483647;
		

		for(int i=startNum;i<=endNum;i++) {
			//약수 넣기
			for(int k=1;k<=i;k++) {
				if(i%k==0) {
					list.add(k);
				}
			}
			
			//소수 확인
			for(int j=0;j<list.size();j++) {
				sum+= list.get(j);
			}
			//소수 합
			if(i==sum-1) {
				totalSum+=i;
				if(i<=min) {
					min=i;
				}
			}
			sum=0;
			list.clear();
		}
		
		//출력
		if(totalSum==0) {
			System.out.println(-1);
		} else {
			System.out.println(totalSum);
			System.out.println(min);
		}

		//자원 반납
		sc.close();
	}

}
