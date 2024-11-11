package www.silver.service;

import www.silver.vo.MemberVO;

public interface IF_MemberService {
	// 서비스할 작업을 메서드로 정의한다.
	
	// 컨트롤러가 회원가입(조인) 작업을 요청한다. 이때, 매개변수로 객체의 주소를 전달한다.
	public void join(MemberVO membervo) throws Exception;
}
