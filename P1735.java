package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class P1735 {
//분수 합
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		long C = Long.parseLong(st2.nextToken());
		long D = Long.parseLong(st2.nextToken());
		
		long LCM = (Math.abs(B*D))/GCD(B,D);
		long fractionSum = A*(LCM/B)+ C*(LCM/D);
		
		//기약분수 변환
		long GCD=GCD(fractionSum,LCM);
		LCM= LCM/GCD;
		fractionSum= fractionSum/GCD;
		
		System.out.println(fractionSum+" "+LCM);
		
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
