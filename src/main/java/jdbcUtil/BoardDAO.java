package jdbcUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import vo.BoardVO;

@Repository
public class BoardDAO {
	@PersistenceContext
	private EntityManager eManager;

public List<BoardVO> selectList() {
		
		return eManager.createQuery("from BoardVO order by root desc, step asc").getResultList();
	}// selectList()

public BoardVO selectOne(BoardVO vo) {
	
	return eManager.find(BoardVO.class, vo.getSeq());
}// selectOne


}// BoardDAO
