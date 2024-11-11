package www.silver.service;

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
		if (boardvo != null) {
			if (boardvo.getViewMember().equals("1")) {
				boardvo.setViewMember("비공개");
			} else {
				boardvo.setViewMember("공개");
			}			
		}
		// DAO > Mapper > DB Insert
		// DAO레이어에서 작업하기 위해 BoardVO객체를 DAO에게 넘겨준다.
		boarddao.insertBoard(boardvo);
	}
	
}
