package co.micol.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberSelectList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = dao.memberSelectList();
		
		request.setAttribute("members", list);  //넘어온 값을 보여줄 페이지에 전달하기 위해 request 객체에 담기
		return "member/memberSelectList";		//결과를 request 객체에 담는다.(members 라는 이름으로 list 담는다.) 
	}											//list 는 실제 넘어온 값. member는 페이지에 넘길 변수 명. -> members 라는 이름으로 list 담는다.
	
	
}
