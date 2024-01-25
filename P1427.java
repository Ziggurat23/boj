package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P1427 {
//소트인사이드
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String N = br.readLine();
        char[] charList = N.toCharArray();
        Arrays.sort(charList);
        for(int i=charList.length-1;i>=0;i--) {
        	sb.append(charList[i]);
        }
        System.out.println(sb);
	}

}
