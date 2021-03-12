package d_array;

import java.util.Scanner;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리마다 콤마를 붙여 출력해주세요.
		//10,000,000,000
		//string타입으로 입력받아라
		System.out.println("숫자를 입력하세요");
		Scanner s = new Scanner(System.in);
		String num = s.nextLine(); 
		int head = num.length() % 3; 
		if (head == 0) {head += 3;}
		System.out.print(num.substring(0, head));
		for (int i = 3; head + i <= num.length(); head += 3) {
			System.out.print("," + num.substring(head, head + i));
		}
		
		
		System.out.println();/********************/
		
		String comma = "";
		int count= 0;
		for(int i = num.length()-1; i>=0; i--){
			comma = num.charAt(i)+comma;
			count++;
			if(count%3 ==0&& count != num.length()){
				comma = "," + comma;
			}
		}
		System.out.print(comma);

	}

}
