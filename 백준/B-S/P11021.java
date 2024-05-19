package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11021 {
// A+B - 7
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   //할당된 버퍼에 값 넣어주기
		
		
		int caseNum = Integer.parseInt(br.readLine()); //Int
		int result;
		for (int i=0;i<caseNum;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // 각 줄마다 새로운 StringTokennizer 생성 , 공백으로 문자열 분리시키기
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			result = A + B;
			bw.write("Case #"+(i+1)+": "+result+"\n");
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
	}
}
