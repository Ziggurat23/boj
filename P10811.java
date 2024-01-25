package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P10811 {
//바구니 뒤집기
	public static void main(String[] args) throws IOException {
		//선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int startNum;
        int endNum;
        ArrayList<Integer> list= new ArrayList<Integer>();
        
        //동작
        for(int i=0;i<N;i++) {
        	list.add(i+1);
        }
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	startNum = Integer.parseInt(st.nextToken()); 
        	endNum = Integer.parseInt(st.nextToken());

        	Collections.reverse(list.subList(startNum-1, endNum));

        }
       
        for(int i=0;i<list.size();i++) {
        	System.out.print(list.get(i)+" ");
        }
        
        
        bw.flush();
        bw.close();
        br.close();
	}

}
