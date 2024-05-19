package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2751 {
//수 정렬하기 2
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list= new ArrayList<Integer>();
        int N = sc.nextInt();
        for(int i = 0 ; i < N ; i ++) {
        	list.add(sc.nextInt());
        }
        Collections.sort(list);
		for(Integer c : list) {
			bw.write(c + "\n");
		}
		bw.flush();
		bw.close();
        //자원반납
        sc.close();
	}

}
