package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1764 {
//듣보잡
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        HashSet<String> set= new HashSet<String>();
        ArrayList<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int sum=0;
        //듣도 못한 사람
        for(int i = 0; i < N; i++) {
        	String name= br.readLine();
        	set.add(name);
        }
        
        //보도 못한사람
        for(int i = 0; i < M; i++) {
        	String name=br.readLine();
        	if(set.contains(name)) {
        		sum++;
        		list.add(name);
        	}
        }
        Collections.sort(list);
        for(int i = 0; i<list.size();i++) {
        	sb.append(list.get(i)+"\n");
        }
        System.out.println(sum);
        System.out.println(sb);
        
        //자원반납
        br.close();
	}

}
