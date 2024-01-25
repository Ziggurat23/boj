package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class P9086 {
//문자열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		String tmp;
		int N = sc.nextInt();
		ArrayList<String> list= new ArrayList<String>();

		for(int i=0;i<N;i++) {
			str = sc.next();

			tmp = String.valueOf(str.charAt(0))+String.valueOf(str.charAt(str.length() - 1));
			list.add(tmp);
		}
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
