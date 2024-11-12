package www.silver.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.dao.IF_MemberDAO;
import www.silver.vo.MemberVO;

// 컨테이너에 등록하기 위해
@Service	// 해당 클래스를 객체로 만든다는 뜻
public class MemberServiceImpl implements IF_MemberService {
	
	@Inject
	IF_MemberDAO memberdao;
	
	@Override
	public void join(MemberVO membervo) throws Exception {
//		System.out.println("Join Service 입니다.");
		// DAO에게 작업 지시
		// 실제 데이터를 데이터베이스(DB)에 저장하도록 작업을 지시한다.
		memberdao.insertOne(membervo);
	}

}
