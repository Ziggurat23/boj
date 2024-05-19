package boj;

import java.util.Scanner;

public class P2941 {
//크로아티아 알파벳
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int strLength=str.length();
		for(int i=0;i<str.length();i++) {

			switch (String.valueOf(str.charAt(i))) {
				case "c":
					if(i + 1 < str.length() && String.valueOf(str.charAt(i+1)).equals("=") || i + 1 < str.length() &&String.valueOf(str.charAt(i+1)).equals("-")) {
						strLength--;
					}
					break;
				case "d":
					if(i + 1 < str.length() &&String.valueOf(str.charAt(i+1)).equals("-") || 
					i + 2 < str.length() &&String.valueOf(str.charAt(i+1)).equals("z") && String.valueOf(str.charAt(i+2)).equals("=")) {
						strLength--;
					}
					break;
				case "l":
					
					if(i + 1 < str.length() &&String.valueOf(str.charAt(i+1)).equals("j")){
						strLength--;
					}
					break;
				case "n":
					if(i + 1 < str.length() &&String.valueOf(str.charAt(i+1)).equals("j"))  {
						strLength--;
					}
					break;
				case "s":
					if(i + 1 < str.length() &&String.valueOf(str.charAt(i+1)).equals("="))  {
						strLength--;
					}
					break;
				case "z":
					if(i + 1 < str.length() &&String.valueOf(str.charAt(i+1)).equals("="))  {
						strLength--;
					}
					break;
			}
			
		}
		
		System.out.println(strLength);
		
	}

}
