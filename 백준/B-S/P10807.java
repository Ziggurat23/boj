package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P10807 {
// 개수 세기
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 
        ArrayList<Integer> list= new ArrayList<Integer>();
        int sum=0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
        	int A = Integer.parseInt(st.nextToken());
        	list.add(A);
        }
        
        int SearchNum = Integer.parseInt(br.readLine()); // 찾을 숫자
        for (int i=0;i<list.size();i++) {
        	if (SearchNum==list.get(i)) {
        		sum+=1;
        	}
        }
        System.out.println(sum);

        bw.flush();
        bw.close();
    }

}
