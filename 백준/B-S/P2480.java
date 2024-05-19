package boj;

import java.util.Scanner;
// 주사위 세개
public class P2480 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int dice1 = sc.nextInt();
		int dice2 = sc.nextInt();
		int dice3 = sc.nextInt();
		int prize = 0;
		
		if (dice1==dice2 && dice2==dice3) {
			prize= 10000 +dice1*1000;
		} else if(dice1==dice2){
			prize = 1000 +dice1*100;
		} else if(dice2==dice3) {
			prize = 1000 +dice2*100;
		} else if(dice3==dice1) {
			prize = 1000 +dice3*100;
		} else if(dice3>dice2&&dice3>dice1) {
			prize = dice3*100;
		} else if(dice2>dice3&&dice2>dice1) {
			prize = dice2*100;
		} else if(dice1>dice2&&dice1>dice3) {
			prize = dice1*100;
		}
		System.out.println(prize);
		sc.close();
	}
	
}
