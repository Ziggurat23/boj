import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        
        for(int i=0;i<num;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String str1 = st.nextToken();
        	String str2 = st.nextToken();
        	char[] charArr1 = str1.toCharArray();
        	char[] charArr2 = str2.toCharArray();
        	//문자 하나씩 맞나 확인
        	int correct=0;
        	for(char a:charArr1) {
        		for(int j=0;j<charArr2.length;j++) {
        			if(a==charArr2[j]) {
        				correct+=1;
        				charArr2[j]='0';
        				break;
        			}
        		}
        	}
        	
        	if(correct==charArr1.length && charArr1.length == charArr2.length ) {
        		bw.write("Possible\n");
        	} else {
        		bw.write("Impossible\n");
        	}
        	
        }
    	//자원반납
    	bw.flush();
    	bw.close();
    	br.close();

	}

}
