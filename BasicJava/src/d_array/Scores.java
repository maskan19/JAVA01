package d_array;


public class Scores {

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

		String[] names = {"홍길동", "홍길동", "홍길동", "홍길동", "홍길동"
		  		, "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"
		  		, "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"
		  		, "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"
		  		, "홍길동", "홍길동", "홍길동", "홍길동", "홍길동"};
		String[] subjects = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		int[][] scores = new int[names.length][subjects.length];
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < subjects.length; j++) {
				scores[i][j] = (int) (Math.random() * 101);
			}
		}
		int[] name_sum = new int[names.length];
		int[] subject_sum = new int[subjects.length];
		double[] name_avg = new double[names.length];
		double[] subject_avg = new double[subjects.length];
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < subjects.length; j++) {
				name_sum[i] += scores[i][j];
			}
			name_avg[i] = Math.round(name_sum[i] * 100 / 7) / 100.0;
		}
		for (int i = 0; i < subjects.length; i++) {
			for (int j = 0; j < names.length; j++) {
				subject_sum[i] += scores[j][i];
			}
			subject_avg[i] = Math.round(subject_sum[i] * 100 / 7) / 100.0;
		}
		int[] rank = new int[names.length];
		for (int i = 0; i < names.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < names.length; j++) {
				if (name_sum[j] > name_sum[i]) {
					rank[i]++;
				}
			}
		}
		for (int i = 0; i < subjects.length; i++) {
			System.out.print("\t" + subjects[i]);
		}
		System.out.println("\t합계\t평균\t석차");

		for (int j = 0; j < rank.length; j++) {
			for (int i = 0; i < rank.length; i++) {
				if (rank[i] == j + 1) {
					System.out.print(names[i]);
					for (int p = 0; p < scores[i].length; p++) {
						System.out.print("\t" + scores[i][p]);
					}
					System.out.println("\t" + name_sum[i] + "\t" + name_avg[i]
							+ "\t" + rank[i]);
				}
			}
		}

		System.out.print("과목 합계\t");
		for (int i = 0; i < subject_sum.length; i++) {
			System.out.print(subject_sum[i] + "\t");
		}
		System.out.println();
		System.out.print("과목 평균\t");
		for (int i = 0; i < subject_avg.length; i++) {
			System.out.print(subject_avg[i] + "\t");
		}

	}

}
