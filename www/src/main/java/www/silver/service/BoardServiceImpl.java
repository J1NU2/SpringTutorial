package www.silver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.dao.IF_BoardDAO;
import www.silver.vo.BoardVO;
import www.silver.vo.PageVO;

@Service
public class BoardServiceImpl implements IF_BoardService {
	
	@Inject
	IF_BoardDAO boarddao;

	@Override
	public void addBoard(BoardVO boardvo) throws Exception {
//		if (boardvo.getViewMember() != null) {
//			if (boardvo.getViewMember().equals("1")) {
//				boardvo.setViewMember("비공개");
//			}
//		} else {
//			boardvo.setViewMember("공개");
//		}
		boardvo.setViewMember(checkedView(boardvo));
		// DAO > Mapper > DB Insert
		// DAO레이어에서 작업하기 위해 BoardVO객체를 DAO에게 넘겨준다.
		
		// 게시글을 kboard에 저장한다.
		boarddao.insertBoard(boardvo);
		
		// 만약 첨부파일이 있을 경우, 첨부파일을 별도의 kboard_attach에 저장한다.
		String[] fname = boardvo.getFilename();
		if (fname.length >= 1) {
			for (int i=0; i<fname.length; i++) {
				// kboard_attach 테이블에 첨부파일을 저장하는 코드
				if (fname[i] != null) boarddao.insertAttach(fname[i]);
			}
		}
	}

	@Override
	public List<BoardVO> boardList(PageVO pagevo) throws Exception {
		// 아래 방법은 서버(서비스)에 부담을 주는 방법이다.
		// ... JSTL문법을 이용하여 JSP에서 해결할 수 있는 방법도 존재한다.
		List<BoardVO> list = boarddao.selectAll(pagevo);
		for (BoardVO b : list) {
			String datetime = b.getIndate();
			b.setIndate(datetime.substring(0, 10));
		}
		return list;
	}

	@Override
	public void deleteBoard(String num) throws Exception {
		boarddao.deleteBoard(num);
	}

	@Override
	public BoardVO modBoard(String num) throws Exception {
		return boarddao.selectOne(num);
	}

	@Override
	public void modBoard(BoardVO boardvo) throws Exception {
//		if (boardvo.getViewMember() != null) {
//			if (boardvo.getViewMember().equals("1")) {
//				boardvo.setViewMember("비공개");
//			}
//		} else {
//			boardvo.setViewMember("공개");
//		}
		boardvo.setViewMember(checkedView(boardvo));
		boarddao.updateBoard(boardvo);
	}
	
	public String checkedView(BoardVO boardvo) {
		if (boardvo.getViewMember() != null) {
			if (boardvo.getViewMember().equals("1")) {
				return "비공개";
			}
		} else {
			return "공개";
		}
		return "공개";
	}

	// 페이징
	@Override
	public int totalCountBoard() throws Exception {
		return boarddao.countBoard();
	}

	@Override
	public BoardVO getBoard(String num) throws Exception {
		return boarddao.selectOne(num);
	}

	@Override
	public List<String> getAttach(String num) throws Exception {
		return boarddao.selectAllAttach(num);
	}
}
