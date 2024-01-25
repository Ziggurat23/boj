package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P7785 {
//회사에 있는 사람
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        HashSet<String> set= new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        //출근 퇴근 체크
        for(int i = 0 ;i < N; i ++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String name= st.nextToken();
        	String enter= st.nextToken();
        	if (enter.equals("enter")) {
        		set.add(name);
        	} else {
        		set.remove(name);
        	}
        }
        //set을 list에 담아서 역순으로
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder() );
        for(String str:list) {
        	sb.append(str + "\n");
        }
        System.out.println(sb);
        //자원반납
        br.close();
	}

}
