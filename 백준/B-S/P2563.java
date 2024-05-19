package boj;



import java.util.ArrayList;
import java.util.Scanner;

public class P2563 {
// 색종이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int iter= sc.nextInt();
        int sum=0;
        
        // 100 x 100 배열 만듬
        for (int i = 0; i < 100; i++) {

            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < 100; j++) {
            	list.add(0);
            }

            // charList를 lists에 추가
            lists.add(list);
        }
        
        // 색종이 색칠
        for(int i=0;i<iter;i++) {
        	int x=sc.nextInt();
        	int y=sc.nextInt();
	        for(int j=x;j<x+10;j++) {
	        	for(int k=y;k<y+10;k++) {
	        		lists.get(j).set(k, 1);
	        	}
	        }
        }
        
        // 넓이 구하기
        for (int i = 0; i < 100; i++) {
        	

            for (int j = 0; j < 100; j++) {
            	sum+=lists.get(i).get(j);
            }
        }
        
//        printTwoDArrayList(lists);
        System.out.println(sum);
        sc.close();
    }
    
    // 2차원 ArrayList 출력 메소드
    public static void printTwoDArrayList(ArrayList<ArrayList<Integer>> list) {
        for (ArrayList<Integer> row : list) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}