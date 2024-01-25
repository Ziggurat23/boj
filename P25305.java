package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P25305 {
//커트라인
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list= new ArrayList<Integer>();
        int N = sc.nextInt();
        int cutLine = sc.nextInt();
        
        for(int i = 0 ; i < N ; i ++) {
        	list.add(sc.nextInt());
        }
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list.get(cutLine-1));
        //자원반납
        sc.close();
	}
	
	

}
