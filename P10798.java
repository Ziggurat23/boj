package boj;



import java.util.ArrayList;
import java.util.Scanner;

public class P10798 {
    // 세로 읽기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Character>> lists = new ArrayList<>();

        // 5줄 입력 받음
        for (int i = 0; i < 5; i++) {
            String str = sc.next();
            ArrayList<Character> charList = new ArrayList<>();

            // 문자열의 각 문자를 charList에 추가
            for (int j = 0; j < str.length(); j++) {
                charList.add(str.charAt(j));
            }

            // charList를 lists에 추가
            lists.add(charList);
        }

        // 세로로 읽은 결과 출력
        for (int i = 0; i < 75; i++) { // 최대 15글자까지 처리
            for (ArrayList<Character> list : lists) {
                if (i < list.size()) {
                    System.out.print(list.get(i));
                }
            }
        }

        sc.close();
    }
}