package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.StringTokenizer;

public class P1269 {
//대칭 차집합
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());

        
        // A 집합
        HashSet<Integer> A = new HashSet<Integer>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	int element = Integer.parseInt(st2.nextToken());
        	A.add(element);
        }
        
        // B 집합
        HashSet<Integer> B = new HashSet<Integer>();
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
        	int element = Integer.parseInt(st3.nextToken());
        	B.add(element);
        }
        
        //임시 집합
        HashSet<Integer> tmpSet = new HashSet<>(A);
        //차집합
        A.removeAll(B);
        B.removeAll(tmpSet);
        //출력
        System.out.println(A.size()+B.size());
        
        
        //자원반납
        br.close();

	}

}
