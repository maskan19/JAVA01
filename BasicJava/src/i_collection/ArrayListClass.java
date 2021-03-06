package i_collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * - 메소드의 종류
		 * 
		 * boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다.
		 * - 0번 인덱스부터 차례 추가 > 결과를 불린타입으로 반환
		 * void add(int index, Object obj) : 지정된 위치에 객체를 추가한다.
		 * - 인덱스를 지정하면 해당 인덱스에 저장을 하고, 이후의 배열은 밀려난다.
		 * Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다.
		 * - 값을 대체하고 대체당한 값을 반환한다.
		 * Object get(int index) : 지정된 위치의 객체를 반환한다.
		 * int size() : 저장된 객체의 수를 반환한다.
		 * - 일반Array의 length에 해당한다.
		 * boolean remove(int index) : 지정된 위치의 객체를 제거한다.
		 */

		// ArrayList와 HashMap을 주로 사용
		ArrayList sample = new ArrayList();
		sample.add("abc");
		sample.add(100);
		sample.add(new Scanner(System.in));
		System.out.println(sample);

		// 제네릭을 지정하지 않은면 넣을 때는 편하나 꺼낼 때는 타입을 예측하기 힘들다.
		// 따라서 제네릭의 사용을 권장한다.
		// 제네릭에는 참조형 타입만 저장할 수 있음(int(x) Integer(o))
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		// list.add("abc"); // 컴파일 에러 발생
		list.add(20);
		System.out.println(list.add(30)); // 저장 > true
		System.out.println(list); // [10, 20, 30]
		list.add(1, 40);// 1번 인덱스부터 뒤로 밀고 값을 저장한다.
		System.out.println(list);// [10, 40, 20, 30]
		// list.add(5,50); //4번 인덱스가 비어있으므로 5번 인덱스에 넣을 수 없음
		Integer before = list.set(2, 50); // 2번 인덱스에 값을 저장하고 기존 값을 반환한다.
		System.out.println("before : " + before); // 20
		System.out.println("after : " + list.get(2)); // 50
		System.out.println(list);

		Integer integer = list.get(2);
		System.out.println(integer);

		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(i + " : " + list.get(i));
		// list.remove(0);// 0 : 10 1 : 50 > 지우자마자 배열이 바뀜
		// }
		for (int i = list.size() - 1; 0 <= i; i--) {
			System.out.println(i + " : " + list.get(i));
			list.remove(i);
		}
		System.out.println(list);
		
		/*
		 * Wrapper클래스 : 기본형 타입을 객체로 사용해야 할 때 대신 사용하는 클래스
		 * - boolean: Boolean
		 * - char 	: Character
		 * - byte 	: Byte
		 * - short 	: Short
		 * - int 	: Integer
		 * - long 	: Long
		 * - float 	: Float
		 * - double : Double
		 */
		// int x = 10;
		// Integer y = new Integer(10);

		ArrayList<Integer> li = new ArrayList<>();
		li.add(new Integer(10));
		li.add(10); // 오토박싱 : 기본형 타입이 wrapper 클래스로 자동 변환

		Integer _integer = li.get(0);
		int i = li.get(0); // 언박싱 : wrapper클래스가 기본형 타입으로 자동 변환

		// list에 1 ~ 100 사이의 랜덤값을 10개 저장해주세요.

		for (int j = 0; j < 10; j++) {
			list.add((int) (Math.random() * 100) + 1);
		}
		System.out.println(list);

		// list에 저장된 값의 합계와 평균을 구해주세요.
		int sum = 0;
		double avg = 0;
		for (int j = 0; j < list.size(); j++) {
			sum += list.get(j);
		}
		avg = Math.round((double) sum / list.size());
		System.out.println("합계 : " + sum + ", 평균 : " + avg);

		// list에서 최소값과 최대값을 구해주세요.
		int max = list.get(0);
		int min = list.get(0);
		for (int j = 0; j < list.size(); j++) {
			if (min > list.get(j)) {
				min = list.get(j);
			}
			if (max < list.get(j)) {
				max = list.get(j);
			}
		}
		System.out.println("최대 : " + max + "최소 : " + min);

		// list를 오름차순으로 정렬해주세요.
		for (i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(i) < list.get(j)) {
					int temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
		System.out.println(list);
		/////////////////답안////////////////////
		for (i = 1; i < list.size(); i++) {
			int temp = list.get(i);
			int j = 0;
			for (j = i - 1; j >= 0; j--) {
				if (temp < list.get(j)) {
					list.set(j + 1, list.get(j));
				} else {
					break;
				}
			}
			list.set(j + 1, temp);
		}
		System.out.println(list);

		// 2차원 배열
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		ArrayList<Integer> _list = new ArrayList();
		_list.add(10);
		_list.add(20);
		_list.add(30);

		list2.add(_list);

		_list = new ArrayList();
		_list.add(40);
		_list.add(50);

		list2.add(_list);
		System.out.println(list2); // [[10, 20, 30], [40, 50]]

		for (i = 0; i < list2.size(); i++) {
			ArrayList<Integer> tempList = list2.get(i);
			for (int j = 0; j < tempList.size(); j++) {
				System.out.print(tempList.get(j) + "\t");
			}
			System.out.println();
		}

	}
}
