package boj;

import java.util.Scanner;

public class P19532 {
//수학은 비대면강의입니다
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        double f = sc.nextDouble();
        
        int x = (int)Math.round((e*c/(a*e-b*d)-(b*f)/(a*e-b*d)));
        int y = (int)Math.round((-d*c/(a*e-b*d)+(a*f)/(a*e-b*d)));
        
        //y출력
        System.out.println(x);
        System.out.println(y);

        
        
        
        //자원반납
        sc.close();
	}

}
