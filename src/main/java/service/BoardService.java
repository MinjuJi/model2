package service;

import java.util.List;

import dao.BoardDao;
import vo.Board;

public class BoardService {
	
	private final BoardDao boardDao = new BoardDao();
	
	public List<Board> getBoardList() throws Exception{
		return boardDao.getAllBoards();
	}

	public void save(Board board) throws Exception{
		boardDao.insertBoard(board);
	}
	
}
