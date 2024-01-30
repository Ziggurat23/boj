import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int count; 
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        count=0;
        hanoi(N, 1, 3, 2);
        
        bw.write(count+"\n");
        bw.write(sb.toString());
        //자원반납
        bw.flush();
        bw.close();
        br.close();
    }

    public static void hanoi(int diskOnTower, int from, int to, int via) {
        if (diskOnTower == 1) {
            sb.append(from+" "+to+"\n");
            count++;

        } else {
            hanoi(diskOnTower - 1, from, via, to);
            sb.append(from+" "+to+"\n");
            count++;

            hanoi(diskOnTower - 1, via, to, from);
            
        }
    }
}
