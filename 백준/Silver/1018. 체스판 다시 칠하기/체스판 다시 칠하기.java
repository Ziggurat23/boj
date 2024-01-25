
import java.util.Scanner;

public class Main {
//체스판 다시 칠하기
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int sum=0;
        int min = Integer.MAX_VALUE;
        char[][] chessBoard= new char[N][M];
        //BWBW...
        for(int i = 0;i<N;i++) {
        	String str = sc.next();
        	for(int j = 0;j<M;j++) {
        		chessBoard[i][j] = str.charAt(j);
        	}
        }
        
        
        //덧칠하기
        for(int i = 0;i<=chessBoard.length-8;i++) {
        	for(int j = 0;j<=chessBoard[0].length-8;j++) {
        		min = Math.min(min,reapply(i,j,chessBoard));

        	}
            
        }
        System.out.println(min);
  
        
        sc.close();

	}
	
	public static int reapply(int row, int col, char[][] list) {
		int count=0;
		for (int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				int tmpRow = row+ i;
				int tmpCol = col + j;
				if((tmpRow+tmpCol)%2==0 && list[tmpRow][tmpCol]=='B') {
					count++;
				} else if((tmpRow+tmpCol)%2==1 && list[tmpRow][tmpCol]=='W') {
					count++;
				}
			}
		}
		return Math.min(count, 64-count);
	}

}
