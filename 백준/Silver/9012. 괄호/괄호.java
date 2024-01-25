import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
//괄호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;

            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (stack.isEmpty()) {
                    isValid = false;
                    break;
                } else if(ch == ')'){
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            bw.write(isValid ? "YES\n" : "NO\n");
        }

        // 자원 반납
        bw.flush();
        bw.close();
        br.close();
    }
}
