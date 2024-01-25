package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class P2231 {
//분해합
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list= new ArrayList<Integer>();
        for(int i =0;i<num;i++) {
        	int sum = 0 ;
        	int tmpNum = i;
        
        	
        	while (tmpNum > 0) {
                int digit = tmpNum % 10;
                list.add(digit);
                tmpNum = tmpNum / 10;
            }
        	
        	for(int j=0;j<list.size();j++) {
        		sum+=list.get(j);
        	}
        	if(num==sum+i) {
        		System.out.println(i);
        		//자원반납
                sc.close();
        		return;
        	}
        	list.clear();
        }
        System.out.println(0);
        
        
        
	}

}
