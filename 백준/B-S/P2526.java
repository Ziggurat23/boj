package boj;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2526 {
// 최댓값
	public static void main(String[] args) {
		// 선언

        Scanner sc = new Scanner (System.in);
//        int N = sc.nextInt();
        int max=0;
        int index=0;
        ArrayList<Integer> list= new ArrayList<Integer>();

        
        // 동작

        for (int i=0;i<9;i++) {
        	int A = sc.nextInt();
        	list.add(A);
        }
        max=Collections.max(list);
        index=list.indexOf(max);
        
        System.out.println(max);
        System.out.println(index+1);

	}

}
