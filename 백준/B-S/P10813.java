package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P10813 {
//공 바꾸기
	public static void main(String[] args) throws IOException {
		// 선언
//        Scanner sc = new Scanner (System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int basket=Integer.parseInt(st.nextToken()); 
        int addNum=Integer.parseInt(st.nextToken());
        int tmp;
        ArrayList<Integer> list= new ArrayList<Integer>();
        // 동작
        for(int i=1;i<=basket;i++) {
        	list.add(i);
        }

        // 공 바꾸기5
        for(int i=0;i<addNum;i++) {
        	st = new StringTokenizer(br.readLine());
        	int startBall=Integer.parseInt(st.nextToken()); 
        	int endBall=Integer.parseInt(st.nextToken());
        	tmp = list.get(startBall-1);
        	list.set(startBall-1, list.get(endBall-1));
        	list.set(endBall-1, tmp);


        }
        
        for(int i=0;i<list.size();i++) {
        	System.out.print(list.get(i)+" ");
        }


       


	}
}
