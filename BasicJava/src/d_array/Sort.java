package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * 정렬 - 석차 구하기 : 점수를 비교해 작은 점수의 등수를 증가시키는 방식 
		 * - 선택 정렬 : 가장 작은 숫자를 찾아서 앞으로 보내는 방식 
		 * - 버블 정렬 : 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		 * - 삽입 정렬 : 두번째 숫자부터 앞의 숫자들과 비교해서 큰 수는 뒤로 밀고 중간에 삽입하는 방식
		 */

		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));

		// 선택정렬
		/*제출
		int min;
		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;

		}
		System.out.println("선택정렬" + Arrays.toString(arr));
		*/
		/*답안*/
//		min = 0;
//
//		for (int i = 0; i < arr.length - 1; i++) {
//			min = i;
//			for (int j = i + 1; j < arr.length; j++) {
//				if (arr[j] < arr[min]) {
//					min = j;
//				}
//			}
//			int temp = arr[i];
//			arr[i] = arr[min];
//			arr[min] = temp;
//		}
//		System.out.println("선택정렬" + Arrays.toString(arr));

		/*오답
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		*/

		 //석차구하기
		/*답안*/
		int[] rank = new int[arr.length];
		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		} // array 안의 모든 값을 1로 설정
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) { // 비교해서 점수가 작은 사람의 등수를 증가시킴
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));

		// 버블정렬 
	/*ERROR
		int len = arr.length;
		for (int i = 0; i < len - 1; len--) {
			for (int j = i + 1; j < len; i++) {
				if (arr[i] > arr[j]) {
					int max = arr[i];
					arr[i] = arr[j];
					arr[j] = max;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		*/
		//버블 정렬 + 자리 변화가 없으면 변경을 끝냄
		
		/*제출*/
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("버블정렬" + Arrays.toString(arr));

		/* 답안 */
		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag) { // flag가 false라면
				break;
			}
		}
		System.out.println("버블정렬" + Arrays.toString(arr));
		
		//삽입정렬
		//두번째 숫자를 변수에 저장한다.
		//앞의 숫자와 비교해서 큰 수를 만나면 큰 수를 한 칸 뒤로 보낸다.
		//작은 수를 만나면 작은 수의 바로 뒷칸에 변수의 값을 저장하고 반복문을 빠져나간다.
		/*제출*/
		for (int i = 0; i <arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j] < arr[j- 1]) {
					int temp = arr[j];
					arr[j]= arr[j - 1];
					arr[j-1] = temp;
					}
			}
		}System.out.println("삽입정렬" + Arrays.toString(arr));
		/*답안*/
		for(int i = 1; i <arr.length; i++){
			int temp = arr[i];
			int j = 0;
			for( j = i-1; j>=0; j--){
				if(temp < arr[j]){
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = temp;
		}
		System.out.println(Arrays.toString(arr));

	}

}
