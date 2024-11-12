package www.silver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.dao.IF_BoardDAO;
import www.silver.vo.BoardVO;

@Service
public class BoardServiceImpl implements IF_BoardService {
	
	@Inject
	IF_BoardDAO boarddao;

	@Override
	public void addBoard(BoardVO boardvo) throws Exception {
		if (boardvo.getViewMember() != null) {
			if (boardvo.getViewMember().equals("1")) {
				boardvo.setViewMember("비공개");
			}		
		} else {
			boardvo.setViewMember("공개");			
		}
		// DAO > Mapper > DB Insert
		// DAO레이어에서 작업하기 위해 BoardVO객체를 DAO에게 넘겨준다.
		boarddao.insertBoard(boardvo);
	}

	@Override
	public List<BoardVO> boardList() throws Exception {
		// 아래 방법은 서버(서비스)에 부담을 주는 방법이다.
		// ... JSTL문법을 이용하여 JSP에서 해결할 수 있는 방법도 존재한다.
		List<BoardVO> list = boarddao.selectAll();
		for (BoardVO b : list) {
			String datetime = b.getIndate();
			b.setIndate(datetime.substring(0, 10));
		}
		return list;
	}

	@Override
	public void deleteBoard(String delno) throws Exception {
		boarddao.deleteBoard(delno);
	}
	
}
