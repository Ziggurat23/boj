package boj;

import java.util.Scanner;
import java.util.ArrayList;

//배열 클래스
class IntegerPair {
    private int price;
    private int quantity;
    
    // 생성자
    public IntegerPair() {}
    public IntegerPair(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }
    
    // getter와 setter 메서드
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

public class P25304 {
//영수증
	

	

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		long X = sc.nextLong();
		int N = sc.nextInt();
		long sum = 0;
		ArrayList<IntegerPair> list = new ArrayList<IntegerPair>();
		for(int i=0;i<N;i++) {
			
			int price = sc.nextInt();
			int quantity = sc.nextInt();
			IntegerPair goods= new IntegerPair(price, quantity);
			list.add(goods);
		}
		
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i).getPrice()*list.get(i).getQuantity();
		}

		if (sum==X) {
			System.out.println("Yes");
		} else {
			System.out.println("No");			
		}
	}

}
