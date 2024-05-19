package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
//나는야 포켓몬 마스터 이다솜
public class P1620 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        HashMap<Integer, String> numToNameMap = new HashMap<>();
        HashMap<String, Integer> nameToNumMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        // 사전 입력
        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            numToNameMap.put(i, name);
            nameToNumMap.put(name, i);
        }

        // 문제 입력
        for(int i = 0; i < M; i++) {
            String quest = br.readLine();
            if(nameToNumMap.containsKey(quest)) {
                // 이름으로 번호 검색
                sb.append(nameToNumMap.get(quest) + "\n");
            } else {
                // 번호로 이름 검색
                int num = Integer.parseInt(quest);
                sb.append(numToNameMap.get(num) + "\n");
            }
        }
        System.out.println(sb);
    }
}

