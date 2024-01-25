package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class P1546 {
//평균 
	public static void main(String[] args) throws IOException {
		//선언


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double sum=0;
        ArrayList<Double> list= new ArrayList<Double>();
        
        //동작
        for(int i=0;i<N;i++) {
        	list.add(sc.nextDouble());
        }
        double max=Collections.max(list);

        
        for(int i=0;i<N;i++) {
        	list.set(i, list.get(i)/max*100);
        	sum+=list.get(i);
        }
        System.out.println(sum/list.size());
        
        sc.close();

	}

}
