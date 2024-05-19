package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class cdQuiz01 {
//사이냅소프트 코딩퀴즈01
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력받기
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int maxRange = Integer.parseInt(line.trim());
            int count = 0;
            int sum = 0;

            // 범위 내의 행복 수 계산
            for (int i = 1; i <= maxRange; i++) {
                if (happyCheck(i)) {
                    count++;
                    sum += i;
                }
            }

            // 결과 출력
            bw.write("1 ~ " + maxRange + " 범위의 행복 수는 " + count + "개이고 총합은 " + sum + "입니다.\n");
        }

        
        //자원반납
        bw.flush();
        bw.close();
        br.close();
		
        
	}
	
    public static boolean happyCheck(int number) {
        Set<Integer> loopDetection = new HashSet<>();
        while (number != 1 && !loopDetection.contains(number)) {
        	loopDetection.add(number);
            number = squaresSum(number);
        }
        return number == 1;
    }
    
    public static int squaresSum(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }
    
}
