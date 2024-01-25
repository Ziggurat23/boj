package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P10871 {
// X보다 작은 수
	public static void main(String[] args) throws IOException {
		// 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int X = Integer.parseInt(st.nextToken()); 
        
        ArrayList<Integer> list= new ArrayList<Integer>();

        
        // 동작
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
        	int A = Integer.parseInt(st.nextToken());
        	list.add(A);
        }
        

        for (int i=0;i<list.size();i++) {
        	if (X>list.get(i)) {
        		System.out.print(list.get(i)+" ");
        	}
        }


        bw.flush();
        bw.close();
    }

}
