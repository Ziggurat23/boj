package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11650 {
//좌표 정렬하기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
		
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x != p2.x) {
                    return p1.x - p2.x;
                } else {
                    return p1.y - p2.y;
                }
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }
        System.out.println(sb);

	}
	
	static class Point {
	    int x;
	    int y;

	    Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}

}
