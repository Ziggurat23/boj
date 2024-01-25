package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P10815 {
//숫자 카드
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set= new HashSet<Integer>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < N; i++) {
        	int numOfN = Integer.parseInt(st.nextToken());
        	set.add(numOfN);
        }
        //비교해야할 숫자
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
        	int sum=0;	
        	int numOfM = Integer.parseInt(st.nextToken());
        	//비교
    		if(set.contains(numOfM)) {
    			sum+=1;
    		} 

        	
        	if(sum>=1) {
    			sb.append("1 ");
    		} else {
    			sb.append("0 ");
    		}
        }
        System.out.println(sb);
        
        //자원반납
        br.close();
	}

}
