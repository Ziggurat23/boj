import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
//홀수
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        int sum=0;
        for(int i=0;i<7;i++) {
        	int num=Integer.parseInt(br.readLine());
        	if(num%2==1) {
        		list.add(num);
        		sum+=num;
        	}

        }
        if(list.size()==0) {
        	bw.write("-1");
        } else {
        	bw.write(sum+"\n");
            bw.write(String.valueOf(Collections.min(list)));
        }
        
        
        
  

        //자원반납
        bw.flush();
        bw.close();
        br.close();

	}

}
