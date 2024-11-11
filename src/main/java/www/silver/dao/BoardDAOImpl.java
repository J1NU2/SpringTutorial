package www.silver.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.vo.BoardVO;

@Repository
public class BoardDAOImpl implements IF_BoardDAO {

	@Inject
	SqlSession sqlsession;
	final String mapperQuery = "www.silver.dao.IF_BoardDAO";
	
	@Override
	public void insertBoard(BoardVO boardvo) throws Exception {
		// Mapper와 매핑하기 위해 SqlSession을 통해 BoardVO의 정보를 넘겨준다.
		sqlsession.insert(mapperQuery + ".inin", boardvo);
	}
	
}
