package boj;

import java.util.Scanner;

public class P1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            if (isGroupWord(str)) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
    // 그룹체크 메소드
    public static boolean isGroupWord(String str) {
        boolean[] seen = new boolean[26]; //배열로 알파벳이 나왔는가 체크
        char last = ' '; // 마지막 체크 된 문자

        for (int j = 0; j < str.length(); j++) {
            char current = str.charAt(j);

            // 문자가 한번 건너뛰고 보인다면 그룹문자가 아니다.
            if (seen[current - 'a'] && last != current) {
                return false;
            }

            seen[current - 'a'] = true; // 문자 나왔는가의 여부
            last = current;
        }

        return true;
    }
    
}

