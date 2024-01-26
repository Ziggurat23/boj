import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
//풍선 터뜨리기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 풍선의 점프 값을 저장할 배열
        int[] jumps = new int[N];
        for (int i = 0; i < N; i++) {
            jumps[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0; // 시작 위치
        for (int i = 0; i < N; i++) {
            int jump = jumps[index];
            jumps[index] = 0; // 현재 풍선 터뜨림 (점프 값을 0으로 설정)
            bw.write((index + 1) + " "); // 1-based index 출력

            if (i == N - 1) break; // 마지막 풍선이면 종료

            // 다음 풍선 위치로 이동
            int step = jump > 0 ? 1 : -1;
            while (jump != 0) {
                index = (index + step + N) % N; // 다음 위치
                if (jumps[index] != 0) { // 터지지 않은 풍선을 찾으면
                    jump += step > 0 ? -1 : 1; // 점프 횟수 감소
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
