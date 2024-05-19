package boj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class P3052 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> calcList = new ArrayList<Integer>();
		HashSet<Integer> set= new HashSet<Integer>();
		
		for(int i=0;i<10;i++) {
			list.add(sc.nextInt());
		}
		for(int i=0;i<10;i++) {
			set.add(list.get(i)%42);
		}


		System.out.println(set.size());

	}

}
