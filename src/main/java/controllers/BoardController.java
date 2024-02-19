package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.BoardListDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jhta.model2.annotation.Controller;
import kr.co.jhta.model2.annotation.RequestMapping;
import kr.co.jhta.model2.constant.HttpMethod;
import service.BoardService;
import vo.Board;
import vo.User;

@Controller
@RequestMapping(path = "/board")
public class BoardController {
	
	private final BoardService boardService = new BoardService();
	
	@RequestMapping(path = "/detail.do")
	public String detail(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		int no = Integer.parseInt(req.getParameter("no"));
		Board board = boardService.getBoardDetail(no);
		req.setAttribute("board", board);
		
		return "board/detail.jsp";
	}
	
	@RequestMapping(path = "/insert.do")
	public String form(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return "board/form.jsp";
	}
	
	@RequestMapping(path = "/insert.do", method = HttpMethod.POST)
	public String save(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		// 로그인된 사용자정보를 조회한다.
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("LOGIN_USER");
		if(user == null) {
			return "redirect:/login.do";
		}
		
		// 요청 파라미터값을 조회한다.
		String title = req.getParameter("title");
		String content= req.getParameter("content");
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setUser(user);
		
		boardService.save(board);
		
		return "redirect:list.do";
	}
	
	@RequestMapping(path = "/list.do")
	public String list(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int currentPage = Integer.parseInt(req.getParameter("page"));
		//String opt = req.getParameter("opt");
		//String keyword = req.getParameter("keyword");
		
		Map<String, Object> param = new HashMap<String, Object>();
		//param.put("opt", opt);
		//param.put("keyword", keyword);
		
		BoardListDto dto = boardService.getBoardList(currentPage, param);
		req.setAttribute("boardList", dto.getItems()); 		// List<Board> 객체다.
		req.setAttribute("paging", dto.getPagination());	// Pagination 객체다.
		
		return "board/list.jsp";
	}

}
