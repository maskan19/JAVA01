package e_oop;

public class UserDefinedDataType {

	public static void main(String[] args) {
		/*
		 * 사용자 정의 데이터 타입(클래스)
		 * - 데이터의 최종 진화 형태이다. (기본형>배열>클래스)
		 * - 서로 다른 타입의 데이터를 묶어서 사용하는 것이다. 
		 * - 변수와 메서드로 구성할 수 있다.
		 */
//		기본형 타입(1개의 변수에 1개의 데이터만 저장)
		int kor;
		int eng;
		int math;
		int sum;
		double avg;
		String name;

		// 배열(같은 타입의 데이터를 여러개 저장)
		int[] scores;
		int sum2;
		double avg2;
		String name2;

		// 클래스(관련된 변수를 다 묶어서 저장)
		Student student;
		student = new Student(); // 객체 생성(인스턴스화)
		student.kor = 80;
		student.eng = 90;
		student.math = 60;
		student.sum = student.kor + student.eng + student.math;
		student.avg = student.sum / 3.0;
		student.name = "홍길동";

		System.out.println(student.name);
		System.out.println(student.avg);
	}
}

// public class 는 하나
class Student {
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	String name;
}