package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2750 {
//수 정렬하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =  sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0;i<N;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		sc.close();
	}

}
