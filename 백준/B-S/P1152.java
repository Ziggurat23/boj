package boj;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

public class P1152 {
//단어의 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str= sc.nextLine();
		ArrayList<String> list = new ArrayList<String>();
		
		if (!str.isEmpty()) {
			String[] words = str.split(" ");
			for(String word:words) {
				if(!word.isEmpty()) {
					list.add(word);
				}
			}
		}
			
		
		

		
		System.out.println(list.size());
		
		sc.close();
	}

}
