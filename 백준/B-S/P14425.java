package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P14425 {
//문자열 집합
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set= new HashSet<String>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum=0;
        
        for(int i=0;i<N;i++) {
        	String str=br.readLine();
        	set.add(str);
        }
        for(int i=0;i<M;i++) {
        	String str=br.readLine();
        	if(set.contains(str)) {
        		sum+=1;
        	}
        }
        System.out.println(sum);        
        
        //자원반납
        br.close();
	}

}
