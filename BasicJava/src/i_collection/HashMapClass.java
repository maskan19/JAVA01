package i_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {

		/*
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set KeySet() : 저장된 모든 키를 Set으로 반환한다.
		 */

		HashMap<String, Object> map = new HashMap<>();

		map.put("a", 10);
		map.put("b", "홍길동");
		map.put("c", new Scanner(System.in));

		System.out.println(map); // map은 순서가 없어서 입력 순서와 상관없이 출력

		map.put("b", "이순신"); // 덮어쓴다.
		map.remove("c"); // 지운다.

		System.out.println(map);

		Object value = map.get("b");
		System.out.println(value);

		int value1 = (Integer) map.get("a");
		String value2 = (String) map.get("b");

		Set<String> keys = map.keySet(); // 저장된 모든 키

		for (String key : keys) { // 향상된 for문 keys 값을 key값에 대입해{}실행
			System.out.println(key + " : " + map.get(key));
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (Integer i : list) {
			// i는 list의 값을 가져옴
			// ex)list={50,30,60}->i=50{}, i=30{}, i=60{}
		}

		// 회원테이블
		// 아이디, 비밀번호, 이름, 전화번호 column
		/* id		password	name	tel
		 * admin	admin123	관리자	010-1234-5678
		 */
		HashMap<String, String> user = new HashMap<>();
		user.put("id", "admin");
		user.put("password", "admin123");
		user.put("name", "관리자");
		user.put("tel", "010-1234-5678");

		ArrayList<HashMap<String, String>> table = new ArrayList<>();
		table.add(user);

		user = new HashMap<>();
		user.put("id", "wait");
		user.put("password", "hack");
		user.put("name", "성이름");
		user.put("tel", "010-9876-5432");
		table.add(user);

		for (int i = 0; i < table.size(); i++) {
			Set<String> tablekey = table.get(i).keySet();
			for (String key : tablekey) {
				System.out.println(key + " : " + table.get(i).get(key));
			}
			System.out.println();
		}

		for (int i = 0; i < table.size(); i++) {
			HashMap<String, String> hashmap = table.get(i); // 속도가 더 빠르다
			Set<String> keyset = hashmap.keySet();
			for (String key : keyset) {
				System.out.println(key + " : " + hashmap.get(key));
			}
			System.out.println("--------------");
		}
	}
}
