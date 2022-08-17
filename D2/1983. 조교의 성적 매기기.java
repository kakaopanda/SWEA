import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		// System.setIn(new FileInputStream("src/input.txt"));
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		for(int i=0; i<testcase; i++) {
			int n = s.nextInt(); // 학생 수, 항상 10의 배수이다.
			if(n<10 || n>100)
				return;
			int iter = (int)(n/10); // 성적 배분시, 반복을 수행할 횟수를 학생 수에 기반하여 계산한다.
			int k = s.nextInt(); // 학점을 알고 싶은 학생의 번호
			Person student[] = new Person[n];
			// System.out.println("n , k"+" "+n+" "+k);
			for(int j=0; j<n; j++) { // 학생들의 시험 성적을 배열에 기록한다.
				int number = (j+1); // 학생의 번호
				int middle_exam = s.nextInt(); // 중간고사 점수(35%)
				int final_exam = s.nextInt(); // 기말고사 점수(45%)
				int assignment = s.nextInt(); // 과제 점수(20%)
				double score = middle_exam*0.35 + final_exam*0.45 + assignment*0.20;
				student[j] = new Person(number,middle_exam,final_exam,assignment,score,"");
			}
			Arrays.sort(student, Collections.reverseOrder()); // 학생들의 시험 성적을 내림차순(높은 순서)으로 정렬한다.
			int index = 0; // 등급을 기록할 번호
			for(int j=index; j<iter; j++, index++) { // 최종 성적에 따른 학점을 부여한다.
				student[j].grade="A+";
			}
			for(int j=index; j<iter*2; j++, index++) { // 최종 성적에 따른 학점을 부여한다.
				student[j].grade="A0";
			}
			for(int j=index; j<iter*3; j++, index++) { // 최종 성적에 따른 학점을 부여한다.
				student[j].grade="A-";
			}
			for(int j=index; j<iter*4; j++, index++) { // 최종 성적에 따른 학점을 부여한다.
				student[j].grade="B+";
			}
			for(int j=index; j<iter*5; j++, index++) { // 최종 성적에 따른 학점을 부여한다.
				student[j].grade="B0";
			}
			for(int j=index; j<iter*6; j++, index++) { // 최종 성적에 따른 학점을 부여한다.
				student[j].grade="B-";
			}
			for(int j=index; j<iter*7; j++, index++) { // 최종 성적에 따른 학점을 부여한다.
				student[j].grade="C+";
			}
			for(int j=index; j<iter*8; j++, index++) { // 최종 성적에 따른 학점을 부여한다.
				student[j].grade="C0";
			}
			for(int j=index; j<iter*9; j++, index++) { // 최종 성적에 따른 학점을 부여한다.
				student[j].grade="C-";
			}
			for(int j=index; j<iter*10; j++, index++) { // 최종 성적에 따른 학점을 부여한다.
				student[j].grade="D0";
			}
			int student_index = 0; // 학점을 알고 싶은 학생의 인덱스
			for(int j=0; j<n; j++) {
				if(student[j].number==k)
					student_index = j;
			}
			/*
			 * 학생들이 성적순으로 내림차순 정렬되어있는지 확인한다.
			for(int j=0; j<n; j++) {
				System.out.println(student[j].score);
			}
			*/
			System.out.println("#"+(i+1)+" "+student[student_index].grade);
		}
	}
}

class Person implements Comparable<Person>{
	int number, middle_exam, final_exam, assignment;
	double score;
	String grade;
	Person(int number, int middle_exam, int final_exam, int assignment, double score, String grade){
		this.number = number;
		this.middle_exam = middle_exam;
		this.final_exam = final_exam;
		this.assignment = assignment;
		this.score = score;
		this.grade = grade;
	}
	@Override
	public int compareTo(Person p) {
		if(Double.compare(this.score, p.score)==0)
			return 0;
		else if(Double.compare(this.score, p.score)==1)
			return 1;
		else
			return -1;
		
		// 각 학생들의 최종 성적(score)간 비교를 int형으로 수행하게 되면 데이터 손실로 인해 정확한 비교가 어려워진다. 
		// return (int)(this.score - p.score);
	}
}