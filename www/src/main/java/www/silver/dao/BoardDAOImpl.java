package www.silver.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.vo.BoardVO;
import www.silver.vo.PageVO;

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

	@Override
	public List<BoardVO> selectAll(PageVO pagevo) throws Exception {
		return sqlsession.selectList(mapperQuery + ".selectall", pagevo);
	}

	@Override
	public void deleteBoard(String num) throws Exception {
		sqlsession.delete(mapperQuery + ".delone", num);
	}

	@Override
	public BoardVO selectOne(String num) throws Exception {
		return sqlsession.selectOne(mapperQuery + ".selectOne", num);
	}

	@Override
	public void updateBoard(BoardVO boardvo) throws Exception {
		sqlsession.update(mapperQuery + ".modone", boardvo);
	}

	// 페이징
	@Override
	public int countBoard() throws Exception {
		return sqlsession.selectOne(mapperQuery + ".allcnt");
	}

	@Override
	public void insertAttach(String fname) throws Exception {
		sqlsession.insert(mapperQuery + ".insertAttach", fname);
	}

	@Override
	public List<String> selectAllAttach(String num) throws Exception {
		return sqlsession.selectList(mapperQuery + ".selectAttach", num);
	}
	
}
