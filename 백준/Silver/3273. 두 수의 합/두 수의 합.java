import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
//두 수의 합
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
    	int[] arr = new int[num];
    	int sol=0;
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0;i<num;i++) {
    		arr[i]=Integer.parseInt(st.nextToken());
    	}
    	// 목표합
    	int sum=Integer.parseInt(br.readLine());
    	int[] naturalNumbers= new int[sum];
    	for(int a:arr) {
    		if(sum>a) {
    			if(naturalNumbers[sum-a]==0) {
        			naturalNumbers[a]++;
        		} else {
        			sol++;
        			naturalNumbers[sum-a]++;
        		}	
    		}
    		
    	}
    	
    	bw.write(sol+" ");
    	//자원반납
    	bw.flush();
    	bw.close();
    	br.close();

	}

}
