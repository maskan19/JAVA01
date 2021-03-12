package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsException {

	public static void main(String[] args) {

		/*
		 * 메서드에 예외 선언하기
		 * - 메서드 호출 시 발생할 수 있는 예외를 선언해줄 수 있다.
		 * - void method() throws IOException {} 
		 *		//method호출시 IOException 발생 가능.
		 *		//IOException을 예외처리 하지 않고 메서드를 호출할 때 해결
		 * - 메서드의 구현부 끝에 throws 예약어와 예외 클래스명으로 예외를 선언할 수 있다.
		 * - 예외를 선언하면 예외처리를 하지 않고 자신을 호출한 메서드로 예외처리를 넘겨준다.
		 */
		
		//F3을 누르면 메서드가 있는 위치로 이동
		
		try {
			new FileInputStream("");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			method(); //예외 선언이 되어있다면 꼭 try catch 문으로 감싸줘야한다.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void method() throws IOException {
		throw new IOException();
	}
}
