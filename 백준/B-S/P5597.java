package boj;


import java.util.Scanner;

public class P5597 {
	
	public static void main(String[] args) {
		
		int[] a= new int[30];
		boolean same;
		for (int i=0;i<30;i++) {
			a[i]=i+1;
		}
		
		Scanner sc= new Scanner(System.in);
		for(int i=0;i<28;i++) {
			int stdtNum=sc.nextInt();
			for (int j=0;j<30;j++) {
				same = a[j]==stdtNum;
				if(same) {
					a[j]=0;
				}
			}
		}
		for (int i=0;i<30;i++) {
			if(a[i]!=0) {
				System.out.println(a[i]);
			}
		}
		
	}

}
