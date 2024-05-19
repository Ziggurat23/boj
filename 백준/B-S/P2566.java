package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class P2566 {
//최댓값
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max=0;
        int maxRow=0;
        int maxCol=0;

        
        // 첫번째 행렬
        ArrayList<ArrayList<Integer>> twoDArrayList1 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                row.add(sc.nextInt()); 
            }
            twoDArrayList1.add(row);
        }
        
        // 순회
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            	if(max<=twoDArrayList1.get(i).get(j)) {
            		max=twoDArrayList1.get(i).get(j);
            		maxRow=i+1;
            		maxCol=j+1;
            	}
            }
        }
        System.out.println(max);
        System.out.print(maxRow+" ");
        System.out.print(maxCol);
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
