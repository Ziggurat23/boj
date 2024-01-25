package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2720 {
//세탁소 사장 동혁
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int iter = Integer.parseInt(br.readLine());
        int quarter[] = new int[iter]  ;
        int dime[] = new int[iter]  ;
        int nickel[] = new int[iter]  ;
        int penny[] = new int[iter]  ;
        for(int i=0;i<iter;i++) {
        	int cash=Integer.parseInt(br.readLine());
        	quarter[i]=cash/25;
        	cash-=quarter[i]*25;
        	
        	dime[i]=cash/10;
        	cash-=dime[i]*10;
        	
        	nickel[i]=cash/5;
        	cash-=nickel[i]*5;
        	
        	penny[i]=cash/1;

        }
        for(int i=0;i<iter;i++) {
        	System.out.print(quarter[i]+" ");
        	System.out.print(dime[i]+" ");
        	System.out.print(nickel[i]+" ");
        	System.out.print(penny[i]+"\n");
        }
        

        
        




        bw.flush();
        bw.close();
        br.close();
	}

}
