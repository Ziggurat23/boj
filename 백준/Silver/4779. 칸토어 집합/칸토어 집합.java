import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
//칸토어 집합
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int N = Integer.parseInt(line);
            sb = new StringBuilder();
            for (int i = 0; i < Math.pow(3, N); i++) {
                sb.append("-");
            }
            cantor(0, (int) Math.pow(3, N), N);
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }

        bw.close();
        br.close();
    }

    public static void cantor(int start, int end, int depth) {
        if (depth == 0) {
            return;
        }

        int segmentLength = (end - start) / 3;
        int middleStart = start + segmentLength;
        int middleEnd = middleStart + segmentLength;

        for (int i = middleStart; i < middleEnd; i++) {
            sb.setCharAt(i, ' ');
        }

        cantor(start, middleStart, depth - 1);
        cantor(middleEnd, end, depth - 1);
    }
}
