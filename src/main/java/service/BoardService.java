package service;

import java.util.List;
import java.util.Map;

import dao.BoardDao;
import dto.BoardListDto;
import dto.Pagination;
import vo.Board;

public class BoardService {
	
	private final BoardDao boardDao = new BoardDao();
	
	public BoardListDto getBoardList(int currentPage, Map<String, Object> param) throws Exception{
		int totalRows = boardDao.getTotalRows();
		
		Pagination pagination = new Pagination(currentPage, totalRows);
		param.put("begin", pagination.getBegin());
		param.put("end", pagination.getEnd());
		
		List<Board> boards = boardDao.getAllBoards(param);
		
		BoardListDto dto = new BoardListDto();
		dto.setItems(boards);
		dto.setPagination(pagination);
		
		return dto;
	}

	public void save(Board board) throws Exception{
		boardDao.insertBoard(board);
	}

	public Board getBoardDetail(int no) throws Exception{
		Board board = boardDao.getBoardByNo(no);
		board.setReadCount(board.getReadCount() + 1);
		boardDao.updateBoard(board);
		
		return boardDao.getBoardByNo(no);
	}
	
}
