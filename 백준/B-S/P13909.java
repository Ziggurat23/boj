package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13909 {
//창문 닫기
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=  Integer.parseInt(br.readLine());
		int sum=0;
		
		//약수가 홀수가 되는 경우는 중앙의 약수가 자기 자신과 곱해져서 해당 값이 나올 경우뿐이므로 완전제곱수를 구한다
		for(int i=1;i*i<=N;i++) {
			sum++;
		}
		System.out.println(sum);
		
		//자원반납
		br.close();

	}

}
