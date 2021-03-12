package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.EventBoardDao;

public class EventBoardService {

	private static EventBoardService instance;

	private EventBoardService() {
	}

	public static EventBoardService getInstance() {
		if (instance == null) {
			instance = new EventBoardService();

		}
		return instance;

	}

	private EventBoardDao boardDao = EventBoardDao.getInstance();// 객체 성성
	private int currentBoardNo;

	public int boardList() {
		List<Map<String, Object>> boardList = boardDao.seletBoardList();
		System.out
				.println("╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("║                                                               ║");
		System.out.println("\t번호 \t 제목 \t 작성자\t작성일");
		System.out
				.println("╚═══════════════════════════════════════════════════════════════╝");
		for (int i = 0; i < boardList.size(); i++) {
			Map<String, Object> board = boardList.get(i);
			System.out.println("\t" + board.get("EVNUM") + "\t"
					+ board.get("EVTITLE") + "\t" + board.get("MEM_ID") + "\t"
					+ board.get("EVTIME"));

		}
		System.out
				.println("╚═══════════════════════════════════════════════════════════════╝");
		if (Controller.LoginUser == null) {
			System.out
					.println("------------------------------------------------------------------------------");
			System.out.println("\n\n\t\t\t\t[1].조회\n\n\t\t\t\t[0].메인 메뉴");
			System.out.print("\n\n\t\t\t\t입력>");
			int input = ScanUtil.nextInt();

			switch (input) {

			case 1:
				System.out.println("게시글 번호 입력>");
				currentBoardNo = ScanUtil.nextInt();// 게시글 번호를 입력하고 조회된것을 이용해야해서
													// 다른 메소드를 호출해야해서 공유하지않음.
													// //전역변수를 통해서 사용함
				return View.EVENT_SELECT;

			case 0:
				// 로그아웃은 여기에 널을 저장하면 비어짐으로 로그인으로 넘어가지 않는다.
				return View.MAIN;

			}

		} else if (Controller.LoginUser.get("MEM_ID").equals("ADMIN")) {
			System.out
					.println("------------------------------------------------------------------------------");
			System.out
					.println("\n\n\t\t\t\t[1].조회\n\n\t\t\t\t[2].등록\n\n\t\t\t\t[0].메뉴");
			System.out.print("\n\n\t\t\t\t입력>");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				System.out.println("게시글 번호 입력>");
				System.out.print("\n\n\t\t\t\t입력>");
				currentBoardNo = ScanUtil.nextInt();// 게시글 번호를 입력하고 조회된것을 이용해야해서
													// 다른 메소드를 호출해야해서 공유하지않음.
													// 전역변수를 통해서 사용함
				return View.EVENT_SELECT;
			case 2:
				return View.EVENT_INSERT_FORM;
			case 0:
				// 로그아웃은 여기에 널을 저장하면 비어짐으로 로그인으로 넘어가지 않는다.
				return View.ADMINPAGE;

			}

		} else {
			System.out
					.println("------------------------------------------------------------------------------");
			System.out.println("\n\n\t\t\t\t[1].조회\n\n\t\t\t\t[0].메인 메뉴");
			System.out.print("\n\n\t\t\t\t입력>");
			int input = ScanUtil.nextInt();

			switch (input) {

			case 1:
				System.out.println("\n\n\t\t\t\t[게시글 번호입력하세요]");
				System.out.print("\n\n\t\t\t\t입력>");
				currentBoardNo = ScanUtil.nextInt();// 게시글 번호를 입력하고 조회된것을 이용해야해서
													// 다른 메소드를 호출해야해서 공유하지않음.
													// 전역변수를 통해서 사용함
				return View.EVENT_SELECT;

			case 0:
				// 로그아웃은 여기에 널을 저장하면 비어짐으로 로그인으로 넘어가지 않는다.
				return View.MAIN;

			}
			return View.EVENT_LIST;

		}
		return View.MAIN;
	}

	public int Look() {
		List<Object> test = new ArrayList<>();
		test.add(currentBoardNo);

		Map<String, Object> op = boardDao.selectOneList(test);
		// boolean x =false;
		// x = Controller.LoginUser.get("MEM_ID").equals("ADMIN");
		if (Controller.LoginUser == null) {
			System.out
					.println("╔═══════════════════════════════════════════════════════════════╗");
			System.out
					.println("║                                                               ║");
			System.out.println("\t[번호]\t[제목]\t[내용]\t[작성자]\t[작성일]");
			System.out
					.println("╚═══════════════════════════════════════════════════════════════╝");
			System.out.println("\t" + op.get("EVNUM") + "\t"
					+ op.get("EVTITLE") + "\t" + op.get("EVCONTENTS") + "\t"
					+ op.get("MEM_ID") + "\t" + op.get("EVTIME"));
			System.out
					.println("╚═══════════════════════════════════════════════════════════════╝");

			System.out.println("\n\n\t\t\t\t[1].목록\n\n\t\t\t\t[0].메뉴");
			System.out.print("입력>");

			int input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				return View.EVENT_LIST;
			case 2:
				return View.MAIN;
			}

		} else if (Controller.LoginUser.get("MEM_ID").equals("ADMIN")) {

			System.out
					.println("╔═══════════════════════════════════════════════════════════════╗");
			System.out
					.println("║                                                               ║");
			System.out.println("\t[번호]\t[제목]\t[내용]\t[작성자]\t[작성일]");
			System.out
					.println("╚═══════════════════════════════════════════════════════════════╝");
			System.out.println("\t" + op.get("EVNUM") + "\t"
					+ op.get("EVTITLE") + "\t" + op.get("EVCONTENTS") + "\t"
					+ op.get("MEM_ID") + "\t" + op.get("EVTIME"));
			System.out
					.println("╚═══════════════════════════════════════════════════════════════╝");
			System.out
					.println("\n\n\t\t\t\t[1].변경\n\n\t\t\t\t[2].삭제\n\n\t\t\t\t[3].목록\n\n\t\t\t\t[4].메뉴");
			System.out.print("\n\n\t\t\t\t입력>");

			int input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				return View.EVENT_UPDATE;
			case 2:
				return View.EVENT_DELETE;
			case 3:
				return View.EVENT_LIST;
			case 4:
				return View.ADMINPAGE;
			}

		} else {

			System.out.println("╔═══════════════════════════════════════════════════════════════╗");
			System.out.println("║                                                               ║");
			System.out.println("\t[번호]\t[제목]\t[내용]\t[작성자]\t[작성일]");
			
			System.out.println("\t"+op.get("EVNUM")+"\t"+ op.get("EVTITLE")+"\t"+ op.get("EVCONTENTS")+"\t"+op.get("MEM_ID") +"\t"+ op.get("EVTIME"));
			System.out.println("╚═══════════════════════════════════════════════════════════════╝");
			System.out.println("\n\n\t\t\t\t[1].목록\n\n\t\t\t\t[0].메뉴");
			System.out.print("입력>");
			int input = ScanUtil.nextInt();
			switch (input) {						
			case 1:
				return View.EVENT_LIST;
			case 0:
				return View.MAIN;
		}					
		}
		return View.EVENT_LIST;
	}

	public int Insert() {
		int result;

		System.out.println("---------[ 등록 중 ]----------- ");

		// System.out.println("번호을 입력하세요 ");
		// String num = ScanUtil.nextLine();

		// System.out.println("작성자를 입력하세요 ");

		System.out.println("제목을 입력하세요 ");
		String title = ScanUtil.nextLine();

		System.out.println("내용을 입력하세요 ");
		String board = ScanUtil.nextLine();

		System.out.println("------------------------------------------");
		List<Object> test = new ArrayList<>();
		test.add(title);
		test.add(board);
		result = boardDao.Insert(test);

		if (result > 0) {
			System.out.println("┌-----------------------------------------┐");
			System.out.println("|-----------데이터 생성에 성공했습니다.----------|");
			System.out.println("└-----------------------------------------┘");
		} else {
			System.out.println("┌------------------------------------┐");
			System.out.println("|-----데이터 생성에 실패했습니다.(번호 중복)---|");
			System.out.println("└------------------------------------┘");
		}

		return View.EVENT_LIST;

	}

	public int delete() {
		int result;

		System.out.println("-----------------------------------");
		List<Object> test = new ArrayList<>();
		test.add(currentBoardNo);
		result = boardDao.delete(test);

		if (result > 0) {

			System.out.println("데이터가 삭제되었습니다.");

		} else {
			System.out.println("※※※※※※※※※※데이터 에러※※※※※※※※※※");

		}
		return View.EVENT_LIST;

	}

	public int Update() {
		int result;

		System.out.println("---------[수정]----------- ");
		System.out.println("제목을 입력하세요 ");
		String title = ScanUtil.nextLine();
		System.out.println("내용을 입력하세요 ");
		String board = ScanUtil.nextLine();
		System.out.println("------------------------- ");

		List<Object> test = new ArrayList<>();
		test.add(title);
		test.add(board);
		test.add(currentBoardNo);

		result = boardDao.update(test);
		if (result > 0) {
			System.out.println("데이터가 수정 되었습니다.");
		} else {
			System.out.println("※※※※※※※※※!!오류입니다!!※※※※※※※※※");

		}
		return View.EVENT_LIST;
	}

}
