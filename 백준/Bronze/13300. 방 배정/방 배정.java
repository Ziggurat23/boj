import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
//방 배정 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //학년
        int[][] arr=new int[2][7];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); 
        
        for(int i=0;i<N;i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st2.nextToken());
            int B = Integer.parseInt(st2.nextToken());
            arr[A][B]++;
        }
        
        int sum=0;
        for(int[] a:arr) {
        	for(int b :a) {
        		sum+=(int)Math.ceil((double)b/(double)K);
        	}
        }
        bw.write(sum+"\n");
    	//자원반납
    	bw.flush();
    	bw.close();
    	br.close();
	}

}
