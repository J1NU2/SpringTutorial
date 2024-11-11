package www.silver.dao;

import www.silver.vo.BoardVO;

public interface IF_BoardDAO {
	// DB작업을 목적으로 하는 인터페이스
	// Mybatis Mapper랑 매핑하여 DB작업을 수행
	public void insertBoard(BoardVO boardvo) throws Exception;
}
