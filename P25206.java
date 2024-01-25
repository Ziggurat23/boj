package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class P25206 {
//너의 평점은
	public static void main(String[] args) {
		// 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
		Scanner sc= new Scanner(System.in);
		ArrayList<String> subject = new ArrayList<String>();
		ArrayList<Double> grade = new ArrayList<Double>();
		ArrayList<Double> subjectGrade = new ArrayList<Double>();
		Double gradeSum=0.0;
		Double subjectGradeSum=0.0;
		for(int i=0;i<20;i++) {
			subject.add(sc.next());
			grade.add(sc.nextDouble());
			switch (sc.next()) {
			case "A+":
				subjectGrade.add(4.5);
				break;
			case "A0":
				subjectGrade.add(4.0);
				break;
			case "B+":
				subjectGrade.add(3.5);
				break;
			case "B0":
				subjectGrade.add(3.0);
				break;
			case "C+":
				subjectGrade.add(2.5);
				break;
			case "C0":
				subjectGrade.add(2.0);
				break;
			case "D+":
				subjectGrade.add(1.5);
				break;
			case "D0+":
				subjectGrade.add(1.0);
				break;
			case "F":
				subjectGrade.add(0.0);
				break;
			case "P":
				subjectGrade.add(null);
				break;
			default:
				break;
			}

		}
		
		for(int i=0;i<grade.size();i++) {
			if (subjectGrade.get(i)!=null) {
				gradeSum+=grade.get(i);
				subjectGradeSum=subjectGrade.get(i);
			}
			
		}
		
	}

	

}
