package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class P1978 {
// 소수 찾기
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		int N = sc.nextInt();
		int sum=0;
		int numOfPrimeNum=0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i=0;i<N;i++) {
			int primeNum= sc.nextInt();
			//약수 넣기
			for(int k=1;k<=primeNum;k++) {
				if(primeNum%k==0) {
					list.add(k);
					
				}
			}
			
			//소수 확인
			for(int j=0;j<list.size();j++) {
				sum+= list.get(j);
			}
			if(primeNum==sum-1) {
				numOfPrimeNum++;
			}
			sum=0;
			list.clear();
		}
		System.out.println(numOfPrimeNum);
		//자원 반납
		sc.close();
	}

}
