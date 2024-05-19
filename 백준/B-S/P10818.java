package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.IOException;

public class P10818 {

	public static void main(String[] args) throws IOException {
		// 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int min=0;
        int max=0;
        ArrayList<Integer> list= new ArrayList<Integer>();

        
        // 동작
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
        	int A = Integer.parseInt(st.nextToken());
        	list.add(A);
        }
        

        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));


        bw.flush();
        bw.close();
	}

}
