package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BoardDao;
import util.ScanUtil;
import util.View;

public class BoardService {

	private static BoardService instance;

	private BoardService() {
	}

	public static BoardService getInstance() {
		if (instance == null) {
			instance = new BoardService();
		}
		return instance;
		// 싱글톤 패턴
	}

	private BoardDao boardDao = BoardDao.getInstance();
	private int currentBoardNo;
	
	public int boardList() {
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		System.out.println("==============");
		System.out.println("1. 조회 2. 등록 3. ");
		System.out.println("===============");
		for (int i = 0; i < boardList.size(); i++) {
			Map<String, Object> board = boardList.get(i);
			System.out.println(board.get("BOARD_NO")+"\t" + board.get("TITLE") +"\t"
					+ board.get("USER_ID")+"\t" + board.get("REG_DATE"));
		}
		System.out.println();
		System.out.println();
		System.out.println();

		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			System.out.println("게시글 번호 입력>");
			currentBoardNo = ScanUtil.nextInt();
			return View.EVENT_SELECT;
		case 2:
			return View.QA_LIST ;
		case 0:
			Controller.LoginUser = null;
			return View.MAIN;
		}

		return View.NOTICE_LIST;
	}

}
