package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P5073 {
//삼각형과 세 변
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        while (true) {
        	int line1=sc.nextInt();
            int line2=sc.nextInt();
            int line3=sc.nextInt();
            //정지조건
            if(line1 == 0 && line2 == 0 && line3 ==0) {
            	//자원반납
                sc.close();
				return;
			}
            
            ArrayList<Integer> lines = new ArrayList<Integer>();
            lines.add(line1);
            lines.add(line2);
            lines.add(line3);
            int max = Collections.max(lines);
            int maxIndex = lines.indexOf(max);
            
            int sum = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (i != maxIndex) { // 최대값의 인덱스가 아닌 경우에만 합산
                    sum += lines.get(i);
                }
            }
            if (sum<=max) {
            	System.out.println("Invalid");
            } else {
    			if (line1==line2 && line2 == line3 && line1 == line3) {
    				System.out.println("Equilateral");
    			} else if(line1==line2 || line2 == line3 || line1 == line3) {
    				System.out.println("Isosceles");
    			} else {
    				System.out.println("Scalene");
    			}
            }

		}

	}

}
