import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
//숫자의 개수
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int[] arr = new int[10];
    	int A = Integer.parseInt(br.readLine());
    	int B = Integer.parseInt(br.readLine());
    	int C = Integer.parseInt(br.readLine());
    	int sum= A*B*C;
    	
    	for(char c:String.valueOf(sum).toCharArray()) {

    		arr[c-'0']+=1;
    	}
    	
    	for (int count : arr) {
            bw.write(count + "\n");
        }
    	
    	//자원반납
    	bw.flush();
    	bw.close();
    	br.close();

	}

}
