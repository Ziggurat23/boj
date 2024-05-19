package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17103 {
//골드바흐 파티션
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); 
        int MAX = 1000000;

        // 에라토스테네스의 체를 사용한 소수 배열 생성
        boolean[] primeNumList = sieveOfEratosthenes(MAX);

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if(N % 2 != 0) {
                System.out.println("잘못된 입력");
                return;
            }

            int partitionCount = 0;
            // 골드바흐 파티션 찾기
            for(int j = 2; j <= N / 2; j++) {
                if(primeNumList[j] && primeNumList[N - j]) {
                    partitionCount++;
                }
            }
            sb.append(partitionCount).append("\n");
        }

        // 출력
        System.out.println(sb);

        // 자원 반납
        br.close();
    }

    // 에라토스테네스의 체
    private static boolean[] sieveOfEratosthenes(int maximum) {
        boolean[] prime = new boolean[maximum + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int p = 2; p * p <= maximum; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= maximum; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }
}
