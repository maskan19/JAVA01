package util;

import java.util.regex.Pattern;

public class Validation {

	private static boolean isAlphaNumeric(String str) {
		return Pattern.matches("[a-z0-9]*$", str);
	}
	//별점
	public static boolean isStar(String str) {
		return Pattern.matches("[1-5]*$", str);
	}

	// 영소문자 숫자
	public static String ALNU(String str) {
		while (!isAlphaNumeric(str)) {
			System.out.println("\t║\t\t숫자와 영어소문자만 사용할 수 있습니다. 다시 입력하세요.\t\t║");
			str = ScanUtil.nextLine();
		}
		System.out.println("\t║\t\t\t   ✔ 입력 성공\t\t\t\t║");
		return str;
	}

	private static boolean isKorean(String str) {
		return Pattern.matches("[가-힣]*$", str);
	}

	// 한글
	public static String KOR(String str) {
		while (!isKorean(str)) {

			System.out.println("\t║\t\t한글만 사용할 수 있습니다. 다시 입력하세요.\t\t║");
			str = ScanUtil.nextLine();
		}
		System.out.println("\t║\t\t\t   ✔ 입력 성공\t\t\t\t║");
		return str;
	}

	public static boolean isKorL(String str) {
		return Pattern.matches("[가-힣]*$",String.valueOf(str.charAt(str.length() - 1)));
	}
	
	public static boolean isKorF(String str) {
		return Pattern.matches("[가-힣]*$",String.valueOf(str.charAt(0)));
	}

	private static boolean isMob(String str) {
		return Pattern.matches("^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", str);
	}

	// 연락처
	public static String PN(String str) {
		while (!isMob(str)) {
			System.out.println("\t║\t\t형식이 잘못되었습니다. 다시 입력하세요.\t\t║");
			str = ScanUtil.nextLine();
		}
		System.out.println("\t║\t\t\t   ✔ 입력 성공\t\t\t\t║");
		return str;
	}

	private static boolean isDate(String str) {
		return Pattern.matches("(19|20)\\d{2}[.-]?(0[1-9]|1[012])[.-]?(0[1-9]|[12][0-9]|3[01])?$", str);
	}

	public static String DATE(String str) {
		while (!isDate(str)) {
			System.out.println("\t║\t\t형식이 잘못되었습니다. 다시 입력하세요.\t\t║");
			str = ScanUtil.nextLine();
		}
		System.out.println("\t║\t\t\t   ✔ 입력 성공\t\t\t\t║");
		return str;
	}

	// 연락처 출력 폼
	public static String PH_format(String str) {
		return str.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$","$1-$2-$3");
	}
	
	
	
	
}
