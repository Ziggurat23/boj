package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2587 {
//대표값2
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list= new ArrayList<Integer>();
        for(int i=0;i<5;i++) {
        	list.add(sc.nextInt());
        }
        Collections.sort(list);
        double average = list.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);
        System.out.println((int)average);
        System.out.println(list.get(2));
        
        //자원반납
        sc.close();
	}

}
