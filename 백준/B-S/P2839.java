package boj;

import java.util.Scanner;

public class P2839 {
//설탕 배달
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);		
        int num = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<num/3;i++) {
        	int bag=0;
        	//5킬로
        	bag=num/5-i;
        	int remainCount=num-bag*5;
        	
        	
            //3킬로
        	if(remainCount%3==0) {	
        		bag=bag+remainCount/3;
        		if(min>bag) {
            		min=bag;
            	}
        	}
        	
        	
        	
        }
        if(min==Integer.MAX_VALUE) {
        	System.out.println(-1);
        } else {
        	System.out.println(min);
        }
        
        //자원반납
        sc.close();
	}

}
