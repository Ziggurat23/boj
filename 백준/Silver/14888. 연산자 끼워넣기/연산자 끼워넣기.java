import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
//연산자 끼워넣기
	
	static int N;
	static int count;
	static int[] numbers;
	static int[] operator;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		//선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());

        

        numbers = new int[N];
        operator = new int[4];

        // 숫자
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }


        intoOperator(0, numbers[0]);

        //자원반납
        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void intoOperator(int depth, int currentValue) {
        if (depth == N - 1) {
            max = Math.max(max, currentValue);
            min = Math.min(min, currentValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
        	//연산자를 쓸어내면서 찾기
            if (operator[i] > 0) {
                operator[i]--;
                
                switch (i) {
                    case 0: intoOperator(depth + 1, currentValue + numbers[depth + 1]); break; // 덧셈
                    case 1: intoOperator(depth + 1, currentValue - numbers[depth + 1]); break; // 뺄셈
                    case 2: intoOperator(depth + 1, currentValue * numbers[depth + 1]); break; // 곱셈
                    case 3: intoOperator(depth + 1, currentValue / numbers[depth + 1]); break; // 나눗셈
                }
                //백트래킹 원복
                operator[i]++;
            }
        }
    }
}