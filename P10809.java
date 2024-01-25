package boj;


import java.util.ArrayList;
import java.util.Scanner;

public class P10809 {
//알파벳 찾기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String strEng = sc.next();
		
		String[] list= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		
			for(int j=0;j<list.length;j++) {
				System.out.print(strEng.indexOf(list[j])+" ");
			} 
		
	}

}
