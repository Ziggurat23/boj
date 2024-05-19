package boj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P3009 {
//네 번째 점
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> dotX=  new ArrayList<Integer>();
        ArrayList<Integer> dotY=  new ArrayList<Integer>();
        // 중복요소 넣는 집합
        Set<Integer> duplicates = new HashSet<>();
        // 중복요소 제거한 집합
        Set<Integer> unique = new HashSet<>();

        // 좌표 입력
        for(int i = 0;i<3;i++) {
        	dotX.add(sc.nextInt());
        	dotY.add(sc.nextInt());
        }

        // 중복 요소 찾기
        for (Integer number : dotX) {
            if (!unique.add(number)) {
                duplicates.add(number);
            }
        }
        // 중복 요소 제거
        dotX.removeAll(duplicates);
        unique.clear();
        duplicates.clear();
        
        
        for (Integer number : dotY) {
        	if (!unique.add(number)) {
        		duplicates.add(number);
        	}
        }
        dotY.removeAll(duplicates);
        unique.clear();
        duplicates.clear();
        
        
        System.out.print(dotX.get(0)+" ");
        System.out.print(dotY.get(0));
        
        
        //자원반납
        sc.close();

	}

}
