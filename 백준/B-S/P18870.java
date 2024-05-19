package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18870 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] original = new long[N];
        ArrayList<Long> sorted = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            original[i] = Long.parseLong(st.nextToken());
            sorted.add(original[i]);
        }

        // 정렬
        Collections.sort(sorted);
        
        // 매핑
        HashMap<Long, Integer> indexMap = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < sorted.size(); i++) {
            if (!indexMap.containsKey(sorted.get(i))) {
                indexMap.put(sorted.get(i), rank++);
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            sb.append(indexMap.get(original[i])+" ");
        }
        System.out.println(sb);
        //자원반납
        br.close();
	}
}
