import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
//스택2
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int order = Integer.parseInt(input[0]);

            switch (order) {
                case 1:
                    // 스택에 넣기
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case 2:
                    // 정수를 빼내고 출력, 없으면 -1
                    bw.write((stack.isEmpty() ? -1 : stack.pop()) + "\n");
                    break;
                case 3:
                    // 스택 정수 갯수
                    bw.write(stack.size() + "\n");
                    break;
                case 4:
                    // 스택이 비어있으면 1, 아니면 0을 출력한다
                    bw.write((stack.isEmpty() ? 1 : 0) + "\n");
                    break;
                case 5:
                    // 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                    bw.write((stack.isEmpty() ? -1 : stack.peek()) + "\n");
                    break;
                default:
                    break;
            }
        }

        //자원반납
        br.close();
        bw.flush();
        bw.close();
    }
}