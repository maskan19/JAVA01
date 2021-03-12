package i_collection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Board {
	static Scanner s = new Scanner(System.in);
	HashMap<String, Object> board = new HashMap<>();
	static Calendar cal = Calendar.getInstance();
	static int month = cal.get(Calendar.MONTH) + 1;
	static int day = cal.get(Calendar.DAY_OF_MONTH);
	static int n = 1;
	static int page = 1; 
	final static int fullpage = 5;
	static int num = 0;  //글index

	public static void main(String[] args) {
		ArrayList<HashMap<String, Object>> boardlist = new ArrayList<>();

		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 번호(PK), 제목, 내용, 작성자, 작성일
		 * 
		 * ------------------------------
		 *  번호       제목 		작성자  작성일
		 * ------------------------------
		 * 4 	안녕하세요		홍길동 12/15
		 * 3	반갑습니다		홍길동 12/15
		 * 2	안녕하세요		홍길동 12/15
		 * 1	반갑습니다		홍길동 12/15
		 * 1.조회  2. 등록  3. 종료
		 */

		while (true) {
			if (n > 1) {
				list(boardlist);
			} else {
				System.out.println("\t\t게시글 목록이 비어있습니다.");
			}
			System.out.println("0. 페이지 넘기기   1. 조회    2. 등록    3. 검색    4. 종료");
			String order = s.nextLine();
			switch (order) {
			case "0":
				page(boardlist);
				break;
			case "1":
				read(boardlist);
				break;
			case "2":
				post(boardlist);
				break;
			case "3":
				search(boardlist);
				break;
			case "4":
				System.exit(0);
			}
		}
	}

	static void list(ArrayList<HashMap<String, Object>> boardlist) {
		System.out.println("-----------------------------------------------");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("-----------------------------------------------");

		
//		int i = boardlist.size();
		
//
//		while (page <fullpage) {
//			System.out.println("while");
//			System.out.println(num);
//			System.out.println("num<fullpage 입장");
//				System.out.println("i값" + i);
			System.out.println(boardlist.size());
				for(int i = boardlist.size(); i>boardlist.size()-5; i--){
					System.out.println("i : " + i);
					if(i<=5){
					System.out.println("i" + i);
					HashMap<String, Object> hashmap = boardlist.get(i - 1);
					System.out.print(hashmap.get("번호") + "\t");
					System.out.print(hashmap.get("제목") + "\t");
					System.out.print(hashmap.get("작성자") + "\t");
					System.out.print(hashmap.get("작성일") + "\t");
					System.out.println("i : " + i);
					System.out.println();
					}else {
					System.out.println("브레이크 왜 안걸리는데");
					System.out.println("if 실행 후 "+i);
				}
			}
//		}
		
		if(num*page<boardlist.size()){
			for (int j = 0; j < page/fullpage; j++){
			System.out.print(".[" + (j+1) + "]");
			}
			}
		System.out.print("\t\t[" + page + "]");
		if(num*page<boardlist.size()){
		for (int j = 0; j < boardlist.size()/fullpage; j++){
		System.out.print(".[" + (j+page+1) + "]");
		}
		}
		System.out.println();
	}
	static void page(ArrayList<HashMap<String, Object>> boardlist) {
		System.out.println("> : 페이지 뒤로 / < : 페이지 앞으로");
		String order = s.nextLine();
		switch (order) {
		case "<":
			if (page == 1) {
				System.out.println("\t⚠최신 페이지 입니다.");
			} else {
				page--;
				num-=fullpage;
			}
			break;
		case ">":
			if (page == boardlist.size()/fullpage+1) {
				System.out.println("\t⚠마지막 페이지 입니다.");
			} else {
				page++;
				num+=fullpage;
			}
			break;
		}
	}

	static void read(ArrayList<HashMap<String, Object>> boardlist) {
		if (boardlist.size() > 0) {
			System.out.println("조회할 글 번호 : ");
			int pn = Integer.parseInt(s.nextLine());
			for (int i = 0; i < boardlist.size(); i++) {
				if (boardlist.get(i).get("번호").equals(pn)) {
					HashMap<String, Object> hashmap = boardlist.get(i);
					pn = i;
					System.out
							.println("-----------------------------------------------");
					System.out.print("글 번호 " + hashmap.get("번호"));
					System.out.print("   작성일 : " + hashmap.get("작성일"));
					System.out.println("   작성자 : " + hashmap.get("작성자"));
					System.out.println("제목 : " + hashmap.get("제목"));
					System.out.println("본문 : " + hashmap.get("본문"));
				}
			}
			System.out.println("1. 수정    2. 삭제   3. 돌아가기");
			String order = s.nextLine();
			switch (order) {
			case "1":
				update(boardlist,pn);
				break;
			case "2":
				delete(boardlist,pn);
				break;
			case "3":
				break;
			}
		} else {
			System.out.println("조회할 글이 없습니다.");
		}
	}

	static void post(ArrayList<HashMap<String, Object>> boardlist) {
		HashMap<String, Object> board = new HashMap<>();
		System.out.println("제목 : ");
		String title = s.nextLine();
		board.put("제목", title);
		System.out.println("작성자 : ");
		String writer = s.nextLine();
		board.put("작성자", writer);
		System.out.println("내용 : ");
		String post = s.nextLine();
		board.put("본문", post);
		board.put("번호", n);
		board.put("작성일", month + "/" + day);
		n++;
		boardlist.add(board);
	}

	static void update(ArrayList<HashMap<String, Object>> boardlist, int pn) {
//		System.out.println("수정할 글 번호 : ");
//		int pn = Integer.parseInt(s.nextLine());
		try {
			for (int i = 0; i < boardlist.size(); i++) {
				if (boardlist.get(i).get("번호").equals(pn+1)) {
					System.out.println("수정할 제목 : ");
					String title = s.nextLine();
					boardlist.get(i).put("제목", title);
					System.out.println("수정할 내용 : ");
					String post = s.nextLine();
					boardlist.get(i).put("본문", post);
				}
			}
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
		}
	}

	static void delete(ArrayList<HashMap<String, Object>> boardlist, int pn) {
//		System.out.println("삭제할 글 번호 : ");
//		int pn = Integer.parseInt(s.nextLine());
		for (int i = 0; i < boardlist.size(); i++) {
			if (boardlist.get(i).get("번호").equals(pn+1)) {
				boardlist.remove(i);
				System.out.println("삭제되었습니다");
			}
		}
	}

	static void search(ArrayList<HashMap<String, Object>> boardlist) {
		System.out.println("검색할 키워드 : ");
		String kw = s.nextLine();
		int search = 0;
		for (int i = 0; i < boardlist.size(); i++) {
			if (((String) boardlist.get(i).get("본문")).contains(kw)) {
				search++;
			}
		}
		if (search > 0) {
			System.out
					.println("-----------------------------------------------");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out
					.println("-----------------------------------------------");
			for (int i = 0; i < boardlist.size(); i++) {
				if (((String) boardlist.get(i).get("본문")).contains(kw)) {
					HashMap<String, Object> hashmap = boardlist.get(i);
					System.out.print(hashmap.get("번호") + "\t");
					System.out.print(hashmap.get("제목") + "\t");
					System.out.print(hashmap.get("작성자") + "\t");
					System.out.println(hashmap.get("작성일") + "\t");
					search++;
				}
			}
			System.out.println("1. 조회    2. 돌아가기");
			String order = s.nextLine();
			or: switch (order) {
			case "1":
				if (boardlist.size() > 0) {
					read(boardlist);
				} else {
					System.out.println("조회할 수 없습니다.");
				}
			case "2":
				break or;
			}
		} else {
			System.out.println("검색결과가 없습니다.");
		}
	}
}
