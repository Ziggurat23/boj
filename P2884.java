package boj;

import java.util.Scanner;
//시간 45분 빼기
public class P2884 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		int hourOfWakeUp=H;
		int minuteOfWakeUp=M-45;
		
		if(minuteOfWakeUp<0) {
			hourOfWakeUp--;
			minuteOfWakeUp=minuteOfWakeUp+60;
		}
		if(hourOfWakeUp<0) {
			hourOfWakeUp=hourOfWakeUp+24;
		}
		System.out.println(hourOfWakeUp+" "+minuteOfWakeUp);
	}

}
