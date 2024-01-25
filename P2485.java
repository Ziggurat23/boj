package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P2485 {
//가로수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long GCD = 0;
		ArrayList<Long> list = new ArrayList<Long>();
		ArrayList<Long> gap = new ArrayList<Long>();
		long sum = 0;
		//배열에 집어넣기
		for (int i=0;i<N;i++ ){
			Long A = Long.parseLong(br.readLine());
			list.add(A);
		}
		//간격 집어넣기
		for(int i=1;i<N;i++) {
			gap.add(list.get(i)-list.get(i-1));
		}
		
		// 간격의 최대공약수
		GCD = gap.get(0); // 초기값 설정
		for(int i=1; i < gap.size(); i++) {
		    GCD = GCD(GCD, gap.get(i));
		}
		// 각 가로수 사이에 GCD 간격에 따른 새 가로수 추가 필요 여부 확인
		for(long L:gap) {
			
			sum+=(L/GCD)-1;
		}
		System.out.println(sum);
		//자원반납
		br.close();
	}
	//최대공약수 구하기
	public static long GCD(long a, long b) {
		if(b==0) {
			return a;
		} else {
			return GCD(b,a%b);
		}
		
	}
}
