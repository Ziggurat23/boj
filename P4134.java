package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//다음 소수
public class P4134 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        ArrayList <Long> list = new ArrayList<Long>() ;
        for(long i = 0; i < N; i++) {
            long startNum = Long.parseLong(br.readLine());
            long nextPrime = findNextPrime(startNum);
            list.add(nextPrime);
        }
        
        for(long L:list) {
        	System.out.println(L);
        }
        br.close();
    }

    private static long findNextPrime(long startNum) {
        for (long i = startNum; ; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

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
