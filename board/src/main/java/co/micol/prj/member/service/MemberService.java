package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	//interface에는 CRUD가 포함되어야한다.
	//메소드 명과 jsp 페이지명은 같아아한다. memberInsert() == memberInsert.jsp
	List <MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
	//로그인 체크
	MemberVO memberLogin(MemberVO vo);
	//중복 체크
	boolean isIdCheck(String id);
	
	
}
