package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class P1181 {
//단어 정렬
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<N;i++) {
        	set.add(br.readLine());
        }
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이비교
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                // ABC순으로
                return s1.compareTo(s2);
            }
        });
        //출력
        for(int i =0;i<list.size();i++) {
        	System.out.println(list.get(i));
        }
        //자원반납
        br.close();
	}

}
