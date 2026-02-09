package com.app.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.util.LoginManager;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.user.User;
import com.app.dto.user.UserDupCheck;

@Controller
public class CustomerController {
	// 고객 사용자 관련된 서비스 (계정 관련... )

	@Autowired
	UserService userService;

	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}
	
	@ResponseBody //텍스트 응답
	@PostMapping("/customer/checkDupId")
	public String checkDupId(@RequestBody String data) { 
							//요청 body 데이터를 단순 텍스트 수신
		System.out.println("/customer/checkDupId");
		System.out.println(data);

		
		// data: 중복인지 체크할 아이디
		// -> db에서 중복된 사용자 아이디 있는지 체크
		
		Boolean result = userService.isDuplicatedId(data);
		System.out.println(result);
		
		if(result) {//true 중복
			return "Y";
		} else {//false 중복아님
			return "N";
		}
	}
	
	@ResponseBody //json 요청 json 응답
	@PostMapping("/customer/checkDupIdJson")
	public ApiResponse<String> checkDupIdJson(@RequestBody UserDupCheck userDupCheck) { 
							//요청 body 데이터에 json format text가 담겨져 있는 경우에
							//key값 == 필드변수   자동으로 객체로 파싱되어 데이터가 담김
		System.out.println("/customer/checkDupId");
		System.out.println(userDupCheck);

		
		// data: 중복인지 체크할 아이디
		// -> db에서 중복된 사용자 아이디 있는지 체크
	
		
		Boolean result = userService.isDuplicatedId( userDupCheck.getId() );
		System.out.println(result);
		
		//return ApiResponse<String>   body "Y" "N"
		ApiResponse<String> res = new ApiResponse<String>();
		
		//header
		ApiResponseHeader header = new ApiResponseHeader();
		header.setResultCode( ApiCommonCode.API_RESULT_SUCCESS);
		header.setResultMsg( ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		res.setHeader(header);
		//body
		
		
		res.setBody("Y");
		
		
		
		
		if(result) {//true 중복
			res.setBody("Y");
		} else {//false 중복아님
			res.setBody("N");
		}
		
		return res; //json 객체 변환
	}
	

	@PostMapping("/customer/signup")
	public String signupAction(User user) {

		// 사용자 회원가입 -> db 저장

		int result = userService.saveCustomerUser(user);

		if (result > 0) { // 성공
			return "redirect:/main";
		} else { // 실패
			return "customer/signup";
		}

	}

	@GetMapping("/customer/signin")
	public String signin() {
		return "customer/signin";
	}

	@PostMapping("/customer/signin")
	public String signinAction(User user, HttpSession session) {

		// 로그인 처리 로직
		System.out.println("사용자 입력한 값");
		System.out.println(user);

		// 사용자 입력한 id pw 비교
		// -> DB 조회

		// userType -> 사용자가 접속하는 페이지
		// admin 관리자가 접속하는 페이지

		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		User loginUser = userService.checkUserLogin(user); // 서비스내부에서 userType까지 비교

		if (loginUser == null) { // 실패
			System.out.println("로그인 실패");
			return "customer/signin";
		} else { // 성공
			System.out.println("로그인성공");
			System.out.println(loginUser);

			// 로그인 성공 아이디 세션에 저장
			// session.setAttribute("loginUserId", loginUser.getId());
			LoginManager.setSessionLoginUserId(session, loginUser.getId());

			// return "redirect:/main";

			// 로그인 성공후에 마이페이지로 연결
			return "redirect:/customer/mypage";
		}

		// 로그인 성공 -> 로그인 성공한 사용자 아이디 -> session 영역 저장
		// -> 성공한 이후 페이지 연결 (메인 / 마이페이지)

		// 로그인 실패 -> 로그인 시도 화면
	}

	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {

		// 로그인을 한 상태면? -> session 에 로그인 사용자 아이디가 존재

		// if(session.getAttribute("loginUserId") != null) {
		if (LoginManager.isLogin(session)) {

			// session 에서 로그인 사용자 ID 확인
			// String loginUserId = session.getAttribute("loginUserId").toString();
			String loginUserId = LoginManager.getLoginUserId(session);

			// DB에서 user 데이터 조회
			User user = userService.findUserById(loginUserId);

			// view 데이터 전달
			model.addAttribute("user", user);

			return "customer/mypage";
		}

		// 로그인 안되어있으면? -> 로그인 페이지로 연결
		return "redirect:/customer/signin";
	}

	@GetMapping("/customer/signout")
	public String signout(HttpSession session) {

		// 세션 초기화
		// session.invalidate();
		LoginManager.logout(session);

		return "redirect:/main";
	}

	@GetMapping("/customer/modifypw")
	public String modifyPw(HttpServletRequest request, Model model) {
		
		User user = userService.findUserById(LoginManager.getLoginUserId(request));
		if(user == null) {
			return "/customer/login";
		}
		model.addAttribute("user",user);
		
		
		return "customer/modifypw";
	}
	
	@PostMapping("/customer/modifypw")
	public String modifyPwAction(@ModelAttribute User user) {
		System.out.println("수정하려는 유저 정보");
		System.out.println(user);
		
		int result = userService.modifyPw(user);
		
		if(result > 0) { //성공
			//성공하면 해당 호실 상세페이지
			return "redirect:/customer/mypage";
		} else { //실패
			//return "admin/modifyRoom";  //바로 화면 연결

			//수정페이지로 다시 진입
			return "redirect:/main";
		}
	}
}
