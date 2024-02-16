package controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jhta.model2.annotation.Controller;
import kr.co.jhta.model2.annotation.RequestMapping;
import kr.co.jhta.model2.constant.HttpMethod;
import service.UserService;
import vo.User;

@Controller
public class HomeController {
	
	private final UserService userService = new UserService();
	
	@RequestMapping(path="/home.do")
	public String home(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "home.jsp";
	}
	
	@RequestMapping(path="/login.do")
	public String loginform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "loginform.jsp";
	}
	
	@RequestMapping(path="/register.do", method = HttpMethod.GET)
	public String form(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		return "registerform.jsp";
	}
	
	@RequestMapping(path="/register.do", method = HttpMethod.POST)
	public String register(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setTel(tel);
		user.setEmail(email);
		
		userService.register(user);
		
		return "redirect:home.do";
	}
	
}
