import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
//애너그램 만들기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    	String str1 = br.readLine();
    	String str2 = br.readLine();
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
    	
    	bw.write(String.valueOf(charArr2.length+charArr1.length-correct*2));
        	
        
    	//자원반납
    	bw.flush();
    	bw.close();
    	br.close();

	}

}
