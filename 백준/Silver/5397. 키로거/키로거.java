import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;


public class Main {
//키로거
static LinkedList<Character> list;
static ListIterator<Character> iter;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
		

		
		int M = Integer.parseInt(br.readLine());
		//배열에 넣기
		for (int i = 0 ; i<M ; i++) {
			list = new LinkedList<Character>();
			iter = list.listIterator();
			String str= br.readLine();
	        
	        //명령어
	        char[] order = str.toCharArray();
	        for(char c : order) {
	        	LL(c,iter);
	        }
	        
	        //출력
	        for (char c : list) {
	            bw.write(c);
	        }
	        bw.write("\n");
	        
		}
		



		//자원 반납
		bw.flush();
		bw.close();
		br.close();

	}
    public static void LL(char c, ListIterator<Character> iter) {
        switch (c) {
        case '<':
            if (iter.hasPrevious()) {
                iter.previous();
            }
            break;
        case '>':
            if (iter.hasNext()) {
                iter.next();
            }
            break;
        case '-':
        	if (iter.hasPrevious()) {
        	    iter.previous(); 
        	    iter.remove();
        	}
            break;
        default:
            iter.add(c);
            break;
        }
    }

}
