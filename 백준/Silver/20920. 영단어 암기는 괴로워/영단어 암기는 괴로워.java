import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Main {
//영단어 암기는 괴로워
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 빈도수
                int numCompare = map.get(o2).compareTo(map.get(o1));
                if (numCompare != 0) return numCompare;

                // 길이
                int lengthCompare = Integer.compare(o2.length(), o1.length());
                if (lengthCompare != 0) return lengthCompare;
                
                // 알파벳 순서대로 정렬
                return o1.compareTo(o2);
            }
        });
        for (String word : list) {
            bw.write(word + "\n");
        }
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}
	
	//최빈수 구하기
	public static String findMode(String[] strArr) {
	    Map<String, Integer> map = new HashMap<>();
	    for(String s : strArr) {
	        map.put(s, map.getOrDefault(s, 0) + 1);
	    }

	    int maxCount = 0;
	    String mode = null;
	    for(Entry<String, Integer> E: map.entrySet()) {
	        if(E.getValue() > maxCount) {
	            maxCount = E.getValue();
	            mode=E.getKey();
	        }
	    }
	    return mode;
	    
	}
}
