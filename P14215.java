package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P14215 {
//세 막대
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rod1=sc.nextInt();
        int rod2=sc.nextInt();
        int rod3=sc.nextInt();
        
        ArrayList<Integer> rods = new ArrayList<Integer>();
        rods.add(rod1);
        rods.add(rod2);
        rods.add(rod3);
        int max = Collections.max(rods);
        int maxIndex = rods.indexOf(max);
        int sum = 0;
        for (int i = 0; i < rods.size(); i++) {
            if (i != maxIndex) { // 최대값의 인덱스가 아닌 경우에만 합산
                sum += rods.get(i);
            }
        }
        if (sum<=max) {
        	sum+= sum-1;
        } else {
        	sum+= max;
        }
        System.out.println(sum);
        //자원반납
        sc.close();
	}

}
