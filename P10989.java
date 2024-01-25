package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class P10989 {
//수 정렬하기 3
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N]; 
        for(int i = 0 ; i < N ; i ++) {
        	list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
		for(Integer c : list) {
			sb.append(c).append("\n");
		}
		System.out.println(sb);
        //자원반납
        br.close();
	}

}
