package boj;

import java.util.Scanner;

//사분면 알아내기
public class P14681 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int quadrant;
		if (x>=0&&y>=0) {
			quadrant=1;
			System.out.println(quadrant);
		} else if (x<=0&&y>=0) {
			quadrant=2;
			System.out.println(quadrant);
		} else if (x<=0&&y<=0) {
			quadrant=3;
			System.out.println(quadrant);
		} else if (x>=0&&y<=0) {
			quadrant=4;
			System.out.println(quadrant);
		}

	}

}
