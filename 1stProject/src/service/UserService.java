package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.Validation;
import util.View;
import controller.Controller;
import dao.UserDao;

public class UserService {

	private static UserService instance;

	private UserService() {
	}

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	private UserDao userDao = UserDao.getInstance();
	private String user_id;

	public int join() {
		List<Object> p = new ArrayList<>();
		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		System.out.println("\t║\t\t\t[   회원가입      ]\t\t\t\t║");
		System.out
				.println("\t║                                                               ║");
		System.out
				.print("\t║\t      ID\t: 영어소문자와 숫자로 이루어진 12자 이내\t\t║\n\t\t\t ");
		String ID = ScanUtil.nextLine();
		p.add(ID);
		do {
			if (userDao.checkID(p).size() > 0) {
				System.out
						.print("\t║\t\t중복된 닉네임입니다. 새로운 아이디를 입력하세요\t\t║\n\t\t\t");
				p.remove(0);
				ID = ScanUtil.nextLine();
				p.add(ID);
			}
		} while (userDao.checkID(p).size() > 0);
		ID = Validation.ALNU(ID);

		System.out.print("\t║\t      PW\t: 영대소문자 특문 12자 이내\t\t\t║\n\t\t\t ");
		String PW = ScanUtil.nextLine();
		String PW2 = "";
		do {
			System.out.print("\t║\t      PW\t: 비밀번호 확인\t\t\t\t║\n\t\t\t ");
			PW2 = ScanUtil.nextLine();
		} while (!PW.equals(PW2));
		System.out.println("\t║\t\t\t   ✔ 입력 성공\t\t\t\t║");
		System.out.print("\t║\t      NAME\t: 한글 10자 이내\t\t\t\t║\n\t\t\t ");
		String NAME = ScanUtil.nextLine();
		NAME = Validation.KOR(NAME);
		System.out.print("\t║\t      PHONE\t: 연락처\t\t\t\t\t║\n\t\t\t ");
		String PN = ScanUtil.nextLine();
		PN = Validation.PN(PN);
		PN = PN.replace(".", "");
		PN = PN.replace("-", "");
		System.out.print("\t║\t      BIRTH\t: 생년월일 8자리\t\t\t\t║\n\t\t\t ");
		String birth = ScanUtil.nextLine();
		birth = Validation.DATE(birth);
		birth = birth.replace(".", "");
		birth = birth.replace("-", "");
		int yyyy = Integer.parseInt(birth.substring(0, 4));
		int mm = Integer.parseInt(birth.substring(4, 6));
		int dd = Integer.parseInt(birth.substring(6, 8));
		Date BIRTH = new Date(yyyy - 1900, mm - 1, dd);

		p.add(PW);
		p.add(NAME);
		p.add(PN);
		p.add(BIRTH);
		int result = 0;
		try {
			result = userDao.insertUser(p);
		} catch (Exception e) {
		}
		try {
			Thread.sleep(2500);
		} catch (Exception e) {
		}
		if (result > 0) {
			System.out
					.println("\t║                                                               ║");
			System.out.println("\t║\t\t\t[   가입 성공      ]\t\t\t\t║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t╚═══════════════════════════════════════════════════════════════╝");
		} else {
			System.out.println("\t║\t\t[   가입 실패 : 동일한 아이디가 존재합니다      ]\t\t║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t╚═══════════════════════════════════════════════════════════════╝");
		}
		return View.MAIN;
	}

	public int login() {
		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t║                                                               ║");
		System.out.println("\t║\t\t\t[    로그인        ]\t\t\t\t║");
		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t║                                                               ║");
		System.out
				.print("\t║\t      ID\t: 영어소문자와 숫자로 이루어진 12자 이내\t\t║\n\t\t\t ");
		String ID = ScanUtil.nextLine();
		System.out.print("\t║\t      PW\t: 비밀번호 확인\t\t\t\t║\n\t\t\t ");
		String PW = ScanUtil.nextLine();

		List<Object> param = new ArrayList<>();
		param.add(ID);
		param.add(PW);

		Map<String, Object> user = userDao.selectUser(param);

		if (user.size() == 0) {
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t║\t[   로그인 실패 : 아이디 혹은 비밀 번호를 잘못 입력하셨습니다.   ]\t║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t╚═══════════════════════════════════════════════════════════════╝");
			try {
				Thread.sleep(2500);
			} catch (Exception e) {
			}
			return View.LOGFAIL;
		} else {
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t║                                                               ║");
			System.out.println("\t║\t\t\t[   로그인 성공     ]\t\t\t\t║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t╚═══════════════════════════════════════════════════════════════╝");
			Controller.LoginUser = user;
		}
		try {
			Thread.sleep(2500);
		} catch (Exception e) {
		}
		return FilmService.lastpage;
	}

	public int logfail() {
		String join_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   회원가입      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String login_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│    로그인       │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String logout_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│  ID/PW찾기    │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String main_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   돌아가기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		List<String> buttons = new ArrayList<>();
		buttons.add(join_bt);
		buttons.add(login_bt);
		buttons.add(logout_bt);
		buttons.add(main_bt);
		int x = 1;
		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		FilmService.selecter(buttons, x);

		while (true) {
			int input = ScanUtil.nextInt();
			switch (input) {
			case 2:
				x++;
				if (x > buttons.size()) {
					x -= buttons.size();
				}
				System.out
						.println("\t╔═══════════════════════════════════════════════════════════════╗");
				System.out
						.println("\t║                                                               ║");
				FilmService.selecter(buttons, x);

				break;
			case 8:
				x--;
				if (x < 1) {
					x += buttons.size();
				}
				System.out
						.println("\t╔═══════════════════════════════════════════════════════════════╗");
				System.out
						.println("\t║                                                               ║");
				FilmService.selecter(buttons, x);
				break;
			case 5:
				switch (x) {
				case 1:
					return View.JOIN;
				case 2:
					return View.LOGIN;
				case 3:
					return View.FINDER;
				case 4:
					return FilmService.lastpage;
				}
			}
		}

	}

	public int logFinder() {

		String id_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   ID 찾기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String pw_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   PW 찾기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String login_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│    로그인       │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";

		List<String> buttons = new ArrayList<>();
		buttons.add(id_bt);
		buttons.add(pw_bt);
		buttons.add(login_bt);

		int x = 1;
		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		FilmService.selecter(buttons, x);

		while (true) {
			int input = ScanUtil.nextInt();
			switch (input) {
			case 2:
				x++;
				if (x > buttons.size()) {
					x -= buttons.size();
				}
				System.out
						.println("\t╔═══════════════════════════════════════════════════════════════╗");
				System.out
						.println("\t║                                                               ║");
				FilmService.selecter(buttons, x);
				break;
			case 8:
				x--;
				if (x < 1) {
					x += buttons.size();
				}
				System.out
						.println("\t╔═══════════════════════════════════════════════════════════════╗");
				System.out
						.println("\t║                                                               ║");
				FilmService.selecter(buttons, x);
				break;
			case 5:
				switch (x) {
				case 1:
					return View.IDFINDER;
				case 2:
					return View.PWFINDER;
				case 3:
					return View.LOGIN;
				}
			}
		}
	}

	public int findID() {
		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		System.out.println("\t║\t\t\t  [ 아이디 찾기  ]\t\t\t\t║");
		System.out
				.println("\t║                                                               ║");
		System.out.print("\t║\t\t\t    이름 :  ");
		String name = ScanUtil.nextLine();
		System.out.println();
		System.out.print("\t║\t\t\t    연락처 :  ");
		String pn = ScanUtil.nextLine();
		pn = pn.replace(".", "");
		pn = pn.replace("-", "");
		System.out.println();
		List<Object> param = new ArrayList<>();
		param.add(name);
		param.add(pn);
		Map<String, Object> user = userDao.idfinder(param);
		if (user.size() > 0) {
			System.out.print("\t║\t\t\t    ID : "
					+ user.get("MEM_ID").toString().substring(0, 2));
			for (int j = 2; j < user.get("MEM_ID").toString().length(); j++) {
				System.out.print("*");
			}
			System.out.println("\t\t\t║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t╚═══════════════════════════════════════════════════════════════╝");
		} else {
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t║                    일치하는 아이디가 없습니다.                       ║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t╚═══════════════════════════════════════════════════════════════╝");
		}
		return View.FINDER;
	}

	public int findPW() {
		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		System.out.println("\t║\t\t\t [ 비밀번호 찾기  ]\t\t\t\t║");
		System.out
				.println("\t║                                                               ║");
		System.out.print("\t║\t\t\t    ID :  ");
		String id = ScanUtil.nextLine();
		System.out.println();
		System.out.print("\t║\t\t\t    이름 :  ");
		String name = ScanUtil.nextLine();
		System.out.println();
		System.out.print("\t║\t\t\t    연락처 :  ");
		String pn = ScanUtil.nextLine();
		pn = pn.replace(".", "");
		pn = pn.replace("-", "");
		System.out.println();
		List<Object> param = new ArrayList<>();
		param.add(id);
		param.add(name);
		param.add(pn);
		Map<String, Object> user = userDao.pwfinder(param);
		if (user.size() > 0) {
			System.out.print("\t║\t\t\t    PW : "
					+ user.get("MEM_PW").toString().substring(0, 2));
			for (int j = 2; j < user.get("MEM_PW").toString().length(); j++) {
				System.out.print("*");
			}
			System.out.println("\t\t\t║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t╚═══════════════════════════════════════════════════════════════╝");
		} else {
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t║                    일치하는 아이디가 없습니다.                       ║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t╚═══════════════════════════════════════════════════════════════╝");
		}
		return View.FINDER;
	}

	public int logout() {

		String logout_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   로그아웃      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String main_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   돌아가기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		List<String> buttons = new ArrayList<>();
		buttons.add(logout_bt);
		buttons.add(main_bt);
		int x = 1;
		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		System.out.println("\t║\t\t              로그아웃 하시겠습니까?\t\t\t\t║");
		System.out
				.println("\t║                                                               ║");

		FilmService.selecter(buttons, x);

		while (true) {
			int input = ScanUtil.nextInt();
			switch (input) {
			case 2:
				x++;
				if (x > buttons.size()) {
					x -= buttons.size();
				}
				System.out
						.println("\t╔═══════════════════════════════════════════════════════════════╗");
				System.out
						.println("\t║                                                               ║");
				System.out
						.println("\t║\t\t              로그아웃 하시겠습니까?\t\t\t\t║");
				System.out
						.println("\t║                                                               ║");
				FilmService.selecter(buttons, x);
				break;
			case 8:
				x--;
				if (x < 1) {
					x += buttons.size();
				}
				System.out
						.println("\t╔═══════════════════════════════════════════════════════════════╗");
				System.out
						.println("\t║                                                               ║");
				System.out
						.println("\t║\t\t              로그아웃 하시겠습니까?\t\t\t\t║");
				System.out
						.println("\t║                                                               ║");
				FilmService.selecter(buttons, x);
				break;
			case 5:
				switch (x) {
				case 1:
					Controller.LoginUser = null;
					return View.MAIN;
				case 2:
					return View.MAIN;
				}
			}
		}
	}

	// --------------------------------------------------------------------------

	public int accountSettings() {

		user_id = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> list = new ArrayList<Object>();
		list.add(user_id);

		List<Map<String, Object>> boardList = userDao.bookingList(list);
		System.out.println("----------------------------------------");
		System.out
				.println("\n\n\t\t\t\t[1].마일리지 \n\n\t\t\t\t[2].예매권 결제내역\n\n\t\t\t\t"
						+ "[3].내 정보 수정\n\n\t\t\t\t[4].1 대 1 문의\n\n\t\t\t\t[5]메인 메뉴");
		System.out.print("\n\n\t\t\t\t입력>");
		int input1 = ScanUtil.nextInt();
		switch (input1) {
		case 1:
			// 마일리지 조회
			// System.out.println("회원님의 마일리지 : "+password.get("MEM_ACC"));break;
			Map<String, Object> op = userDao.mem_mil(list);
			System.out.println("\t\t\t회원님의 마일리지 : " + op.get("MEM_MIL")
					+ " 입니다.");
			return View.MYPAGE;

		case 2:
			System.out.println();
			System.out
					.println("------------------------------------------------------------------------------");
			System.out.println("아이디\t영화관\t\t 예매번호\t\t\t영화이름\t\t결제금액\t 결제방법");
			System.out
					.println("------------------------------------------------------------------------------");

			for (int i = 0; i < boardList.size(); i++) {
				Map<String, Object> booking = boardList.get(i);
				System.out.println(booking.get("MEM_ID") + "\t"
						+ booking.get("CINEMANAME") + "\t"
						+ booking.get("BOOKCODE") + "   "
						+ booking.get("FILMNAME") + "\t"
						+ booking.get("TOTALPRICE") + "\t"
						+ booking.get("PAYMENT"));
			}
			System.out
					.println("------------------------------------------------------------------------------\n");
			return View.MYPAGE;
		case 3:
            System.out.println("\n\n\t\t\t\t[1].변경\n\n\t\t\t\t[2].삭제\n\n\t\t\t\t[0].마이페이지");
            System.out.print("\n\n\t\t\t\t입력>");
            int input4 = ScanUtil.nextInt();
               switch(input4){
               case 1: mypage_update(); break;
               case 2: mem_delete(); break;
               case 0: return View.MYPAGE;
            }
		case 4:
			// 1대1 문의 게시판.

			return View.INQUIRY_LIST;

		case 5:
			return View.MAIN;

		}
		return View.MYPAGE;

	}

	public void mem_delete() {
		user_id = Controller.LoginUser.get("MEM_ID").toString();
		List<Object> test = new ArrayList<>();
		test.add(user_id);
		int result = userDao.mem_delete(test);

		if (result > 0) {
			System.out.println("데이터가 삭제되었습니다.");
		} else {
			System.out.println("※※※※※※데이터 에러※※※※※※※");
		}

	}

	public void mypage_update() {
		user_id = Controller.LoginUser.get("MEM_ID").toString();
		System.out.println("\n\n\t\t\t\tPW : 영대소문자 특문 12자 이내.\t\t │");
		System.out.print("\n\n\t\t\t\t입력>");
		String PW = ScanUtil.nextLine();

		System.out.println("\n\n\t\t\t\t변경하실 연락처 입력");
		System.out.print("\n\n\t\t\t\t입력>");
		String PN = ScanUtil.nextLine();
		PN = Validation.PN(PN);

		List<Object> test = new ArrayList<>();

		test.add(PW);
		test.add(PN);
		test.add(user_id);

		int result = userDao.mem_update(test);

		if (result > 0) {
			System.out.println("\n\n\t\t\t\t변경되었습니다");
		} else {
			System.out.println("\n\n\t\t\t\t변경 실패 !");
		}

	}

}
