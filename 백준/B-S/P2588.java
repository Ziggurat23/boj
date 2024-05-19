package boj;
import java.util.Scanner;
import java.util.ArrayList;
public class P2588 {
// 차례 차례 곱셈하기.
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt();
		int b= sc.nextInt();
		int n=1;
		int extractNum;
		int ret;
		int sum=0;
		ArrayList<Integer> finalNum= new ArrayList<Integer>();
		while(b!=(b%n)) {
			extractNum=(b/(n))%10;
			ret=a*extractNum;
			System.out.println(ret); 
			n=n*10; // 자릿수 업
			finalNum.add(ret); // 배열에 저장
		};

		// 최종 계산
		for(int i=0;i<finalNum.size();i++) {
			sum+=finalNum.get(i) * Math.pow(10, i);

		}
		System.out.println(sum);
	

		
	}

}
