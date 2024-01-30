import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
//N과 M (1)
	static int[] arr;
	static Set<Integer> set = new HashSet<>();
	static int N;
	static int M;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		//선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        backtrack(0);
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}
	
    static void backtrack(int depth) throws IOException {
        if (depth == M) {
            // 수열 출력
            for (int num : arr) {
            	bw.write(num+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                set.add(i); 
                //배열에 추가
                arr[depth] = i; 
                // 다음 숫자 찾기
                backtrack(depth + 1);
                // 백트래킹 = 가능성이 없으면 바로 스킵
                set.remove(i); 
            }
        }
    }
}
