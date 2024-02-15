import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
//오아시스 재결합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            int count = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                sum += stack.peek()[1];
                if (stack.peek()[0] == height) {
                    count += stack.peek()[1];
                }
                stack.pop();
            }

            if (!stack.isEmpty()) {
                sum += 1;
            }

            stack.push(new int[]{height, count});
        }

        bw.write(sum + "\n");
        //자원반납
        bw.flush();
        bw.close();
        br.close();
    }
}
