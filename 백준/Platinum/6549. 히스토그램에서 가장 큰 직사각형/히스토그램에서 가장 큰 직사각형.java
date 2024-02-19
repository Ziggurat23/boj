import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
// 히스토그램에서 가장 큰 직사각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            
            if(N == 0) break; 
            
            long[] heights = new long[N]; // 막대의 높이를 저장할 배열
            for(int i = 0; i < N; i++) {
                heights[i] = Long.parseLong(st.nextToken()); // 각 막대의 높이 입력 받기
            }
            
            Stack<Integer> stack = new Stack<>(); // 인덱스를 저장할 스택
            long maxArea = 0; // 최대 면적을 저장할 변수
            
            for(int i = 0; i < N; i++) {
                // 스택이 비어있지 않고 현재 막대의 높이가 스택의 맨 위 막대의 높이보다 작을 때까지 반복
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    long height = heights[stack.pop()]; // 스택에서 막대를 제거하고 높이 가져오기
                    long width = stack.isEmpty() ? i : i - stack.peek() - 1; // 너비 계산
                    //만약 스택이 비어있다면 지금의 막대는 가장 작은 막대이므로 너비는 i
                    //비어있지않다면 스택 제일 위에서 인덱스를 뽑아와서 i에서 인덱스만큼 감소하는 계산
                    maxArea = Math.max(maxArea, height * width); // 최대 면적 갱신
                }
                stack.push(i); // 현재 막대의 인덱스를 스택에 삽입
            }
            
            // 스택에 남은 모든 막대를 처리
            while(!stack.isEmpty()) {
                long height = heights[stack.pop()]; // 스택에서 막대를 제거하고 높이를 가져오기
                long width = stack.isEmpty() ? N : N - stack.peek() - 1; // 너비 계산
                maxArea = Math.max(maxArea, height * width); // 최대 면적 갱신
            }
            
            bw.write(maxArea + "\n"); // 계산된 최대 면적을 출력
        }
        //자원 반납
        bw.flush(); 
        bw.close(); 
        br.close(); 
    }
}
