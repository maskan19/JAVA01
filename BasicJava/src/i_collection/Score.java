package i_collection;

import java.util.ArrayList;

public class Score {

	public static void main(String[] args) {
	/*
	 * 우리반(25명) 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를 0~100까지 랜덤으로 생성하고
	 * 아래와 같이 출력하라
	 * 
	 * 			국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차
	 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
	 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
	 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
	 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
	 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
	 * 과목합계	450		450		450		450		450		450		450
	 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00
	 */
	
		String[] names = { "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", 
				"홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", 
				"홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", "홍길동", 
				"홍길동" };
		String[] subjects = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};

		ArrayList<ArrayList<Object>> score = new ArrayList<>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> subject = new ArrayList<>();
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < names.length; i++) {
			ArrayList<Object> sc7 = new ArrayList<>();
			int rank = 1;
			sum = 0;
			for (int j = 0; j < subjects.length; j++) {
				sc7.add((int) (Math.random() * 101));
				sum += (int)sc7.get(j);
			}
			name.add(names[i]);
			avg = Math.round((double)sum / subjects.length *100)/100.0;
			sc7.add(sum);
			sc7.add(avg);    //only same type(Integer type) in same Array
			sc7.add(rank);
			score.add(sc7);
		}
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names.length; j++) {
				if ((int) score.get(i).get(7) < (int) score.get(j).get(7)) {
					score.get(i).set(9, (int) score.get(i).get(9) + 1);
				}
			}
		}

		ArrayList<ArrayList> rfteacher = new ArrayList<>();
		for (int i = 0; i < subjects.length; i++) {
			sum = 0;
			ArrayList<Object> sc7 = new ArrayList<>();
			for (int j = 0; j < names.length; j++) {
				sum += (int) score.get(j).get(i);
			}
			avg = Math.round((double)sum / names.length *100)/100.0;
			sc7.add(sum);
			sc7.add(avg);
			rfteacher.add(sc7);
			subject.add(subjects[i]);
		}

		for (int i = 0; i < subject.size(); i++) {
			System.out.print("\t" + subject.get(i));
		}
		System.out.println("\t합계\t평균\t석차");
		for (int b = 1; b <= name.size(); b++) {
			for (int a = 0; a < name.size(); a++) {
				if ((int)score.get(a).get(9) == b) {
					System.out.print(name.get(a));
					for (int j = 0; j < score.get(a).size(); j++) {
						System.out.print("\t" + score.get(a).get(j));
					}
					System.out.println();
				}
			}
		}
		
		System.out.print("과목 총합");
		for (int i = 0; i < rfteacher.size(); i++) {
			System.out.print("\t" + rfteacher.get(i).get(0));
		}System.out.println();
		System.out.print("과목 평균");
		for (int i = 0; i < rfteacher.size(); i++) {
			System.out.print("\t" + rfteacher.get(i).get(1));
		}
		
		//////////////////////교수님 답안/////////////////////////
		/*
				 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
				 * 0 ~ 100까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.
				 * 
				 * 			국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차
				 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
				 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
				 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
				 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
				 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
				 * 과목합계	450		450		450		450		450		450		450
				 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00
				 */
//				ArrayList<String> students = new ArrayList<>();
//				
//				students.add("정지수");
//				students.add("이현기");
//				students.add("윤지혜");
//				students.add("정이삭");
//				students.add("박세현");
//				students.add("오세일");
//				students.add("장병길");
//				students.add("배수진");
//				students.add("김지훈");
//				students.add("임태준");
//				students.add("최희수");
//				students.add("전형섭");
//				students.add("김혜정");
//				students.add("송수미");
//				students.add("진예은");
//				students.add("양지수");
//				students.add("김도윤");
//				students.add("김보현");
//				students.add("원정훈");
//				students.add("문선준");
//				students.add("진유리");
//				students.add("김동익");
//				students.add("이진수");
//				students.add("박초원");
//				students.add("김보미");
//				
//				ArrayList<String> subjects = new ArrayList<>();
//				subjects.add("국어");
//				subjects.add("영어");
//				subjects.add("수학");
//				subjects.add("사회");
//				subjects.add("과학");
//				subjects.add("Oracle");
//				subjects.add("Java");
//				
//				//점수 발생
//				ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
//				
//				for(int i = 0; i < students.size(); i++){
//					ArrayList<Integer> score = new ArrayList<>();
//					for(int j = 0; j < subjects.size(); j++){
//						score.add((int)(Math.random() * 101));
//					}
//					scores.add(score);
//				}
//				
//				//합계/평균
//				ArrayList<Integer> sums = new ArrayList<>();
//				ArrayList<Double> avgs = new ArrayList<>();
//				
//				for(int i = 0; i < students.size(); i++){
//					int sum = 0;
//					for(int j = 0; j < subjects.size(); j++){
//						sum += scores.get(i).get(j);
//					}
//					double avg = Math.round((double)sum / subjects.size() * 100) / 100.0;
//					sums.add(sum);
//					avgs.add(avg);
//				}
//				
//				//석차
//				ArrayList<Integer> ranks = new ArrayList<>();
//				
//				for(int i = 0; i < sums.size(); i++){
//					ranks.add(1);
//					for(int j = 0; j < sums.size(); j++){
//						if(sums.get(i) < sums.get(j)){
//							ranks.set(i, ranks.get(i) + 1);
//						}
//					}
//				}
//				
//				//정렬
//				for (int i = 0; i < ranks.size() - 1; i++) {
//					int min = i;
//					for (int j = i + 1; j < ranks.size(); j++) {
//						if (ranks.get(j) < ranks.get(min)) {
//							min = j;
//						}
//					}
//					
//					String name = students.get(i);
//					students.set(i, students.get(min));
//					students.set(min, name);
//					
//					ArrayList<Integer> list = scores.get(i);
//					scores.set(i, scores.get(min));
//					scores.set(min, list);
//					
//					Integer sum = sums.get(i);
//					sums.set(i, sums.get(min));
//					sums.set(min, sum);
//					
//					Double avg = avgs.get(i);
//					avgs.set(i, avgs.get(min));
//					avgs.set(min, avg);
//					
//					int rank = ranks.get(i);
//					ranks.set(i, ranks.get(min));
//					ranks.set(min, rank);
//				}
//				
//				//출력
//				for(int i = 0; i < subjects.size(); i++){
//					System.out.print("\t" + subjects.get(i));
//				}
//				System.out.println("\t합계\t평균\t석차");
//				
//				for(int i = 0; i < students.size(); i++){
//					System.out.print(students.get(i) + "\t");
//					for(int j = 0; j < subjects.size(); j++){
//						System.out.print(scores.get(i).get(j) + "\t");
//					}
//					System.out.print(sums.get(i) + "\t");
//					System.out.print(avgs.get(i) + "\t");
//					System.out.print(ranks.get(i) + "\t");
//					System.out.println();
//				}
//				
//				//과목합계/과목평균
//				ArrayList<Integer> subjectSums = new ArrayList<>();
//				ArrayList<Double> subjectAvgs = new ArrayList<>();
//				for(int i = 0; i < subjects.size(); i++){
//					int sum = 0;
//					for(int j = 0; j < students.size(); j++){
//						sum += scores.get(j).get(i);
//					}
//					double avg = Math.round((double)sum / students.size() * 100) / 100.0;
//					subjectSums.add(sum);
//					subjectAvgs.add(avg);
//				}
//				
//				System.out.print("과목합계");
//				for(int i = 0; i < subjectSums.size(); i++){
//					System.out.print("\t" + subjectSums.get(i));
//				}
//				System.out.println();
//				System.out.print("과목평균");
//				for(int i = 0; i < subjectAvgs.size(); i++){
//					System.out.print("\t" + subjectAvgs.get(i));
//				}
//				System.out.println();
//			}
//
//		}

	}
}
