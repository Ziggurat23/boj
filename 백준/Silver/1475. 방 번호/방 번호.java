import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
//방 번호
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int[] arr = new int[10];
    	int num = Integer.parseInt(br.readLine());
    	int max = 0;
    	
    	for(char c:String.valueOf(num).toCharArray()) {

    		arr[c-'0']+=1;
    	}
    	arr[6]=(int)Math.ceil((arr[6]+arr[9])/2.0);
    	arr[9]=0;
    	
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i]>max) {
    			max=arr[i];
    		}
    	}
    	bw.write(String.valueOf(max));
    	
    	
    	//자원반납
    	bw.flush();
    	bw.close();
    	br.close();

	}

}
