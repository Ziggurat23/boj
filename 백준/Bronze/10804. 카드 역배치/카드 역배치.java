import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
//카드 역배치
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        List<Integer> list =  new ArrayList<>();
        for(int i=1;i<=20;i++) {
        	list.add(i);
        }
        for(int i=0;i<10;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	Collections.reverse(list.subList(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));
        	
        }
        for(int a:list) {
        	bw.write(a+" ");
        }
        
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}
}
