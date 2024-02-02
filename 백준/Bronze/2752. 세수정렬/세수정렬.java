import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr=new int[3];
        for(int i= 0;i<arr.length;i++) {
        	arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bw.write(arr[0]+" "+arr[1]+" "+arr[2]);
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}

}
