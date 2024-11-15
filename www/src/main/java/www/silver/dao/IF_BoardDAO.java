package www.silver.dao;

import java.util.List;

import www.silver.vo.BoardVO;
import www.silver.vo.PageVO;

public interface IF_BoardDAO {
	// DB작업을 목적으로 하는 인터페이스
	// Mybatis Mapper랑 매핑하여 DB작업을 수행
	public void insertBoard(BoardVO boardvo) throws Exception;
	public List<BoardVO> selectAll(PageVO pagevo) throws Exception;
	public void deleteBoard(String num) throws Exception;
	public BoardVO selectOne(String num) throws Exception;
	public void updateBoard(BoardVO boardvo) throws Exception;
	public List<String> selectAllAttach(String num) throws Exception;
	
	// 페이징
	public int countBoard() throws Exception;
	
	// 파일 업로드
	public void insertAttach(String fname) throws Exception;
}
