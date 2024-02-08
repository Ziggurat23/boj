
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;


public class Main {
static LinkedList<Character> list;
static ListIterator<Character> iter;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
		
		String str= br.readLine();
		list = new LinkedList<Character>();
		iter = list.listIterator();
		
		int M = Integer.parseInt(br.readLine());
		//배열에 넣기
        for (char c : str.toCharArray()) {
            iter.add(c);
        }
        //명령어
        for (int i = 0 ; i<M ; i++) {
        	LL(br.readLine());
        }
        //출력
        for (char c : list) {
            bw.write(c);
        }

		//자원 반납
		bw.flush();
		bw.close();
		br.close();

	}
	public static void LL(String order){

        switch (order.charAt(0)) {
        case 'L':
            if (iter.hasPrevious()) {
                iter.previous();
            }
            break;
        case 'D':
            if (iter.hasNext()) {
                iter.next();
            }
            break;
        case 'B':
            if (iter.hasPrevious()) {
                iter.previous();
                iter.remove();
            }
            break;
        case 'P':
            char c = order.charAt(2);
            iter.add(c);
            break;
    }
	}

}
