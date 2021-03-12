package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import service.AdminService;
import service.EventBoardService;
import service.FilmService;
import service.InquiryBoardService;
import service.NoticeBoardService;
import service.QaBoardService;
import service.TicketService;
import service.UserService;
import util.ScanUtil;
import util.View;

public class Controller {

	public static void main(String[] args) {

		/*
		 * 발표 순서 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연 발표 인원 : 발표자 1명, ppt 및 시연
		 * 도우미 1명
		 * 
		 * Controller : 화면 이동 Service : 화면 기능 Dao : 쿼리 작성
		 */

		System.out
				.println("\n\n\n\n\n"
						+ "       ▄█▄      █░█░█ █▀▀ █░░ █▀▀ █▀█ █▀▄▀█ █▀▀   ▀█▀ █▀█   █▀█ █▀▀ ▀█▀ █▀█ █▀█\n"
						+ "     ▄█████▄    ▀▄▀▄▀ ██▄ █▄▄ █▄▄ █▄█ █░▀░█ ██▄   ░█░ █▄█   █▀▄ ██▄ ░█░ █▀▄ █▄█\n"
						+ "    █████████   \n"
						+ "   ███████████      ░█████╗░██╗███╗░░██╗███████╗██████╗░██╗░░██╗██╗██╗░░░░░ \n"
						+ "                    ██╔══██╗██║████╗░██║██╔════╝██╔══██╗██║░░██║██║██║░░░░░\n"
						+ "     ▄█████▄        ██║░░╚═╝██║██╔██╗██║█████╗░░██████╔╝███████║██║██║░░░░░\n"
						+ "    █▀███████       ██║░░██╗██║██║╚████║██╔══╝░░██╔═══╝░██╔══██║██║██║░░░░░\n"
						+ "   ███████████      ╚█████╔╝██║██║░╚███║███████╗██║░░░░░██║░░██║██║███████╗ \n"
						+ "   ▀█████████▀      ░╚════╝░╚═╝╚═╝░░╚══╝╚══════╝╚═╝░░░░░╚═╝░░╚═╝╚═╝╚══════╝ \n"
						+ "    ▀███████▀   \n" + "      ▀▀▀▀▀     \n"
						+ "   ▄▄▄▄▄▄▄▄▄▄▄  \t\tTEN키를 방향키로 사용합니다. \n"
						+ "   ▀█████████▀  \n"
						+ "    ▀███████▀   \t\t▲ (8) : 위로\n"
						+ "      ▀███▀     \t\t● (5) : 선택\n"
						+ "        ▀       \t\t▼ (2) : 아래로\n\n"
						+ "\t\t\t\t5초후 자동으로 스킵됩니다.\n\n");

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		new Controller().start();

	}

	private int home() {
		List<List<Object>> buttons_set = new ArrayList<>();
		List<Object> buttons = new ArrayList<>();
		if (LoginUser == null) {
			String login_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│    로그인       │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
			String join_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   회원가입      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
			buttons.add(login_bt);
			buttons.add(View.LOGIN);
			buttons_set.add(buttons);
			buttons = new ArrayList<>();
			buttons.add(join_bt);
			buttons.add(View.JOIN);
			buttons_set.add(buttons);
		} else if (LoginUser.get("MEM_ID").equals("ADMIN")) { // Map에 있는 문자열
																// 비교할때 사용
			return View.ADMINPAGE;

		}

		else {
			String mypg_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   마이페이지   │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
			String logout_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   로그아웃      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
			buttons = new ArrayList<>();
			buttons.add(mypg_bt);
			buttons.add(View.MYPAGE);
			buttons_set.add(buttons);
			buttons = new ArrayList<>();
			buttons.add(logout_bt);
			buttons.add(View.LOGOUT);
			buttons_set.add(buttons);
		}
		String movie_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   영화정보      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String ticket_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   예매하기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String booked_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   예매확인      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String notice_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│     공지        │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String event_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│    이벤트       │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String faq_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│     FAQ    │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String exit_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│     종료        │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		buttons = new ArrayList<>();
		buttons.add(movie_bt);
		buttons.add(View.FILMLIST);
		buttons_set.add(buttons);
		buttons = new ArrayList<>();
		buttons.add(ticket_bt);
		buttons.add(View.TICKET_HOME);
		buttons_set.add(buttons);
		buttons = new ArrayList<>();
		buttons.add(booked_bt);
		buttons.add(View.BOOK_SEAT); ////////////////////////예약확인페이지
		buttons_set.add(buttons);
		buttons = new ArrayList<>();
		buttons.add(notice_bt);
		buttons.add(View.NOTICE_LIST);
		buttons_set.add(buttons);
		buttons = new ArrayList<>();
		buttons.add(event_bt);
		buttons.add(View.EVENT_LIST);
		buttons_set.add(buttons);
		buttons = new ArrayList<>();
		buttons.add(faq_bt);
		buttons.add(View.QA_LIST);
		buttons_set.add(buttons);
		buttons = new ArrayList<>();
		buttons.add(exit_bt);
		buttons_set.add(buttons);

		int x = 1;

		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		for (int i = 0; i < buttons_set.size(); i++) {
			if (x == i + 1) {
				System.out.println(FilmService.select_bt(buttons_set.get(i)
						.get(0).toString()));
			} else {
				System.out.println(buttons_set.get(i).get(0).toString());
			}
		}
		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t╚═══════════════════════════════════════════════════════════════╝");

		while (true) {
			try {
				int input = ScanUtil.nextInt();
				switch (input) {
				case 2:
					x++;
					if (x > buttons_set.size()) {
						x -= buttons_set.size();
					}

					System.out
							.println("\t╔═══════════════════════════════════════════════════════════════╗");
					System.out
							.println("\t║                                                               ║");
					for (int i = 0; i < buttons_set.size(); i++) {
						if (x == i + 1) {
							System.out.println(FilmService
									.select_bt(buttons_set.get(i).get(0)
											.toString()));
						} else {
							System.out.println(buttons_set.get(i).get(0)
									.toString());
						}
					}
					System.out
							.println("\t║                                                               ║");
					System.out
							.println("\t╚═══════════════════════════════════════════════════════════════╝");
					break;
				case 8:
					x--;
					if (x < 1) {
						x += buttons_set.size();
					}
					System.out
							.println("\t╔═══════════════════════════════════════════════════════════════╗");
					System.out
							.println("\t║                                                               ║");
					for (int i = 0; i < buttons_set.size(); i++) {
						if (x == i + 1) {
							System.out.println(FilmService
									.select_bt(buttons_set.get(i).get(0)
											.toString()));
						} else {
							System.out.println(buttons_set.get(i).get(0)
									.toString());
						}
					}
					System.out
							.println("\t║                                                               ║");
					System.out
							.println("\t╚═══════════════════════════════════════════════════════════════╝");
					break;
				case 5:
					try {
						return (int) buttons_set.get(x - 1).get(1);

					} catch (Exception e) {
						System.out.println("종료되었습니다.");
						System.exit(0);
					}
				}
			} catch (NumberFormatException e) {
			}
		}
	}

	public static Map<String, Object> LoginUser;
	private UserService userService = UserService.getInstance();
	// private BoardService boardService = BoardService.getInstance();
	private FilmService filmService = FilmService.getInstance();
	private TicketService ticketService = TicketService.getInstance();
	private NoticeBoardService boardService = NoticeBoardService.getInstance();
	private EventBoardService eventboardService = EventBoardService
			.getInstance();
	private QaBoardService qaboardService = QaBoardService.getInstance();
	private AdminService adminService = AdminService.getInstance();
	private InquiryBoardService inquiryServie = InquiryBoardService
			.getInstance();

	private void start() {
		int view = View.MAIN;

		while (true) {
			switch (view) {
			case View.MAIN:
				view = home();
				break;
			case View.LOGIN:
				view = userService.login();
				break;
			case View.LOGOUT:
				view = userService.logout();
				break;
			case View.LOGFAIL:
				view = userService.logfail();
				break;
			case View.JOIN:
				view = userService.join();
				break;
			case View.LOGLATER:
				view = filmService.loglater();
				break;
			case View.FINDER:
				view = userService.logFinder();
				break;
			case View.IDFINDER:
				view = userService.findID();
				break;
			case View.PWFINDER:
				view = userService.findPW();
				break;
			case View.FILMLIST:
				view = filmService.movieListSelect();
				break;
			case View.FILMLIST_NOW:
				view = filmService.movieListSelect_now();
				break;
			case View.FILMLIST_COM:
				view = filmService.movieListSelect_com();
				break;
			case View.FILMLIST_ALL:
				view = filmService.movieListSelect_all();
				break;
			case View.FILMINFO:
				view = filmService.movieSelect();
				break;
			case View.FILM_COMMENTS:
				view = filmService.commentsSelect();
				break;
			case View.FILM_MYCOMMENTS:
				view = filmService.myComments();
				break;
			case View.COMMENTS_INSERT:
				view = filmService.insertComments();
				break;
			case View.COMMENTS_UPDATE:
				view = filmService.updateComments();
				break;
			case View.COMMENTS_DELETE:
				view = filmService.deleteComments();
				break;
			case View.TICKET_HOME:
				view = ticketService.Main();
				break;
			case View.TICKET_CINEMA:
				view = ticketService.TICKET_CINEMA();
				break;
			case View.TICKET_TIME:
				view = ticketService.TICKET_TIME();
				break;
			case View.TICKET_BOOKING:
				view = ticketService.TICKET_BOOKING();
				break;
			case View.TICKET_SEAT:
				view = ticketService.TICKET_SEAT();
				break;
			case View.BOOK_SEAT:
				view = ticketService.tk_chek();
				break;
			case View.NOTICE_LIST:
				view = boardService.boardList();
				break;
			case View.NOTICE_SELECT:
				view = boardService.Look();
				break;
			case View.NOTICE_INSERT_FORM:
				view = boardService.Insert();
				break;// 관리자
			case View.NOTICE_DELETE:
				view = boardService.delete();
				break;
			case View.NOTICE_UPDATE:
				view = boardService.Update();
				break;
			case View.EVENT_LIST:
				view = eventboardService.boardList();
				break;
			case View.EVENT_SELECT:
				view = eventboardService.Look();
				break;

			case View.QA_LIST:
				view = qaboardService.boardList();
				break;
			case View.QA_LIST_SELECT:
				view = qaboardService.Look();
				break;
			case View.QA_INSERT_FORM:
				view = qaboardService.Insert();
				break;
			case View.QA_DELETE:
				view = qaboardService.delete();
				break;
			case View.QA_UPDATE:
				view = qaboardService.Update();
				break;// 여기까지 관리자 등록 삭제 변경
			case View.EVENT_INSERT_FORM:
				view = eventboardService.Insert();
				break;
			case View.EVENT_DELETE:
				view = eventboardService.delete();
				break;
			case View.EVENT_UPDATE:
				view = eventboardService.Update();
				break;
			case View.MYPAGE:
				view = userService.accountSettings();
				break;
				// ---------------------관리자----------------------------------//

			case View.ADMINPAGE:
				view = adminhome();
				break;// 관리자 페이지
			case View.ADMINMOVIE:
				view = adminService.movie_info();
				break; // 영화정보 관리
			case View.ADMINCINEMA:
				view = adminService.CINEMA_INFO();
				break; // 상영지점 관리
			case View.ADMINBOARD:
				view = adminhome();
				break; // 이벤트및 공지사항
			case View.ADMINMEMBER:
				view = adminService.memList();
				break;// 회원관리
//			case View.ADMINBOOKING:
//				view = adminhome();
//				break; // 결제관리

			case View.INQUIRY_LIST:
				view = inquiryServie.boardList();
				break; // 1:1문의 리스트
			case View.INQUIRY_SELECT:
				view = inquiryServie.Look();
				break; // 1:1문의 글조회
			case View.INQUIRY_INSERT_FORM:
				view = inquiryServie.Insert();
				break; // 1:1글쓰기
			case View.INQUIRY_ANSWER:
				view = inquiryServie.answerUpdate();
				break; // 1:1답변
			case View.INQUIRY_ANSWERLIST:
				view = inquiryServie.answerList();
				break;

			}
		}

	}

	private int adminhome() {

		System.out
				.println("-------------------------------[관리자 페이지]-----------------------------------");
		System.out.println();
/*		System.out
				.println("\t\t\t\t[1].영화정보\n\n\t\t\t\t[2].상영지점 관리\n\n\t\t\t\t[3].이벤트/공지사항\n\n\t\t\t\t["
						+ "4].회원관리\n\n\t\t\t\t[5].결제 내역 관리\n\n\t\t\t\t[6] 1 대 1 문의\n\n\t\t\t\t[0].로그아웃");
		System.out.println();
*/		System.out
		.println("\t\t\t\t[1].영화정보\n\n\t\t\t\t[2].상영지점 관리\n\n\t\t\t\t[3].이벤트/공지사항/FAQ\n\n\t\t\t\t["
				+ "4].회원관리\n\n\t\t\t\t[5] 1 대 1 문의\n\n\t\t\t\t[0].로그아웃");
		System.out.println();
		System.out
				.println("---------------------------------------------------------------------------");

		System.out.print("번호 입력>");

		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			return View.ADMINMOVIE;
		case 2:
			return View.ADMINCINEMA;
		case 3:
			System.out
					.println("-----------------------------[이벤트/공지사항/FAQ]------------------------------------");
			System.out.println();
			System.out
					.println("\t\t\t\t[1].공지\n\n\t\t\t\t[2].이벤트\n\n\t\t\t\t[3].FAQ\n\n\t\t\t\t[0].관리자 메인메뉴");
			System.out.println();
			System.out
					.println("----------------------------------------------------------------------------");
			System.out.print("번호 입력>");
			int num = ScanUtil.nextInt();
			switch (num) {
			case 1:
				return View.NOTICE_LIST;
			case 2:
				return View.EVENT_LIST;
			case 3:
				return View.QA_LIST;

			case 0:
				System.out.println("프로그램이 종료됨");

				return View.ADMINPAGE;

			}

			return View.ADMINBOARD;
		case 4:
			return View.ADMINMEMBER;
		case 5:
			return View.INQUIRY_LIST;

		case 0:
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("\t\t\t\t관리자 로그아웃");
			System.out.println("----------------------------------------------------------------------------");
			LoginUser = null;
			return View.MAIN;

		}
		return View.MAIN;
	}

}
