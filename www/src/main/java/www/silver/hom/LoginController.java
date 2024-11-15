package www.silver.hom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@PostMapping(value = "login")
	public String login(@RequestParam("id") String id, @RequestParam("pass") String pass, 
			HttpServletRequest request) throws Exception {
		// 클라이언트가 전송한 아이디와 패스워드가 DB에 있는지 확인
		// 현재는 Session과 Interceptor가 목적이기에 생략하고 진행
		
		// if(true) 코드는 데이터베이스에서 가져온 값이 있을 경우에만 실행되어야 한다.
		if (true) {
			// request의 세션을 가져온다.
			HttpSession session = request.getSession();
			// 가져온 세션에 설정된 id변수의 값을 가져온다.
			Object nowid = session.getAttribute("id");
			// 만약 가져온 값이 존재한다면?
			if (nowid != null) {
				// 기존의 세션값에 존재하는 id변수의 값을 제거한다.
				session.removeAttribute("id");
			}
			// 세션에 변수 id를 저장한다.
			session.setAttribute("id", id);			
		}
		
		return "redirect:/";
	}
	
	@GetMapping(value = "logout")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();		// 세션을 무력화한다.
		
		return "redirect:/";
	}
	
}
