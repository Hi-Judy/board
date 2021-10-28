package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 과정
		HttpSession session = request.getSession();	//세션 객체를 불러온다
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id")); //폼에서 입력값을 vo 객체에 담음
		vo.setPassword(request.getParameter("password"));
		
		vo = memberDao.memberLogin(vo);
		String page = null;
		if(vo.getName() != null) {
			session.setAttribute("id", vo.getId()); //session에 값(id)을 담아놓는다. 
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("name", vo.getName());
			page = "member/memberLoginSuccess";
		}else {
			page = "member/memberLoginFail";
		}
		return page;
	
	}

}
