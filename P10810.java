package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P10810 {
// 공 넣기
	public static void main(String[] args) {
		// 선언
        Scanner sc = new Scanner (System.in);
        int basket=sc.nextInt();
        int addNum=sc.nextInt();
        ArrayList<Integer> list= new ArrayList<Integer>();
       
        // 동작
        for(int i=0;i<basket;i++) {
        	list.add(0);
        }

        // 공 넣기
        for(int i=0;i<addNum;i++) {
        	int startNum=sc.nextInt();
        	int endNum=sc.nextInt();
        	int ballNum=sc.nextInt();
        	for(int j=startNum-1;j<=endNum-1;j++) {
        		list.set(j, ballNum);
        	}
        }
        
        for(int i=0;i<list.size();i++) {
        	System.out.print(list.get(i)+" ");
        }


       


	}

}
