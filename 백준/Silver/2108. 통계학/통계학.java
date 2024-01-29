import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
//통계학
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int [] arr= new int[N];
        for(int i=0;i<N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        sort(arr);
        bw.write(String.valueOf(findAvg(arr))+"\n");
        bw.write(String.valueOf(findMiddle(arr))+"\n");
        bw.write(String.valueOf(findMode(arr))+"\n");
        bw.write(String.valueOf(findRange(arr))+"\n");
        
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}
	
	//배열 정렬
	public static void sort(int[] arr) {
		Arrays.sort(arr);
	}
	
	//산술평균
	public static int findAvg(int[] arr) {
		double avg=0;
		double sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		avg=sum/arr.length;
		
		return (int)Math.round(avg);
	}
	
	//중앙값 구하기
	public static int findMiddle(int[] arr) {
		int middle=0;
		middle=arr[arr.length/2];
		return middle;
	}
		
	//최빈수 두번째 작은 값 구하기
	public static int findMode(int[] arr) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for(int num : arr) {
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }

	    int maxCount = 0;
	    for(int count : map.values()) {
	        if(count > maxCount) {
	            maxCount = count;
	        }
	    }

	    ArrayList<Integer> modes = new ArrayList<>();
	    for(Entry<Integer, Integer> entry : map.entrySet()) {
	        if(entry.getValue() == maxCount) {
	            modes.add(entry.getKey());
	        }
	    }

	    Collections.sort(modes);
	    return modes.size() > 1 ? modes.get(1) : modes.get(0);
	}
		
	//범위
	public static int findRange(int[] arr) {
		int range=0;
		range=arr[arr.length-1]-arr[0];
		return range;
	}
	
		

}
