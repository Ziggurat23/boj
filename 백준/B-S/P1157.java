package boj;

import java.util.Scanner;

public class P1157 {
// 단어 공부
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();
        int maxIndex=0;
        int max=0;
        int maxNum=0;
        int[] frequency = new int[26]; // 알파벳 
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                frequency[c - 'a']++; // 아스키 코드를 이용해서 배열 인덱스를 구해서 빈도수 증가
            }
        }
        for(int i=0;i<frequency.length;i++){
        	if(max<=frequency[i] && frequency[i]!=0 ) {
        		maxIndex = i;
        		max = frequency[i];
        	}
        }
        for(int i=0;i<frequency.length;i++){
        	if(max==frequency[i]) {
        		maxNum++;
        	}
        }
        
        char letter = (char) ('A' + maxIndex);
        System.out.println(maxNum>=2?"?":letter);
        
	}
}
