package util;

public class View {

	public static final int MAIN = 0; // 메인
	
	public static final int FILMLIST= 1; // 영화 정보 페이지
	public static final int FILMLIST_NOW= 110; // 영화 정보 페이지
	public static final int FILMLIST_COM= 120; // 영화 정보 페이지
	public static final int FILMLIST_ALL= 130; // 영화 정보 페이지
	public static final int FILMINFO = 2; // 상영예정작 페이지
	public static final int FILM_COMMENTS = 3; // 영화당 댓글페이지
	public static final int COMMENTS_INSERT = 310; // 영화당 댓글페이지
	public static final int FILM_MYCOMMENTS = 311; // 영화당 댓글페이지
	public static final int COMMENTS_UPDATE = 320; // 영화당 댓글페이지
	public static final int COMMENTS_DELETE = 330; // 영화당 댓글페이지
//	public static final int COMMENTLIST = 15; // 댓글리스트
	

	public static final int BOOK_FILM = 4; // 영화 선택
	public static final int BOOK_CINEMA = 5; // 상영지점 선택
	public static final int BOOK_TIME = 6; // 상영시간 선택
	public static final int BOOK_SEAT = 7; // 좌석 선택

	public static final int NOTICE_LIST = 8; // 공지
	public static final int NOTICE_SELECT = 81; // 공지조회
	public static final int NOTICE_INSERT_FORM = 82;  // 공지등록
	public static final int NOTICE_UPDATE = 83;		// 공지 업데이트
	public static final int NOTICE_DELETE = 84;       // 공지 삭제 

	public static final int EVENT_LIST = 9; // 이벤트
	public static final int EVENT_SELECT = 91; // 이벤트조회
	public static final int EVENT_INSERT_FORM = 92;  // 이벤트등록
	public static final int EVENT_UPDATE = 93;		// 이벤트 업데이트
	public static final int EVENT_DELETE = 94;       // 이벤삭제 
	
	public static final int QA_LIST = 10; // QA
	public static final int QA_LIST_SELECT = 101; // QA
	public static final int QA_INSERT_FORM = 102; // QA
	public static final int QA_UPDATE = 103; // QA
	public static final int QA_DELETE = 104; // QA

	public static final int LOGIN = 12; // 로그인
	public static final int LOGOUT = 121; // 로그아웃
	public static final int LOGFAIL = 122; // 로그인 실패
	public static final int LOGLATER = 123; //  중도로그인
	public static final int FINDER = 124; //  중도로그인
	public static final int IDFINDER = 1241; //  ID찾기
	public static final int PWFINDER = 1242; //  ID찾기
	public static final int JOIN = 13; // 가입
	public static final int MYPAGE = 14; // 마이페이지

	public static final int TICKET_HOME = 15; // 티켓의 메인
	public static final int TICKET_CINEMA = 16; // 상영관 선택
	public static final int TICKET_FILM = 17; // 상영 영화 선택
	public static final int TICKET_TIME = 18; // 상영 시간
	public static final int TICKET_BOOKING = 19;
	public static final int TICKET_CASH = 20; // 상영 시간
	public static final int TICKET_SEAT = 21; // 좌석 선택

	public static final int ADMINPAGE = 999;
	public static final int ADMINMOVIE = 998;
	public static final int ADMINCINEMA = 997;
	public static final int ADMINBOARD = 996;
	public static final int ADMINMEMBER = 995;
	public static final int ADMINBOOKING = 994;
	
	public static final int INQUIRY_LIST = 30; // 1:1
	public static final int INQUIRY_SELECT = 31; // 1:1

	public static final int INQUIRY_INSERT_FORM = 32; // 1:1
	public static final int INQUIRY_UPDATE = 33; // 1:1
	public static final int INQUIRY_DELETE = 34; // 1:1
	public static final int INQUIRY_ANSWER = 35; // 1:1
	public static final int INQUIRY_ANSWERLIST = 36; // 1:1


}
