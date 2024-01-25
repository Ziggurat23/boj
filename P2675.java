package boj;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P2675 {
//알파벳 찾기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String splitStr;
		int iter;
		char splitC;
		Map<Integer, String> map = new HashMap<Integer, String>();
		ArrayList<Integer> listIter = new ArrayList<Integer>();
		ArrayList<String> listStr = new ArrayList<String>();
		for(int i=0;i<N;i++) {
			iter= sc.nextInt();
			String strEng = sc.next();
			listIter.add(iter);
			listStr.add(strEng);
		} 
		
		for (int i = 0; i < listStr.size(); i++) {
			
		    for (int j = 0; j< listStr.get(i).length(); j++) {
		    	splitC = listStr.get(i).charAt(j); // 문자열에서 i번째 문자를 꺼냄
		    	iter = listIter.get(i);
		    	for (int k = 0; k< iter; k++) {
			        // 여기에서 c를 사용합니다.
			        System.out.print(splitC);
			    }
		    }
		    System.out.print("\n"); //  줄바꿈
		    
		}
		sc.close();
	}

}
