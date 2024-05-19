package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P4948 {
//베르트랑 공준
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            long N = Long.parseLong(br.readLine());
            long sum=0;
            if(N==0) {
            	break;
            }
            for(long i = N+1; i <= 2*N; i++) {
                if (isPrime(i)) {
                	sum+=1;
                }
            }
            sb.append(sum+"\n");
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
