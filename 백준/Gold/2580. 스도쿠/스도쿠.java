import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
// 스도쿠
	static int[][] sudoku;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sudoku = new int[9][9];
        
        for(int i=0;i<9;i++) {
        	StringTokenizer st= new StringTokenizer(br.readLine());
        	for(int j=0;j<9;j++) {
        		sudoku[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        sol(0);
        
        for(int i=0;i<9;i++) {
        	for(int j=0;j<9;j++) {
        		bw.write(sudoku[i][j]+" ");
        	}
        	bw.write("\n");
        }
        
        //자원반납
        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean sol(int depth) {
        if (depth == 81) { 
            return true;
        }

        int row = depth / 9;
        int col = depth % 9;

        if (sudoku[row][col] != 0) { // 이미 숫자가 채워진 셀
            return sol(depth + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!isDuplicate(row, col, i)) {
                    sudoku[row][col] = i;
                    if (sol(depth + 1)) {
                        return true;
                    }
                    sudoku[row][col] = 0; // 백트래킹
                }
            }
        }
        return false; // 가능한 숫자가 없음, 이전 단계로 돌아가야 함
    }

    

    private static boolean isDuplicate(int x, int y, int num) {
        int three_square_x = (x / 3) * 3;
        int three_square_y = (y / 3) * 3;

        // 가로 검사
        for (int j = 0; j < 9; j++) {
            if (sudoku[j][y] == num) {
                return true;
            }
        }

        // 세로 검사
        for (int j = 0; j < 9; j++) {
            if (sudoku[x][j] == num) {
                return true;
            }
        }

        // 3x3 서브그리드 검사
        for (int j = three_square_x; j < three_square_x + 3; j++) {
            for (int k = three_square_y; k < three_square_y + 3; k++) {
                if (sudoku[j][k] == num) {
                    return true;
                }
            }
        }

        return false;
    }

}
