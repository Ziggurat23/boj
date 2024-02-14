import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
//스택 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); 
        
        int N = Integer.parseInt(br.readLine()); // 입력받을 수열의 길이
        int start = 0; // 스택에 push할 다음 숫자
        
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine()); // 수열의 다음 원소
            
            if (value > start) { // 현재 스택의 top보다 큰 경우
                for (int j = start + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append("+\n"); // push 연산 기록
                }
                start = value; // 다음 push할 숫자 업데이트
            } else if (stack.peek() != value) { // 스택의 top과 수열의 현재 원소가 다른 경우
                System.out.println("NO");
                return; // 해당 수열을 만들 수 없으므로 종료
            }
            
            stack.pop(); // 스택의 top이 수열의 현재 원소와 일치하므로 pop
            sb.append("-\n"); // pop 연산 기록
        }
        
        bw.write(sb.toString()); // 결과 출력
        //자원 반납
        bw.flush();
        bw.close();
        br.close();
    }
}
