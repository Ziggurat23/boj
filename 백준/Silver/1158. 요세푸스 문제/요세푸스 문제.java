import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class Main {
//요세푸스 문제
static LinkedList<Integer> list;
static ListIterator<Integer> iter;
static BufferedWriter  bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		bw = new BufferedWriter(new OutputStreamWriter(System.out));  

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new LinkedList<Integer>();
		iter = list.listIterator();
        bw.write("<");
		LL(N, M, iter);
        bw.write(">");

		//자원 반납
		bw.flush();
		bw.close();
		br.close();

	}
    public static void LL(int N,int M, ListIterator<Integer> iter) throws IOException {
    	for(int i = 1 ; i<=N;i++) {
    		iter.add(i);
    	}
    	for(int i = 0 ; i<N;i++) {
    		for(int j = 0 ; j < M-1 ; j++) {
    			if(iter.hasNext()) {
    				iter.next();
    			} else {
    				iter = list.listIterator();
    				iter.next();
    			}
    		}
    		
            if (!iter.hasNext()) {
            	iter = list.listIterator();
            }
            bw.write(iter.next().toString());
            iter.remove();
            if (list.size() > 0) bw.write(", ");
    		

    	}
    }
}
