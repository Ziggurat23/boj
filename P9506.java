package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class P9506 {
//약수들의 합 
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		
		while(true) {
			int N = sc.nextInt();
			int sum=0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			//종료조건
			if(N==-1) {
				sc.close();
				return;
			}
			
			//약수를 배열에 넣기
			for(int i=1;i<=N;i++) {
				if(N%i==0 && N!=i) {
					list.add(i);
				}
			}
			//합 구하기
			for(int i=0;i<list.size();i++) {
				sum+= list.get(i);
				
			}
			
			//합 비교
			if(sum==N) {
				System.out.print(N + " = ");
				for(int i=0;i<list.size()-1;i++) {
					System.out.print(list.get(i)+" + ");
				}
				System.out.print(list.get(list.size()-1)+"\n");
			} else {
				System.out.print(N+" is NOT perfect.\n");
			}

			
			
		}




	}

}
