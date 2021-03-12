package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		// 거스름돈 동전 갯수
		int money = (int)(Math.random()*500)*10;
		int[] coin = {500,100,50,10};
		
		/*
		 * 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요.
		 * 
		 * 거스름돈 : 2860원
		 * 500원 : 5개
		 * 100원 : 3개
		 * 50원 : 1개
		 * 10원 : 1개
		 */
//
//		System.out.println("거스름돈 : " + money);
//		int[] amount = new int[4];
//		for (int i = 0; i < coin.length; i++) {
//			while (money > coin[i]) {
//				money -= coin[i];
//				amount[i]++;
//			}
//		}
//		amount[3]++;
//		System.out.println(Arrays.toString(amount));
//		
//		int ch = 2860;
//		System.out.println("거스름돈 :" + ch + "원");
//		for (int i = 0; i < coin.length; i++) {
//			System.out.println(coin[i] + "원 : " + ch / coin[i] + "개");
//			ch %= coin[i];
//		}
//	      /*********답안********/
//		money = (int) (Math.random() * 500) * 10;
//		System.out.println("거스름돈 : " + money);
//		for (int i = 0; i < coin.length; i++) {
//			System.out.println(coin[i] + "원 : " + money / coin[i] + "개");
//			money = money % coin[i];
//		}
//	      
//	   //그래프 그리기
	   int[] arr = new int[20];
	   for(int i = 0; i<arr.length; i++){
		   arr[i] = (int)(Math.random()*5)+1;
	   }
	   System.out.println(Arrays.toString(arr));
//	   
//	   /*
//	    * 1~5의 숫자가 발생된 만큼 *을 사용해 그래프를 그려주세요.
//	    * 
//	    * 1:***3
//	    * 2:****4
//	    * 3:**2
//	    * 4:*****5
//	    * 5:*1
//	    */
	   
	   int count1=0;
		for (int a = 1; a <= 5; a++) {
			System.out.print(a+ " : ");
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == a) {
					System.out.print("*");
					count1++;
				}
			}System.out.println(" "+count1);
			count1 =0;
		}
		/*********답안********/
		int[] count = new int[5];
		for(int i = 0; i<arr.length; i++){
			count[arr[i]-1]++;
		}
		for(int i = 0; i<count.length; i++){
			System.out.print(i + 1 + " : ");
			for(int j = 0; j<count[i]; j++){
				System.out.print("*");
			}
			System.out.println(" " + count[i]);
		}
	   
	   arr  = new int[10];
	   for(int i = 0; i <arr.length; i++){
		   arr[i] = (int)(Math.random()*5) + 1;
	   }
	   System.out.println(Arrays.toString(arr));
//	   /*
//	    * 1~5 사이의 랜덤한 값이 10개의 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
//	    * [1, 3, 3, 2, 1, 4, 5, 5, 1, 3]
//	    * [1, 3, 2, 4, 5]
//	    */
	/*	int count2 = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int a = i + 1; a < arr.length; a++) {
				if (arr[i] == arr[a]) {
					arr[a] = 0;
				}
			}
			if (arr[i + 1] == 0) {
				count2++;
			}
		}
		int[] arr2 = new int[10 - count2];
		int temp = 0;
		for (int a = 0; a < arr2.length; a++) {
			for (int i = a + temp; i < arr.length; i++) {
				if (arr[i] != 0) {
					arr2[a] = arr[i];
					break;
				} else {
					temp++;
				}
			}
		}
		System.out.println(Arrays.toString(arr2));
		
		*/
		
		
//		
		int temp1 [] = new int[5];
	      int index = 0;
	      for(int i=0; i<arr.length; i++) {
	         boolean flag = false;
	         for(int j=0; j<temp1.length; j++) {
	            if(arr[i] == temp1[j]) {
	               flag = true;
	            }
	         }
	         if(!flag) {
	            temp1[index++] = arr[i];
	         }
	      }
	      System.out.println(Arrays.toString(temp1));

	      int[] result = new int[index];
	      for(int i=0; i<result.length; i++){
	         result[i] = temp1[i];
	      }
	      System.out.println(Arrays.toString(result));
		
		
			//나누어 떨어지는 숫자 배열
		arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
	}
	  /*
	   * 2~5 사이의 랜덤한 수로 나누어 떨어지는 숫자로만 이루어진 배열을 정렬하여 출력해주세요.
	   * 5
	   * [5,10,15,20,25...] 오름차순 정렬
	   */
		/*
		int div = (int)(Math.random()*4)+2; //나눌 숫자
		System.out.println(div);
		int[] _div = new int[50];
		int index1 = 0;
				for (int i = 0; i < arr.length; i++) {
			if (arr[i] % div == 0) {
				_div[index1++] = arr[i];
			}
		}
		System.out.println(Arrays.toString(_div));
		System.out.println(index1);
		int d=0;
		int[] _div1 = new int[index1];
		for(int i = 0; i<index1;i++){
			boolean flag = false;
			for(int j = 0;j<index1; j++){
				if(_div[i]==_div1[j]){
					flag= true;
				}
			}if(!flag){
				_div1[d++] = _div[i];
			}
		}System.out.println(Arrays.toString(_div1));
		

		//------중복제거완료----
		int min;
		for (int i = 0; i < _div1.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < _div1.length; j++) {
				if (_div1[min] > _div1[j]) {
					min = j;
				}
			}
			int temp2 = _div1[i];
			_div1[i] = _div1[min];
			_div1[min] = temp2;

		}
		System.out.println("--------");
		System.out.println(Arrays.toString(_div1));
		d=0;
		int[] _div2= new int[_div1.length];
		for(int i = 0; i<_div1.length;i++){
			boolean flag = false;
			for(int j = 0;j<index1; j++){
				if(_div1[i]==0){
					flag= true;
				}
			}if(!flag){
				_div2[d++] = _div1[i];
			}
		}
		
		
	      int[] result = new int[d];
	      for(int i=0; i<result.length; i++){
	         result[i] = _div2[i];
	      }
	      System.out.println(Arrays.toString(result));
	      */
				//정렬
				
	      
	      /*********답안*********/
	      
	      int n = (int)(Math.random()*4)+2;
	      int[] temp = new int[100];
	      index = 0;
	      for(int i = 0; i<arr.length ;i++){
	    	  if(arr[i]%n ==0){
				temp[index++] = arr[i];
			}
		}
		arr = new int[index];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}
		System.out.println("n : " + n);
		System.out.println(Arrays.toString(arr));

	}
}
