package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class User {
    int age;
    String name;
    int order; // 입력 순서를 나타내는 필드

    User(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }
}

public class P10814 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            userList.add(new User(age, name, i));
        }

        // 나이를 기준으로 정렬하되, 나이가 같을 경우 입력 순서(order)를 기준으로 정렬
        Collections.sort(userList, (u1, u2) -> {
            if (u1.age == u2.age) {
                return u1.order - u2.order;
            }
            return u1.age - u2.age;
        });

        StringBuilder sb = new StringBuilder();
        for (User user : userList) {
            sb.append(user.age).append(" ").append(user.name).append("\n");
        }

        System.out.print(sb.toString());
    }
}
