
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
// 텀 프로젝트 
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       // 테스트 케이스의 개수를 입력받음
       int T = Integer.parseInt(br.readLine());
       
       // 각 테스트 케이스에 대해 반복 수행
       for (int t = 0; t < T; t++) {
           // 학생의 수를 입력받음
           int N = Integer.parseInt(br.readLine());
           
           // 각 학생이 선택한 학생의 번호를 저장할 배열 (0번 인덱스는 사용하지 않음)
           int[] stdt = new int[N + 1];
           
           // 학생들이 선택한 학생의 번호를 입력받아 배열에 저장
           StringTokenizer st = new StringTokenizer(br.readLine());
           for (int i = 1; i <= N; i++) {
               stdt[i] = Integer.parseInt(st.nextToken());
           }
           
           // 각 학생의 방문 여부를 저장할 배열 (0번 인덱스는 사용하지 않음)
           boolean[] visited = new boolean[N + 1];
           
           // 각 학생이 팀에 속해있는지 여부를 저장할 배열 (0번 인덱스는 사용하지 않음)
           boolean[] inTeam = new boolean[N + 1];
           
           // 팀에 속한 학생의 수를 저장할 변수
           int count = 0;
           
           // 모든 학생에 대해 DFS 탐색 수행
           for (int i = 1; i <= N; i++) {
               // 아직 방문하지 않은 학생인 경우에만 DFS 탐색 수행
               if (!visited[i]) {
                   // DFS 탐색을 통해 팀에 속한 학생의 수를 계산하여 count에 더함
                   count += dfs(i, stdt, visited, inTeam);
               }
           }
           
           // 전체 학생 수에서 팀에 속한 학생 수를 빼서 팀에 속하지 않은 학생 수를 계산하여 출력
           bw.write((N - count) + "\n");
       }
       
       // 버퍼 플러시 및 자원 반납
       bw.flush();
       bw.close();
       br.close();
   }
   
   // DFS 탐색을 수행하여 팀에 속한 학생의 수를 계산하는 메서드
   public static int dfs(int cur, int[] stdt, boolean[] visited, boolean[] inTeam) {
       // 현재 학생이 이미 방문한 경우
       if (visited[cur]) {
           // 현재 학생이 아직 팀에 속하지 않은 경우 (사이클 발견)
           if (!inTeam[cur]) {
               // 사이클에 속한 학생의 수를 저장할 변수
               int count = 0;
               
               // 사이클을 따라가면서 팀에 속한 학생의 수를 계산
               for (int i = cur; !inTeam[i]; i = stdt[i]) {
                   inTeam[i] = true; // 학생을 팀에 속한 것으로 표시
                   count++; // 팀에 속한 학생의 수 증가
               }
               
               // 사이클에 속한 학생의 수 반환
               return count;
           }
           
           // 현재 학생이 이미 팀에 속한 경우 0 반환
           return 0;
       }
       
       // 현재 학생을 방문 처리
       visited[cur] = true;
       // 다음 학생으로 DFS 탐색 수행
       int count = dfs(stdt[cur], stdt, visited, inTeam);
       // 현재 노드를 팀에 포함시킴
       inTeam[cur] = true;
       // 반환
       return count;
   }
}