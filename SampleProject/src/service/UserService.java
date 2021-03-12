package service;

import java.util.HashMap;
import java.util.Map;

import util.ScanUtil;
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
		// 싱글톤 패턴
	}
	private UserDao userDao = UserDao.getInstance();

	// 회원가입
	public int join() {
		System.out.println("================회원가입==========");

		System.out.println("아이디");
		String userId = ScanUtil.nextLine();
		System.out.println("비밀번호");
		String password = ScanUtil.nextLine();
		System.out.println("이름");
		String username = ScanUtil.nextLine();
		// 아이디 중복 확인 생략
		// 비밀번호 확인 생략
		// 정규표현식(유효성 검사) 생략

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("USER_ID", userId);
		param.put("PASSWORD", password);
		param.put("USER_NAME", username);

		int result = userDao.insertUser(param);
		if(0<result){
			System.out.println("회원가입 성공");
		}else{
			System.out.println("회원가입 실패");
		}
		return View.HOME;
	}
	
	public int login(){
		System.out.println("=======로그인=======");
		System.out.println("아이디>");
		String userId = ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String password = ScanUtil.nextLine();

		Map<String, Object> user = userDao.selectUser(userId, password);

		if (user.size() == 0) {
			System.out.println("아이디 혹은 비밀 번호를 잘못 입력하셨습니다.");
		} else {
			System.out.println("로그인 성공");
			Controller.LoginUser = user;
			return View.BOARD_LIST;
		}
		return View.LOGIN;
	}

}
