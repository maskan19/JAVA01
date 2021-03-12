package e_oop.score;

public class Score {

	public static void main(String[] args) {
		Student[] students = new Student[10]; // 참조형 타입 - 기본값이 null이다

		// Student student = new Student(); -- 한명의 값만 계속 바꿈

		for (int i = 0; i < students.length; i++) {
			Student student = new Student();

			student.name = "학생" + (i + 1);
			student.rank = 1;
			student.kor = (int) (Math.random() * 101);
			student.eng = (int) (Math.random() * 101);
			student.math = (int) (Math.random() * 101);

			students[i] = student;
		}
		students[1].name = "";

		// 성적 관리 프로그램을 완성해주세요.

		System.out.println("\t국어\t영어\t수학\t합계\t평균\t석차");
		for (int i = 0; i < students.length; i++) {
			students[i].sum = students[i].kor + students[i].eng
					+ students[i].math;
			students[i].avg = Math.round(students[i].sum * 100 / 3) / 100.0;
		}
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[i].sum < students[j].sum) {
					students[i].rank++;
				}
			}
		}
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[j].rank == i + 1) {
					System.out.println(students[j].name + "\t"
							+ students[j].kor + "\t" + students[j].eng + "\t"
							+ students[j].math + "\t" + students[j].sum + "\t"
							+ students[j].avg + "\t" + students[j].rank);
				}
			}
		}

		/************** 답안 **************/

		for (int i = 0; i < students.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < students.length; j++) {
				if (students[min].rank > students[j].rank) {
					min = j;
				}
			}
			Student temp = students[i];
			students[i] = students[min];
			students[min] = temp;
		}

		System.out.println("\t국어\t영어\t수학\t합계\t평균\t석차");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].name + "\t" + students[i].kor + "\t"
					+ students[i].eng + "\t" + students[i].math + "\t"
					+ students[i].sum + "\t" + students[i].avg + "\t"
					+ students[i].rank);
		}

		// 과목별 합계

		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		for (int i = 0; i < students.length; i++) {
			korSum += students[i].kor;
			engSum += students[i].eng;
			mathSum += students[i].math;
		}
		double korAvg = (double) korSum / students.length;
		double engAvg = (double) engSum / students.length;
		double mathAvg = (double) mathSum / students.length;
		System.out.println("과목합계\t" + korSum + "\t" + engSum + "\t" + mathSum);
		System.out.println("과목합계\t" + korAvg + "\t" + engAvg + "\t" + mathAvg);

	}
}
