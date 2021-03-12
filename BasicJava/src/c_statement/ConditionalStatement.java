package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * 조건문
		 * - if문
		 * - switch문
		 * 
		 * if문
		 * - if(조건식){} : 조건식의 결과가 true이면 블럭 안의 문장을 수행한다.
		 * - else if(조건식){} : 다수의 조건이 필요할 때 if 뒤에 추가한다.
		 * - else{} : 결과가 true인 조건식이 하나도 없을 경우를 위해 추가한다.
		 */
		
		int a = 3;
		if(a == 1){
			System.out.println("조건식의 연산결과가 true이면 수행된다.");
		}
		
		if(a == 0){
			System.out.println("조건식의 연산결과가 false이면 수행되지 않는다.");
		}
		
		if(a == 1){
			System.out.println("a가 1인 경우에 하고 싶은 것");
		}else if(a== 2){
			System.out.println("a가 2인 경우에 하고 싶은 것");
		}else if(a ==3){
			System.out.println("a가 3인 경우에 하고 싶은 것");
		}else{
			System.out.println("이외의 경우에 하고 싶은 것");
		}
		
		if(a < 10){
			System.out.println("a가 10보다 작다.");
		}else if (a < 20){
			System.out.println("a가 20보다 작다.");
		}
		
		
		//시험점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 50;
		
		if(60 <= score){
			System.out.println("합격");
		}else{
			System.out.println("불합격");
		}
		
		//성적에 등급을 부여하는 프로그램을 만들어보자.
		score = 91;
		String grade = null;
		if(90 <= score){
			grade = "A";
			if(97<=score){
				grade += "+";
		}else if (score <=93){
				grade += "-";}
//				grade = grade + "-"; 이 60과 동일
		}else if(80<= score /*&& score < 90 */){ //있어도 그만 없어도 그만
			grade = "B";
			if(87<=score){
				grade += "+";}
			else if(score <= 83){
				grade += "-";}
		}else if(70 <= score){
			grade = "C";
			if(77<= score){
				grade = grade+="+";}
			else if(score <=73){
				grade += "-";}
		}else if(60 <= score){
			grade = "D";
			if(67<= score){
				grade += "+";}
			else if(score<=63){
				grade += "-";}
		}else{
			grade = "F";
		}
		System.out.println(score+ "점에 해당하는 등급은" + grade + "입니다.");
		
		/*
		 * switch문
		 * - switch(int/String){case 1: break;}
		 * - 조건식의 결과는 정수와 문자열만(JDK1.7부터 문자열 허용) 허용한다.
		 * - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 */
		
		a = 1;
		
		switch(a){
		
		case 1:
			System.out.println("a가 1인 경우에 하고 싶은 것");
			break;
		case 2:
			System.out.println("a가 2인 경우에 하고 싶은 것");
			break;
		case 3:
			System.out.println("a가 3인 경우에 하고 싶은 것");
			break;
		default: /*else와 유사*/
			System.out.println("이외의 경우에 하고 싶은 것");
		}
		
		String n = "a";
		
		switch(n){
		case "a" :
				System.out.println("n이 \"a\"인 경우에 하고 싶은 것");
				break;
				/*문장 안에 따옴표를 넣기 위해 \" 사용*/
		case "b" : 
			System.out.println("n이 \"b\"인 경우에 하고 싶은 것");
			break;
		default:
			System.out.println("이외의 경우에 하고 싶은 것");
			break;
		}
		
		//주어진 월에 해당하는 계절을 출력해봅시다.
		int month = 1;
		String season = null;
		
		switch(month){
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8 :
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		}	
		System.out.println(month + "월은 " + season + "입니다.");
			
		
		score = 90;
		grade = null;
		
		switch(score/10){  /*swith가 int 이므로*/
		case 10: case 9 : grade = "A"; break;
		case 8 : grade = "B"; break;
		case 7 : grade = "C"; break;
		case 6 : grade = "D"; break;
		default : grade = "F";
		}
		System.out.println(score + "점에 대한 등급은" + grade+ "입니다.");
		
			
		
		//숫자를 입력받아 그 숫자가 0인지 0이 아닌지 출력해주세요.
		Scanner s = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
	    int num1 = Integer.parseInt(s.nextLine());
		if (num1 == 0){
			System.out.print("0을 입력했습니다.");}
		else{
			System.out.println("0이 아닙니다.");}
	
		
		//숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
		System.out.println("숫자를 입력하세요.");
		int num2 = Integer.parseInt(s.nextLine());
		if (num2%2 == 0){
			System.out.println("짝수입니다.");}
			else{
				System.out.println("홀수입니다.");}
		
		//점수 3개를 입력받아 총점, 평균, 등급을 출력해주세요.
		
		System.out.println("점수1을 입력하세요.");
		int score1 = Integer.parseInt(s.nextLine());
		System.out.println("점수2을 입력하세요.");
		int score2 = Integer.parseInt(s.nextLine()); 
		System.out.println("점수3을 입력하세요.");
		int score3 = Integer.parseInt(s.nextLine());
		
		int sum = score1 + score2 + score3;
//		int avg = sum *10 /3; 반올림이 아닌 버림
		
		double avg = Math.round(sum*10/3.0)/10.0;
		// Math.round()함수는 int이므로 다시 double타입을 삽입해야함.
		
		String grade1= null;
		if (90 <= avg){
			grade1 = "A";}
		else if (80 <= avg){
			grade1 = "B";}
		else if (70 <= avg){
			grade1 = "C";}
		else if (60 <= avg){
			grade1 = "D";}
		else {grade1 = "F";}
		
		System.out.println("총점 : "+ sum + "점 / 평균 : " + avg/*/10.0*/ + "점 / 등급 : "+ grade1 + "점");
		
		
		//1~100 사이의 랜덤한 숫자 3개를 발생시키고 오름차순으로 출력해주세요.
		int random1 = (int)(Math.random() * 100) + 1;
		int random2 = (int)(Math.random() * 100) + 1;
		int random3 = (int)(Math.random() * 100) + 1;
		
		if(random1 <= random2){
			if(random2 <= random3){
				System.out.println(random1 + " < " + random2 + " < " + random3);
			} else if (random3 <= random1){
				System.out.println(random3 + " < " + random1+ " < " + random2);}
				else {System.out.println(random1 + " < " + random3 + " < " + random2);}	
		}
		else if(random2 <random1){
			if(random1 <=random3){
				System.out.println(random2 + " < " + random1 + " < " + random3);}
			else if (random3 <=random2){
				System.out.println(random3 + " < " + random2 + " < " + random1);}
			else {System.out.println(random2 + " < " + random3 + " < " + random1);}
		}
		
//		int ran1 = (int)(Math.random() * 100) + 1;
//		int ran2 = (int)(Math.random() * 100) + 1;
//		int ran3 = (int)(Math.random() * 100) + 1;
//		
//		int min;
//		int mid;
//		int max;
//		
//		if(ran1 <= ran2){
//			if(ran2 <= ran3){
//				ran1 = min; ran2 = mid; ran3 = max;
//			} else if (random3 <= random1){
//				ran3 = min; ran1= mid; ran2 = max;}
//				else {ran1=min; ran3=mid;  ran2 = max;}	
//		}
//		else if(ran2 <ran1){
//			if(ran1 <=ran3){
//				ran2=min; ran1=mid; ran3=max;}
//			else if (ran3 <=ran2){
//				ran3 = min;  ran2 = mid; ran1=max;}
//			else {ran2 = min;  ran3 =mid; ran1=max;}
//		}
//		System.out.println(min+"<" + mid + "<"+ max);
		
		int x = (int)(Math.random() * 100) + 1;
		int y = (int)(Math.random() * 100) + 1;
		int z = (int)(Math.random() * 100) + 1;
		
		if(x > y){
			int temp = y;
			y = x;
			x = temp;
		}
		
		if(x > z){
			int temp = x;
			x = z;
			z = temp;
		}

		if (y > z) {
			int temp = y;
			y = z;
			z = temp;
		}
		System.out.println(x + "<" + y + "<" + z);

	}

}
