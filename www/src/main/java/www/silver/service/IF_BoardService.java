package www.silver.service;

import java.util.List;

import www.silver.vo.BoardVO;
import www.silver.vo.PageVO;

public interface IF_BoardService {
	// 서비스를 정의하기 위한 인터페이스
	
	// 의미 : 클라이언트의 글작성 요청을 처리하기 위한 서비스 정의
	public void addBoard(BoardVO boardvo) throws Exception;
	// 의미 : 클라이언트가 요청한 전체 게시글을 보여줄 서비스 정의
	public List<BoardVO> boardList(PageVO pagevo) throws Exception;
	
	public void deleteBoard(String num) throws Exception;
	public BoardVO modBoard(String num) throws Exception;
	public void modBoard(BoardVO boardvo) throws Exception;
	public BoardVO getBoard(String num) throws Exception;
	public List<String> getAttach(String num) throws Exception;
	
	// 페이징
	public int totalCountBoard() throws Exception;
}
