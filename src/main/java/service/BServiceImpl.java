package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbcUtil.BoardDAO;
import vo.BoardVO;

@Service
public class BServiceImpl implements BService {
	@Autowired
	BoardDAO dao;

	@Override
	public List<BoardVO> selectList() {
		return dao.selectList();
	}
}
