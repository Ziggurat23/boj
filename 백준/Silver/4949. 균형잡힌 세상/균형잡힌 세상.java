import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
//균형잡힌 세상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> stack = new ArrayDeque<>();

        while(true) {
            String str = br.readLine();
            if (str.equals(".")) { // 종료 조건
                break;
            }

            stack.clear(); 
            boolean isValid = true;

            for (char ch : str.toCharArray()) {
                if (ch == '(' || ch == '[' || ch=='{') {
                    stack.push(ch);
                } else if (ch == ')' || ch == ']' || ch=='}') {
                    if (stack.isEmpty() || (ch == ')' && stack.peek() != '(') || (ch == ']' && stack.peek() != '[')|| (ch == '}' && stack.peek() != '{')) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) { 
                isValid = false;
            }

            bw.write(isValid ? "yes\n" : "no\n");
        }
        //자원반환
        bw.flush();
        bw.close();
        br.close();
    }
}
