
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
//알파벳 개수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		String str= br.readLine();
		int [] freq = new int [26];
		//다 소문자로
		str.toLowerCase();
		//순회
        for (char c : str.toCharArray()) {
        	freq[c - 'a']++;
        }

        // 빈도수 배열 출력
        for (int i = 0; i < freq.length; i++) {
            bw.write(freq[i]+" ");
        }
		
		//자원 반납
		bw.flush();
		bw.close();
		br.close();
	}
}
