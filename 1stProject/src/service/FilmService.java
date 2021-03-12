package service;

import java.awt.Desktop;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.UIUtil;
import util.Validation;
import util.View;
import controller.Controller;
import dao.FilmDao;

public class FilmService {

	private static FilmService instance;

	private FilmService() {
	}

	public static FilmService getInstance() {
		if (instance == null) {
			instance = new FilmService();
		}
		return instance;
	}

	public static int lastpage;

	private FilmDao filmDao = FilmDao.getInstance();

	private int filmcode;

	public static void selecter(List<String> buttons, int x) {

		for (int i = 0; i < buttons.size(); i++) {
			if (x == i + 1) {
				System.out.println(select_bt(buttons.get(i).toString()));
			} else {
				System.out.println(buttons.get(i));
			}
		}

		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t╚═══════════════════════════════════════════════════════════════╝");
	}

public int movieListSelect() {
		
		List<String> buttons = new ArrayList<>();
		String mnow_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│  상영 중 영화   │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String mcom_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│ 상영 예정 영화  │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String mall_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   전체 영화     │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String back_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   돌아가기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";

		buttons.add(mnow_bt);
		buttons.add(mcom_bt);
		buttons.add(mall_bt);
		buttons.add(back_bt);

		int x = 1;
		
		String header = "\t╔═══════════════════════════════════════════════════════════════╗\n"
				+ "\t║                                                               ║";
		String end = "\t║                                                               ║\n"
				+ "\t╚═══════════════════════════════════════════════════════════════╝";
		x = UIUtil.chooser(buttons, x, header,end);
		switch (x) {
		case 1:
			return View.FILMLIST_NOW;
		case 2:
			return View.FILMLIST_COM;
		case 3:
			return View.FILMLIST_ALL;
		case 4:
			return View.MAIN;
		}
		return View.MAIN;
	}

	public int movieListSelect_now() {

		List<String> selectmov = new ArrayList<>();
		List<Map<String, Object>> movielist = filmDao.selectMovielist_now();
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		for (int i = 0; i < movielist.size(); i++) {
			String filmname = "";
			if (movielist.get(i).get("FILMNAME").toString().length() > 10) {
				filmname = movielist.get(i).get("FILMNAME").toString()
						.substring(0, 9)
						+ "…";
			} else {
				filmname = movielist.get(i).get("FILMNAME").toString();
			}
			String temp = "    ║ ┌────────────────────────────────────────────────────────────────────┐ ║\n"
					+ "    ║ │"
					+ listspace(filmname)
					+ filmname
					+ "\t"
					+ movielist.get(i).get("FILMRATING").toString()
					+ "        "
					+ movielist.get(i).get("COUNTRY")
					+ "\t      "
					+ movielist.get(i).get("GENRE")
					+ listspace(movielist.get(i).get("GENRE").toString())
					+ "\t"
					+ format.format(movielist.get(i).get("RELEASEDATE"))
					+ " │ ║\n"
					+ "    ║ └────────────────────────────────────────────────────────────────────┘ ║";
			selectmov.add(temp);
		}
		String temp = "    ║ ┌────────────────────────────────────────────────────────────────────┐ ║\n"
				+ "    ║ │\t\t\t\t    돌아가기\t\t\t\t   │ ║\n"
				+ "    ║ └────────────────────────────────────────────────────────────────────┘ ║";
		selectmov.add(temp);

		int x = 1;
		System.out
				.println("    ╔════════════════════════════════════════════════════════════════════════╗");
		System.out
				.println("    ║       영화제목\t      등급\t         국가\t             장르\t         개봉일                        ║");
		for (int i = 0; i < selectmov.size(); i++) {
			if (x == i + 1) {
				System.out.println(select_bt(selectmov.get(i)));
			} else {
				System.out.println(selectmov.get(i));
			}
		}
		System.out
				.println("    ╚════════════════════════════════════════════════════════════════════════╝");

		while (true) {
			int input = ScanUtil.nextInt();
			switch (input) {
			case 2:
				x++;
				if (x > selectmov.size()) {
					x -= selectmov.size();
				}
				System.out
						.println("    ╔════════════════════════════════════════════════════════════════════════╗");
				System.out
						.println("    ║  번호          영화제목\t      등급\t         국가\t              장르\t         개봉일                        ║");
				for (int i = 0; i < selectmov.size(); i++) {
					if (x == i + 1) {
						System.out.println(select_bt(selectmov.get(i)));
					} else {
						System.out.println(selectmov.get(i));
					}
				}

				System.out
						.println("    ╚════════════════════════════════════════════════════════════════════════╝");
				break;
			case 8:
				x--;
				if (x < 1) {
					x += selectmov.size();
				}
				System.out
						.println("    ╔════════════════════════════════════════════════════════════════════════╗");
				System.out
						.println("    ║  번호          영화제목\t      등급\t         국가\t              장르\t         개봉일                        ║");
				for (int i = 0; i < selectmov.size(); i++) {
					if (x == i + 1) {
						System.out.println(select_bt(selectmov.get(i)));
					} else {
						System.out.println(selectmov.get(i));
					}
				}
				System.out
						.println("    ╚════════════════════════════════════════════════════════════════════════╝");
				break;
			case 5:
				if (0 < x && x < selectmov.size()) {
					filmcode = ((BigDecimal) movielist.get(x - 1).get(
							"FILMCODE")).intValue();
					lastpage = View.FILMLIST_NOW;
					return View.FILMINFO;
				} else
					return View.FILMLIST;
			}
		}
	}

	public int movieListSelect_com() {

		List<String> selectmov = new ArrayList<>();
		List<Map<String, Object>> movielist = filmDao.selectMovielist_coming();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		for (int i = 0; i < movielist.size(); i++) {
			String filmname = "";
			String releasedate =""; 
			if (movielist.get(i).get("FILMNAME").toString().length() > 10) {
				filmname = movielist.get(i).get("FILMNAME").toString()
						.substring(0, 9)
						+ "…";
			} else {
				filmname = movielist.get(i).get("FILMNAME").toString();
			}
			if(((BigDecimal)movielist.get(i).get("D_DAY")).intValue()>=10){
				 releasedate = "\t미정\t  ";
			}else{
				releasedate = format.format(movielist.get(i).get("RELEASEDATE"));
			}
			String temp = "    ║ ┌────────────────────────────────────────────────────────────────────┐ ║\n"
					+ "    ║ │"
					+ listspace(filmname)
					+ filmname
					+ "\t"
					+ movielist.get(i).get("FILMRATING").toString()
					+ "        "
					+ movielist.get(i).get("COUNTRY")
					+ "\t      "
					+ movielist.get(i).get("GENRE")
					+ listspace(movielist.get(i).get("GENRE").toString())
					+ "\t"
					+ releasedate
					+ " │ ║\n"
					+ "    ║ └────────────────────────────────────────────────────────────────────┘ ║";
			selectmov.add(temp);
		}
		String temp = "    ║ ┌────────────────────────────────────────────────────────────────────┐ ║\n"
				+ "    ║ │\t\t\t\t    돌아가기\t\t\t\t   │ ║\n"
				+ "    ║ └────────────────────────────────────────────────────────────────────┘ ║";
		selectmov.add(temp);

		int x = 1;
		System.out
				.println("    ╔════════════════════════════════════════════════════════════════════════╗");
		System.out
				.println("    ║       영화제목\t      등급\t         국가\t             장르\t         개봉일                        ║");
		for (int i = 0; i < selectmov.size(); i++) {
			if (x == i + 1) {
				System.out.println(select_bt(selectmov.get(i)));
			} else {
				System.out.println(selectmov.get(i));
			}
		}
		System.out
				.println("    ╚════════════════════════════════════════════════════════════════════════╝");

		while (true) {
			int input = ScanUtil.nextInt();
			switch (input) {
			case 2:
				x++;
				if (x > selectmov.size()) {
					x -= selectmov.size();
				}
				System.out
						.println("    ╔════════════════════════════════════════════════════════════════════════╗");
				System.out
						.println("    ║  번호          영화제목\t      등급\t         국가\t              장르\t         개봉일                        ║");
				for (int i = 0; i < selectmov.size(); i++) {
					if (x == i + 1) {
						System.out.println(select_bt(selectmov.get(i)));
					} else {
						System.out.println(selectmov.get(i));
					}
				}

				System.out
						.println("    ╚════════════════════════════════════════════════════════════════════════╝");
				break;
			case 8:
				x--;
				if (x < 1) {
					x += selectmov.size();
				}
				System.out
						.println("    ╔════════════════════════════════════════════════════════════════════════╗");
				System.out
						.println("    ║  번호          영화제목\t      등급\t         국가\t              장르\t         개봉일                        ║");
				for (int i = 0; i < selectmov.size(); i++) {
					if (x == i + 1) {
						System.out.println(select_bt(selectmov.get(i)));
					} else {
						System.out.println(selectmov.get(i));
					}
				}
				System.out
						.println("    ╚════════════════════════════════════════════════════════════════════════╝");
				break;
			case 5:
				if (0 < x && x < selectmov.size()) {
					filmcode = ((BigDecimal) movielist.get(x - 1).get(
							"FILMCODE")).intValue();
					lastpage = View.FILMLIST_COM;
					return View.FILMINFO;
				} else
					return View.FILMLIST;
			}
		}
	}

	public int movieListSelect_all() {

		List<String> selectmov = new ArrayList<>();
		List<Map<String, Object>> movielist = filmDao.selectMovielist();
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		for (int i = 0; i < movielist.size(); i++) {
			String filmname = "";
			if (movielist.get(i).get("FILMNAME").toString().length() > 10) {
				filmname = movielist.get(i).get("FILMNAME").toString()
						.substring(0, 9)
						+ "…";
			} else {
				filmname = movielist.get(i).get("FILMNAME").toString();
			}
			String temp = "    ║ ┌────────────────────────────────────────────────────────────────────┐ ║\n"
					+ "    ║ │"
					+ listspace(filmname)
					+ filmname
					+ "\t"
					+ movielist.get(i).get("FILMRATING").toString()
					+ "        "
					+ movielist.get(i).get("COUNTRY")
					+ "\t      "
					+ movielist.get(i).get("GENRE")
					+ listspace(movielist.get(i).get("GENRE").toString())
					+ "\t"
					+ format.format(movielist.get(i).get("RELEASEDATE"))
					+ " │ ║\n"
					+ "    ║ └────────────────────────────────────────────────────────────────────┘ ║";
			selectmov.add(temp);
		}
		String temp = "    ║ ┌────────────────────────────────────────────────────────────────────┐ ║\n"
				+ "    ║ │\t\t\t\t    돌아가기\t\t\t\t   │ ║\n"
				+ "    ║ └────────────────────────────────────────────────────────────────────┘ ║";
		selectmov.add(temp);

		
		
		
		int x = 1;
		System.out
				.println("    ╔════════════════════════════════════════════════════════════════════════╗");
		System.out
				.println("    ║       영화제목\t      등급\t         국가\t             장르\t         개봉일                        ║");
		for (int i = 0; i < selectmov.size(); i++) {
			if (x == i + 1) {
				System.out.println(select_bt(selectmov.get(i)));
			} else {
				System.out.println(selectmov.get(i));
			}
		}
		System.out
				.println("    ╚════════════════════════════════════════════════════════════════════════╝");

		while (true) {
			int input = ScanUtil.nextInt();
			switch (input) {
			case 2:
				x++;
				if (x > selectmov.size()) {
					x -= selectmov.size();
				}
				System.out
						.println("    ╔════════════════════════════════════════════════════════════════════════╗");
				System.out
						.println("    ║  번호          영화제목\t      등급\t         국가\t              장르\t         개봉일                        ║");
				for (int i = 0; i < selectmov.size(); i++) {
					if (x == i + 1) {
						System.out.println(select_bt(selectmov.get(i)));
					} else {
						System.out.println(selectmov.get(i));
					}
				}

				System.out
						.println("    ╚════════════════════════════════════════════════════════════════════════╝");
				break;
			case 8:
				x--;
				if (x < 1) {
					x += selectmov.size();
				}
				System.out
						.println("    ╔════════════════════════════════════════════════════════════════════════╗");
				System.out
						.println("    ║  번호          영화제목\t      등급\t         국가\t              장르\t         개봉일                        ║");
				for (int i = 0; i < selectmov.size(); i++) {
					if (x == i + 1) {
						System.out.println(select_bt(selectmov.get(i)));
					} else {
						System.out.println(selectmov.get(i));
					}
				}
				System.out
						.println("    ╚════════════════════════════════════════════════════════════════════════╝");
				break;
			case 5:
				if (0 < x && x < selectmov.size()) {
					filmcode = ((BigDecimal) movielist.get(x - 1).get(
							"FILMCODE")).intValue();
					lastpage = View.FILMLIST_ALL;
					return View.FILMINFO;
				} else
					return View.FILMLIST;
			}
		}
	}

	public Map<String, Object> movieCall() {
		List<Object> p = new ArrayList<>();
		p.add(filmcode);
		Map<String, Object> filmInfo = filmDao.selectMovieInfo(p);
		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		System.out.print("\t║  " + filmInfo.get("FILMRATING").toString());
		spaceL(filmInfo.get("FILMRATING").toString());
		System.out.print(filmInfo.get("FILMNAME"));
		spaceL(filmInfo.get("FILMNAME").toString());
		System.out.print("\t\t");
		System.out.println(filmInfo.get("RUNTIME").toString() + "분" + "\t║");

		System.out
				.println("\t║                                                               ║");
		System.out.print("\t║  " + filmInfo.get("GENRE"));
		spaceL(filmInfo.get("GENRE").toString());
		System.out.print(filmInfo.get("DIRECTOR"));
		spaceL(filmInfo.get("DIRECTOR").toString());
		DateFormat format2 = DateFormat.getDateInstance(DateFormat.LONG);
		spaceF(format2.format(filmInfo.get("RELEASEDATE")).toString());
		System.out.println(format2.format(filmInfo.get("RELEASEDATE")) + "\t║");

		System.out
				.println("\t║                                                               ║");
		System.out.println("\t║  시놉시스\t\t\t\t\t\t\t║");
		List<String> syn = cutter(filmInfo.get("SUMMARY").toString());
		for (int i = 0; i < syn.size(); i++) {
			System.out.print("\t║  " + syn.get(i));
			synspace(syn.get(i));
			System.out.println("\t║");
		}

		System.out
				.println("\t║                                                               ║");
		System.out.print("\t║  출연 배우 : " + filmInfo.get("ACTOR"));
		actspace(filmInfo.get("ACTOR").toString());
		System.out.println("\t║");
		System.out
				.println("\t║                                                               ║");
		return filmInfo;
	}

	public int movieSelect(){
		
		Map<String, Object> filmInfo = movieCall();
		List<List<Object>> buttons_set = new ArrayList<>();
		List<Object> buttons = new ArrayList<>();
		List<Map<String, Object>> movielist = filmDao.selectMovielist_now();
		String book_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   예매하기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String vod_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│    예고편       │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String comments_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│    영화평       │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String main_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   돌아가기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";

		int a = 0;
		for (int i = 0; i < movielist.size(); i++) {
			if (filmcode == ((BigDecimal) movielist.get(i).get("FILMCODE")).intValue()) {
				a++;
			}
		}
		if (a == 1) {
			buttons.add(book_bt);
			buttons.add(View.TICKET_HOME);
			buttons_set.add(buttons);
		}

		try {
			int b = filmInfo.get("URL").toString().length();
			buttons = new ArrayList<>();
			buttons.add(vod_bt);
			buttons_set.add(buttons);
		} catch (NullPointerException e) {
		}

		buttons = new ArrayList<>();
		buttons.add(comments_bt);
		buttons.add(View.FILM_COMMENTS);
		buttons_set.add(buttons);
		buttons = new ArrayList<>();
		buttons.add(main_bt);
		buttons.add(lastpage);
		buttons_set.add(buttons);

		int x = 1;

		for (int i = 0; i < buttons_set.size(); i++) {
			if (x == i + 1) {
				System.out.println(FilmService.select_bt(buttons_set.get(i)
						.get(0).toString()));
			} else {
				System.out.println(buttons_set.get(i).get(0).toString());
			}
		}
		System.out.println("\t║                                                               ║");
		System.out.println("\t╚═══════════════════════════════════════════════════════════════╝");

		while (true) {
			int input = ScanUtil.nextInt();
			switch (input) {
			case 2:
				x++;
				if (x > buttons_set.size()) {
					x -= buttons_set.size();
				}

				movieCall();
				
				for (int i = 0; i < buttons_set.size(); i++) {
					if (x == i + 1) {
						System.out.println(FilmService.select_bt(buttons_set.get(i)
								.get(0).toString()));
					} else {
						System.out.println(buttons_set.get(i).get(0).toString());
					}
				}
				System.out.println("\t║                                                               ║");
				System.out.println("\t╚═══════════════════════════════════════════════════════════════╝");
				
				break;
			case 8:
				x--;
				if (x < 1) {
					x += buttons_set.size();
				}
				movieCall();
				
				for (int i = 0; i < buttons_set.size(); i++) {
					if (x == i + 1) {
						System.out.println(FilmService.select_bt(buttons_set.get(i)
								.get(0).toString()));
					} else {
						System.out.println(buttons_set.get(i).get(0).toString());
					}
				}
				System.out.println("\t║                                                               ║");
				System.out.println("\t╚═══════════════════════════════════════════════════════════════╝");

				break;
			case 5:
				try {
					return (int) buttons_set.get(x - 1).get(1);
				} catch (Exception e) {
					vodCall();
				}
			}
		}
	}

	public int vodCall() {
		List<Object> p = new ArrayList<>();
		p.add(filmcode);
		Map<String, Object> vod = filmDao.getURL(p);
		try {
			Desktop.getDesktop().browse(new URI(vod.get("URL").toString()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return View.FILMINFO;
	}

	public void commentsCall() {

		List<Object> p = new ArrayList<>();
		p.add(filmcode);
		List<Map<String, Object>> filmcomments = filmDao.selectMoviecomments(p);

		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		if (filmcomments.size() > 0) {
			for (int i = 0; i < filmcomments.size(); i++) {
				System.out.print("\t║\t");
				for (int z = 0; z < ((BigDecimal) filmcomments.get(i).get(
						"COMSTAR")).intValue(); z++) {
					System.out.print("★");
				}

				System.out.print("\t"
						+ filmcomments.get(i).get("MEM_ID").toString()
								.substring(0, 2));
				for (int j = 2; j < filmcomments.get(i).get("MEM_ID")
						.toString().length(); j++) {
					System.out.print("*");
				}

				List<String> syn = comcutter(filmcomments.get(i).get("COMLINE")
						.toString());
				System.out.print("\t" + syn.get(0));
				comspace(syn.get(0));
				System.out.println("\t║");
				if (syn.size() > 1) {
					for (int v = 1; v < syn.size(); v++) {
						System.out.print("\t║\t\t\t" + syn.get(v));
						comspace(syn.get(v));
						System.out.println("\t║");
					}
				}
				System.out
						.println("\t║  ───────────────────────────────────────────────────────────  ║");
			}
		} else {
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t║                      작성된 영화평이 없습니다.                  \t║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t║                                                               ║");
		}
	}

	public int commentsSelect() {

		commentsCall();

		List<String> buttons = new ArrayList<>();
		String book_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│  영화평 작성    │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String check_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│ 내 영화평 조회  │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String main_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   돌아가기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";

		buttons.add(book_bt);
		buttons.add(check_bt);
		buttons.add(main_bt);
		int x = 1;
		System.out
				.println("\t║                       [♛] : 실관람객                                                       ║");
		System.out
				.println("\t║                                                               ║");
		selecter(buttons, x);

		while (true) {
			int input = ScanUtil.nextInt();
			switch (input) {
			case 2:
				x++;
				if (x > buttons.size()) {
					x -= buttons.size();
				}

				commentsCall();
				System.out
						.println("\t║                       [♛] : 실관람객                                                       ║");
				System.out
						.println("\t║                                                               ║");
				selecter(buttons, x);
				break;
			case 8:
				x--;
				if (x < 1) {
					x += buttons.size();
				}
				commentsCall();
				System.out
						.println("\t║                       [♛] : 실관람객                                                       ║");
				System.out
						.println("\t║                                                               ║");
				selecter(buttons, x);
				break;
			case 5:
				switch (x) {
				case 1:
					return View.COMMENTS_INSERT;
				case 2:
					return View.FILM_MYCOMMENTS;
				case 3:
					return View.FILMINFO;
				}
			}
		}
	}

	public int myCommentsCall() {
		List<Object> check = new ArrayList<>();
		check.add(Controller.LoginUser.get("MEM_ID"));
		check.add(filmcode);
		Map<String, Object> com = filmDao.comCheck(check);
		int result = com.size();
		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t║                            내 영화평                                                         ║");
		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t║                                                               ║");
		if (result > 0) {
			System.out.print("\t║\t");
			for (int z = 0; z < ((BigDecimal) com.get("COMSTAR")).intValue(); z++) {
				System.out.print("★");
			}
			System.out.print("\t" + com.get("MEM_ID").toString());
			List<String> syn = comcutter(com.get("COMLINE").toString());
			System.out.print("\t" + syn.get(0));
			comspace(syn.get(0));
			System.out.println("\t║");
			if (syn.size() > 1) {
				for (int v = 1; v < syn.size(); v++) {
					System.out.print("\t║\t\t\t" + syn.get(v));
					comspace(syn.get(v));
					System.out.println("\t║");
				}
			}
		} else {
			System.out
					.println("\t║                      작성된 영화평이 없습니다.                  \t║");
		}
		System.out
				.println("\t║                                                               ║");
		return result;
	}

	public int myComments() {
		try {
			int result = myCommentsCall();
			List<List<Object>> buttons_set = new ArrayList<>();
			List<Object> buttons = new ArrayList<>();
			if (result > 0) {
				String update_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   수정하기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
				String delete_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   삭제하기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
				buttons.add(update_bt);
				buttons.add(View.COMMENTS_UPDATE);
				buttons_set.add(buttons);
				buttons = new ArrayList<>();
				buttons.add(delete_bt);
				buttons.add(View.COMMENTS_DELETE);
				buttons_set.add(buttons);
			}
			String exit_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   돌아가기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
			buttons = new ArrayList<>();
			buttons.add(exit_bt);
			buttons.add(View.FILM_COMMENTS);
			buttons_set.add(buttons);

			int x = 1;

			for (int i = 0; i < buttons_set.size(); i++) {
				if (x == i + 1) {
					System.out.println(select_bt(buttons_set.get(i).get(0)
							.toString()));
				} else {
					System.out.println(buttons_set.get(i).get(0).toString());
				}
			}
			System.out
					.println("\t╚═══════════════════════════════════════════════════════════════╝");
			while (true) {
				int input = ScanUtil.nextInt();
				switch (input) {
				case 2:
					x++;
					if (x > buttons.size()) {
						x -= buttons.size();
					}

					myCommentsCall();
					for (int i = 0; i < buttons.size(); i++) {
						if (x == i + 1) {
							System.out.println(select_bt(buttons_set.get(i)
									.get(0).toString()));
						} else {
							System.out.println(buttons_set.get(i).get(0)
									.toString());
						}
					}
					System.out
							.println("\t╚═══════════════════════════════════════════════════════════════╝");

					break;
				case 8:
					x--;
					if (x < 1) {
						x += buttons.size();
					}
					myCommentsCall();
					for (int i = 0; i < buttons.size(); i++) {
						if (x == i + 1) {
							System.out.println(select_bt(buttons_set.get(i)
									.get(0).toString()));
						} else {
							System.out.println(buttons_set.get(i).get(0)
									.toString());
						}
					}
					System.out
							.println("\t╚═══════════════════════════════════════════════════════════════╝");
					break;
				case 5:
					return (int) buttons_set.get(x - 1).get(1);
				}
			}
		} catch (NullPointerException e) {
			lastpage = View.FILM_COMMENTS;
			return View.LOGLATER;
		}
	}

	public int insertComments() {
		List<Object> check = new ArrayList<>();
		int result = 0;
		try {
			check.add(Controller.LoginUser.get("MEM_ID"));
			check.add(filmcode);
			Map<String, Object> com = filmDao.comCheck(check);
			if (com.size() > 0) {
				System.out
						.println("\t╔═══════════════════════════════════════════════════════════════╗");
				System.out
						.println("\t║                                                               ║");
				System.out
						.println("\t║                                                               ║");
				System.out.println("\t║\t\t     이미 작성한 댓글이 있습니다.\t\t\t║");
				System.out
						.println("\t║                                                               ║");
				System.out
						.println("\t║                                                               ║");

				List<String> buttons = new ArrayList<>();
				String update_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   조회하기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
				String exit_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   돌아가기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";

				buttons.add(update_bt);
				buttons.add(exit_bt);

				int x = 1;
				selecter(buttons, x);
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
								.println("\t║                                                               ║");
						System.out
								.println("\t║\t\t     이미 작성한 댓글이 있습니다.\t\t\t║");
						System.out
								.println("\t║                                                               ║");
						System.out
								.println("\t║                                                               ║");
						selecter(buttons, x);
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
								.println("\t║                                                               ║");
						System.out
								.println("\t║\t\t     이미 작성한 댓글이 있습니다.\t\t\t║");
						System.out
								.println("\t║                                                               ║");
						System.out
								.println("\t║                                                               ║");
						selecter(buttons, x);
						break;
					case 5:
						switch (x) {
						case 1:
							return View.FILM_MYCOMMENTS;
						case 2:
							return View.FILM_COMMENTS;
						}
					}
				}
			}
			List<Object> param = new ArrayList<>();
			System.out
					.println("\t╔═══════════════════════════════════════════════════════════════╗");
			System.out
					.println("\t║                                                               ║");
			String star = "";
			do {
				System.out
						.print("\t║\t\t\t별점  : 1 ~ 5 사이의 자연수\t\t\t║\n\t\t\t\t\t");
				star = ScanUtil.nextLine();
			} while (!Validation.isStar(star));
			String line = "";
			if (filmDao.movieCheck(check).size() > 0) {
				line += "[♛] ";
			}
			System.out.print("\t║\t\t\t영화평  : \t\t\t\t\t║\n\t\t\t\t");
			line += ScanUtil.nextLine();
			param.add(Controller.LoginUser.get("MEM_ID"));
			param.add(filmcode);
			param.add(star);
			param.add(line);
			result = filmDao.insertComments(param);
			System.out
					.println("\t║                        영화평이 등록되었습니다.                     ║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t║                                                               ║");
			System.out
					.println("\t╚═══════════════════════════════════════════════════════════════╝");
		} catch (NullPointerException e) {
			lastpage = View.FILM_COMMENTS;
			return View.LOGLATER;
		}
		return View.FILM_COMMENTS;

	}

	public int updateComments() {
		List<Object> check = new ArrayList<>();
		int result = 0;
		try {
			check.add(Controller.LoginUser.get("MEM_ID"));
			check.add(filmcode);
			Map<String, Object> com = filmDao.comCheck(check);// ///////////////////

			List<Object> param = new ArrayList<>();
			System.out.println("수정할 별점>");
			int star = ScanUtil.nextInt();
			String line = "";
			if (filmDao.movieCheck(check).size() > 0) {// /////////////////////
				line += "[♛] ";
			}
			System.out.println("수정할 영화평>");
			line += ScanUtil.nextLine();
			param.add(star);
			param.add(line);
			param.add(Controller.LoginUser.get("MEM_ID"));
			param.add(filmcode);
			result = filmDao.updateComments(param);

		} catch (NullPointerException e) {
			lastpage = View.COMMENTS_UPDATE;
			return View.LOGLATER;
		}
		return View.FILM_COMMENTS;
	}

	public int deleteComments() {
		List<Object> check = new ArrayList<>();
		int result = 0;
		check.add(Controller.LoginUser.get("MEM_ID"));
		check.add(filmcode);
		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t║                                                               ║");
		System.out.println("\t║\t\t\t     영화평을 삭제합니다.\t\t\t\t║");
		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t║                                                               ║");
		List<String> buttons = new ArrayList<>();
		String delete_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   삭제하기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String exit_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   돌아가기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";

		buttons.add(delete_bt);
		buttons.add(exit_bt);

		int x = 1;
		selecter(buttons, x);
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
						.println("\t║                                                               ║");
				System.out.println("\t║\t\t\t     영화평을 삭제합니다.\t\t\t\t║");
				System.out
						.println("\t║                                                               ║");
				System.out
						.println("\t║                                                               ║");
				selecter(buttons, x);
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
						.println("\t║                                                               ║");
				System.out.println("\t║\t\t\t     영화평을 삭제합니다.\t\t\t\t║");
				System.out
						.println("\t║                                                               ║");
				System.out
						.println("\t║                                                               ║");
				selecter(buttons, x);
				break;
			case 5:
				switch (x) {
				case 1:
					result = filmDao.comDelete(check);
					System.out
							.println("\t╔═══════════════════════════════════════════════════════════════╗");
					System.out
							.println("\t║                                                               ║");
					System.out
							.println("\t║                                                               ║");
					System.out
							.println("\t║                                                               ║");
					System.out
							.println("\t║                                                               ║");
					System.out.println("\t║\t\t\t     영화평이 삭제되었습니다.\t\t\t\t║");
					System.out
							.println("\t║                                                               ║");
					System.out
							.println("\t║                                                               ║");
					System.out
							.println("\t║                                                               ║");
					System.out
							.println("\t║                                                               ║");
					System.out
							.println("\t╚═══════════════════════════════════════════════════════════════╝");
					return View.FILM_COMMENTS;
				case 2:
					return View.FILM_COMMENTS;
				}
			}
		}
	}

	public int loglater() {
		List<String> buttons = new ArrayList<>();
		String login_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│    로그인       │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		String main_bt = "\t║\t\t\t┌────────────┐\t\t\t\t║\n\t║\t\t\t│   돌아가기      │\t\t\t\t║\n\t║\t\t\t└────────────┘\t\t\t\t║";
		buttons.add(login_bt);
		buttons.add(main_bt);

		System.out
				.println("\t╔═══════════════════════════════════════════════════════════════╗");
		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t║                                                               ║");
		System.out.println("\t║\t\t     로그인이 필요한 서비스입니다.\t\t\t║");
		System.out
				.println("\t║                                                               ║");
		System.out
				.println("\t║                                                               ║");
		int x = 1;
		selecter(buttons, x);
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
						.println("\t║                                                               ║");
				System.out.println("\t║\t\t     로그인이 필요한 서비스입니다.\t\t\t║");
				System.out
						.println("\t║                                                               ║");
				System.out
						.println("\t║                                                               ║");
				selecter(buttons, x);
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
						.println("\t║                                                               ║");
				System.out
						.println("\t║                                                               ║");
				System.out.println("\t║\t\t     로그인이 필요한 서비스입니다.\t\t\t║");
				System.out
						.println("\t║                                                               ║");
				System.out
						.println("\t║                                                               ║");
				System.out
						.println("\t║                                                               ║");
				selecter(buttons, x);
				break;
			case 5:
				switch (x) {
				case 1:
					return View.LOGIN;
				case 2:
					return lastpage;
				}
			}
		}
	}

	static String listspace(String str) {
		double num1 = str.replaceAll("[^ㄱ-힣]", "").length();
		double num2 = str.replaceAll("[^0-9]", "").length();
		double num3 = str.length() - str.replaceAll("[^ㄱ-힣]", "").length();
		int space = (int) Math
				.round(8.5 - num1 * 0.7 - num2 * 0.4 - num3 * 0.4);
		String spacer = "";
		for (int i = 0; i < space; i++) {
			spacer += " ";
		}
		return spacer;
	}

	static void spaceL(String str) {
		int num1 = str.replaceAll("[^ㄱ-힣]", "").length();
		int num2 = str.replaceAll("[^0-9]", "").length();
		int num3 = str.length() - str.replaceAll("[^ㄱ-힣]", "").length();
		int space = 40 - num1 * 3 - num2 * 2 - num3;
		if (!Validation.isKorL(str)) {
			space = (int) (space / 1.7);
		}
		for (int i = 0; i < space; i++) {
			System.out.print(" ");
		}
	}

	static void spaceF(String str) {
		int num1 = str.replaceAll("[^ㄱ-힣]", "").length();
		int num2 = str.replaceAll("[^0-9]", "").length();
		int num3 = str.length() - str.replaceAll("[^ㄱ-힣]", "").length();
		int space = 40 - num1 * 3 - num2 * 2 - num3;
		if (!Validation.isKorF(str)) {
			space = (int) (space / 1.9);
		}
		for (int i = 0; i < space; i++) {
			System.out.print(" ");
		}
	}

	static void synspace(String str) {
		int num1 = str.replaceAll("[^ㄱ-힣]", "").length(); // 한글 길이
		int num2 = str.replaceAll("[^a-zA-Z0-9]", "").length(); // 영문숫자 길이
		int num3 = str.length() - str.replaceAll("[^ㄱ-힣]", "").length(); // 그외
		int space = 109 - num1 * 3 - num2 * 2 - num3;
		if (!Validation.isKorL(str)) {
			space = space / 2;
		}
		for (int i = 0; i < space; i++) {
			System.out.print(" ");
		}
	}

	static void actspace(String str) {
		int num1 = str.replaceAll("[^ㄱ-힣]", "").length(); // 한글 길이
		int num2 = str.replaceAll("[^a-zA-Z0-9]", "").length(); // 영문숫자 길이
		int num3 = str.length() - str.replaceAll("[^ㄱ-힣]", "").length(); // 그외
		int space = 87 - num1 * 3 - num2 * 2 - num3;
		for (int i = 0; i < space; i++) {
			System.out.print(" ");
		}
	}

	static void comspace(String str) {
		int num1 = str.replaceAll("[^ㄱ-힣]", "").length(); // 한글 길이
		int num2 = str.replaceAll("[^a-zA-Z0-9]", "").length(); // 영문숫자 길이
		int num3 = str.length() - str.replaceAll("[^ㄱ-힣]", "").length(); // 그외
		int space = 70 - num1 * 3 - num2 * 2 - num3;
		if (!Validation.isKorL(str)) {
			space = space / 2;
		}
		for (int i = 0; i < space; i++) {
			System.out.print(" ");
		}
	}

	static List<String> cutter(String str) {
		List<String> syn = new ArrayList<>();
		for (int i = 0; i < str.length(); i += 45) {
			if (str.length() > i + 45) {
				syn.add(str.substring(i, i + 45).trim());
			} else {
				syn.add(str.substring(i, str.length()).trim());
			}
		}
		return syn;
	}

	static List<String> comcutter(String str) {
		List<String> syn = new ArrayList<>();
		for (int i = 0; i < str.length(); i += 30) {
			if (str.length() > i + 30) {
				syn.add(str.substring(i, i + 30).trim());
			} else {
				syn.add(str.substring(i, str.length()).trim());
			}
		}
		return syn;
	}

	public static String select_bt(String a) {
		a = a.replace("┌", "┏");
		a = a.replace("└", "┗");
		a = a.replace("┐", "┓");
		a = a.replace("┘", "┛");
		a = a.replace("│", "┃");
		a = a.replace("─", "━");
		return a;
	}

}
