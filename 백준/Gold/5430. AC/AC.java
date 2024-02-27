import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
//AC
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

 
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
        	boolean reverseFlag = false;
            Deque<Integer> deque = new ArrayDeque<Integer>();
        	String command =br.readLine();
        	
        	//행렬 크기인데 굳이 필요는 없을 것 같음.
        	int M = Integer.parseInt(br.readLine());
        	int errorFlag = 0;
        	String arr = br.readLine();

            // 입력 문자열의 시작과 끝의 대괄호([])를 제거
            arr = arr.substring(1, arr.length() - 1);

            // arr가 빈 문자열이 아닐 때만 숫자를 리스트에 추가
            if (!arr.isEmpty()) {
                String[] numbers = arr.split(",");
                for (String number : numbers) {
                    deque.add(Integer.parseInt(number.trim()));
                }
            }
            
            //명령 수행
            for(char c : command.toCharArray()) {
            	switch (c) {
				case 'R':
					reverseFlag = !reverseFlag;
                    break;
				case 'D':
					if(deque.isEmpty()) {
						errorFlag = 1;
						continue;
					} else {
						if(!reverseFlag) {
							deque.removeFirst();
						} else {
							deque.removeLast();
						}
							
					}
					break;

				default:
					break;
				}
            	if (errorFlag==1) {break;}
            }
            
	         // 출력
	        if (errorFlag!=1) {
	            bw.write("[");
	            while (!deque.isEmpty()) {
	                bw.write(reverseFlag ? String.valueOf(deque.pollLast()) : String.valueOf(deque.pollFirst()));
	                if (!deque.isEmpty()) {
	                    bw.write(",");
	                }
	            }
	            bw.write("]");
	        } else {
	            bw.write("error");
	        }
	        bw.write("\n");
        }
        //자원반납
        bw.flush();
        bw.close();
        br.close();

	}

}
