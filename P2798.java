package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class P2798 {
//블랙잭
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();
        int num =  sc.nextInt();
        int max=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<N;i++) {
        	list.add(sc.nextInt());
        }

        for(int i=0;i<list.size();i++) {
        	for(int j=i+1;j<list.size();j++) {
        		for(int k=j+1;k<list.size();k++) {
        			int sum= list.get(i)+list.get(j)+list.get(k);
        			if(max<sum && num>=sum) {
        				max=sum;
        			}
        		}
        	}
        }
        
        System.out.println(max);
        //자원반납
        sc.close();
	}

}
