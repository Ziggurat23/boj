import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Stack;



public class Main {
//옥상 정원 꾸미기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long sum = 0; 

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }

            sum += stack.size();
            stack.push(height);
        }

        bw.write(sum + "\n");
        //자원반납
        bw.flush();
        bw.close();
        br.close();
        
    }

}