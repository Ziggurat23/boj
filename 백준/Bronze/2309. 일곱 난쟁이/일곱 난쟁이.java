import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
//일곱난쟁이
static int sum;
static int[] dwarf;
static int[] ninePeople;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        ninePeople = new int[9];
        dwarf = new int[7];
        sum=0;
        for(int i=0;i<9;i++) {
        	ninePeople[i]=Integer.parseInt(br.readLine());
        }
        sum100(0,0);
        //자원반납
        bw.flush();
        bw.close();
        br.close();
	}
	
	public static void sum100(int start,int depth) {
		//목표값 도달
		if(sum==100 && depth==7) {
			Arrays.sort(dwarf);
			for(int i=0;i<7;i++) {
				System.out.println(dwarf[i]);
			}
			System.exit(0);
		} else if(depth>=7) {
			return;
		}
		
		for(int i=start;i<ninePeople.length;i++) {
			dwarf[depth]=ninePeople[i];
			sum+=ninePeople[i];
			
			sum100(start+1,depth+1);
			//백트래킹
			sum-=ninePeople[i];
			dwarf[depth]=0;
		}
		
	}

} 
