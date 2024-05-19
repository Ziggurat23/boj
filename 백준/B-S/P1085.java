package boj;

import java.util.Scanner;

public class P1085 {
//직사각형에서 탈출
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int min = 2147483647;
        int[] values = {x, y, w-x, h-y}; // 향상 for문에 넣을 배열

        for (int value : values) {
            if(min>value) {
            	min=value;
            }
        }
        System.out.println(min);
        //자원반납
        sc.close();
		
	}

}
