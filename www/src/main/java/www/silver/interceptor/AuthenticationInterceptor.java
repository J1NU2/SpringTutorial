package www.silver.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	// Controller 레이어로 가기 전에 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle에 진입");
		// 로그인 판단 유무, 비지니스 서비스 처리
		// 1) 세션을 가져온 뒤 해당 세션이 있다면 로그인
		// 2) 로그인 한 사람이 없다면 로그인을 하지 않았으니 메인화면으로 리턴
		HttpSession session = request.getSession();
		Object id = session.getAttribute("id");
		if (id == null) {	// 세션값이 없을 경우의 조건
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
//		return super.preHandle(request, response, handler);
		return true;
	}

	// Controller 레이어 이후에 처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
