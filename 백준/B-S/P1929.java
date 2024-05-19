package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//소수 구하기
public class P1929 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(long i = N; i <= M; i++) {
            if (isPrime(i)) {
            	sb.append(i+"\n");
            }
        }
        
        //출력
        System.out.println(sb);
        
        //자원반납
        br.close();
    }



//소수판별 제곱근까지 체크
    private static boolean isPrime(long number) {
        if (number < 2) return false;
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
