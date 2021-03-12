package e_oop.quiz;

import java.util.Scanner;

public class Hippocrates {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		questions q = new questions();
		System.out.println("\t\t\t    히포크라테스 기질 테스트\n\t\t\t다음 중 당신의 강점을 고르세요.");
		q.q1();
		System.out.println("\t\t\t다음 중 당신의 단점을 고르세요.");
		q.q21();

		int[] ans = new int[4];
		for (int i = 0; i < q.ans.length; i++) {
			ans[q.ans[i] - 1]++;
		}

		int rank[] = new int[4];
		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < rank.length; j++) {
				if (ans[i] < ans[j]) {
					rank[i]++;
				}
			}
		}
		int result1 = 0;
		int result2 = 0;
		for (int i = 0; i < rank.length; i++) {
			if (rank[i] == 1) {
				result1 = i;
			} else if (rank[i] == 2) {
				result2 = i;
			}
		}
		q.result(result1, result2);
		if (q.tend1 == "다혈") {
			if (q.tend2 == "담즙") {
				q.result1();
			} else if (q.tend2 == "점액") {
				q.result2();
			} else
				q.result3();
		} else if (q.tend1 == "담즙") {
			if (q.tend2 == "다혈") {
				q.result4();
			} else if (q.tend2 == "우울") {
				q.result5();
			} else
				q.result6();
		} else if (q.tend1 == "우울") {
			if (q.tend2 == "담즙") {
				q.result7();
			} else if (q.tend2 == "점액") {
				q.result8();
			} else
				q.result9();
		} else if (q.tend1 == "점액") {
			if (q.tend2 == "우울") {
				q.result10();
			} else if (q.tend2 == "다혈") {
				q.result11();
			} else
				q.result12();
		}
	}

}