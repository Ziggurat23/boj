package boj;

import java.util.Scanner;
import java.util.ArrayList;
public class P2738 {
// 행렬 덧셈
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //행 열
        int rows = sc.nextInt();
        int columns = sc.nextInt();

        
        // 첫번째 행렬
        ArrayList<ArrayList<Integer>> twoDArrayList1 = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                row.add(sc.nextInt()); 
            }
            twoDArrayList1.add(row);
        }

        //두번째 행렬
        ArrayList<ArrayList<Integer>> twoDArrayList2 = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                row.add(sc.nextInt()); 
            }
            twoDArrayList2.add(row);
        }
 

        //계산된 행렬
        //행렬 생성
        ArrayList<ArrayList<Integer>> calcList = new ArrayList<>();
        for (int i = 0; i < twoDArrayList1.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < twoDArrayList2.get(0).size(); j++) {
                row.add(0); 
            }
            calcList.add(row);
        }
        //twoDArrayList1.get(x).get(y)
        //행렬 계산
        for (int i = 0; i < twoDArrayList1.size(); i++) {
            for (int j = 0; j < twoDArrayList1.get(i).size(); j++) {
                int sum = twoDArrayList1.get(i).get(j) + twoDArrayList2.get(i).get(j);
                calcList.get(i).set(j, sum);
            }
        }

        printTwoDArrayList(calcList);

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
