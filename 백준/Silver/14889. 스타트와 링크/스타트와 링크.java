import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
//스타트와 링크
    static int[][] arr;
    static List<Integer> indexList;
    static int N;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열 크기
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        indexList = new ArrayList<>();

        // 배열 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀 조합 시작
        matrixSol(0, 0);

        // 결과 출력
        bw.write(minDiff + "\n");

        // 자원 반납
        bw.flush();
        bw.close();
        br.close();
    }

    public static void matrixSol(int depth, int start) {
        if (depth == N / 2) {
            // 능력치 차이 계산
            calculateDifference();
            return;
        }

        for (int i = start; i < N; i++) {
            indexList.add(i);
            matrixSol(depth + 1, i + 1);
            indexList.remove(indexList.size() - 1);
        }
    }

    public static void calculateDifference() {
    	int team1=0;
    	int team2=0;
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			if(indexList.contains(i) && indexList.contains(j) && i != j) {
        			team1+=arr[i][j];
        		} else if(!indexList.contains(i) && !indexList.contains(j) && i != j) {
        			team2+=arr[i][j];
        		}	
    		}
    	}
    	int diff = Math.abs(team1 - team2);
    	minDiff = Math.min(minDiff, diff);
    }
}
