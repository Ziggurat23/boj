import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
//별 찍기 - 10
	static char[][] starGate;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        starGate= new char[N][N];
        for(int j=0;j<N;j++) {
        	for(int i=0;i<N;i++) {
        		starGate[i][j]='*';
        	}
        }
        printStar(0,N,0,N,N);
        for(int j=0;j<N;j++) {
        	for(int i=0;i<N;i++) {
        		bw.write(starGate[i][j]);
        	}
        	bw.write("\n");
        }
        	

        //자원반납 
        bw.flush();
        bw.close();
        br.close();
    }

    public static void printStar(int startX, int endX, int startY, int endY, int size) {
        if (size == 1) {
            return;
        }
        //i * (N + 1) + j

        int segmentLength = (endX - startX) / 3;
        int xStart = startX + segmentLength;
        int xEnd = xStart + segmentLength;
        
        int yStart = startY + segmentLength;
        int yEnd = yStart + segmentLength;
        
        for(int i=yStart;i<yEnd;i++) {
        	for(int j=xStart;j<xEnd;j++) {
        		starGate[i][j]=' ';
        	}
        }
        
        printStar(startX, xStart, startY, yStart, size/3);
        printStar(xStart, xEnd, startY, yStart, size/3);
        printStar(xEnd, endX, startY, yStart, size/3);
        printStar(startX, xStart, yStart, yEnd, size/3);

        printStar(xEnd, endX, yStart, yEnd, size/3);
        printStar(startX, xStart, yEnd, endY, size/3);
        printStar(xStart, xEnd, yEnd, endY, size/3);
        printStar(xEnd, endX, yEnd, endY, size/3);
    }

}
