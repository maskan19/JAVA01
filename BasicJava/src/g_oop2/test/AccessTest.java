package g_oop2.test;

import g_oop2.AccessModifier;
import g_oop2.Time;

public class AccessTest extends AccessModifier{

	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();

		System.out.println(am.publicVar);
		am.publicMethod();
//		System.out.println(am.protectedVar);
//		am.protectedMethod();
//		System.out.println(am.defaultVar);
//		am.defaultMethod();            //상속을 받은 클래스가 필요
//		System.out.println(am.privateVar);
//		am.privateMethod();        //같은 클래스에서만 사용 가능
		

		AccessTest at = new AccessTest();
		
		System.out.println(at.protectedVar);
		at.protectedMethod();
		
		/*
		 * 접근제어자를 사용하는 이유
		 * - 데이터를 보호하기 위해
		 * - 사용하는데 불필요한 멤버를 숨기기 위해
		 */
		
		Time t = new Time();
	}
}
