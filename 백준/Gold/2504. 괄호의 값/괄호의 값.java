import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int multiplier = 1;
        boolean isValid = true;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            switch (ch) {
                case '(':
                    stack.push(ch);
                    multiplier *= 2;
                    break;
                case '[':
                    stack.push(ch);
                    multiplier *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    if (str.charAt(i - 1) == '(') {
                        sum += multiplier;
                    }
                    stack.pop();
                    multiplier /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    if (str.charAt(i - 1) == '[') {
                        sum += multiplier;
                    }
                    stack.pop();
                    multiplier /= 3;
                    break;
            }
            if (!isValid) {
                break;
            }
        }

        if (!stack.isEmpty()) {
            isValid = false;
        }

        bw.write(isValid ? String.valueOf(sum) : "0");
        bw.flush();
        bw.close();
        br.close();
    }
}
