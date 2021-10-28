package co.micol.board.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.command.Command;
import co.micol.board.command.HomeCommand;
import co.micol.board.command.MemberJoin;
import co.micol.board.command.MemberJoinForm;
import co.micol.board.command.MemberLogin;
import co.micol.board.command.MemberLoginForm;
import co.micol.board.command.MemberLogout;
import co.micol.board.command.MemberSelect;
import co.micol.board.command.MemberSelectList;
import co.micol.board.command.NoticeDelete;
import co.micol.board.command.NoticeForm;
import co.micol.board.command.NoticeInsert;
import co.micol.board.command.NoticeList;
import co.micol.board.command.NoticeSelect;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String,Command> map = new HashMap<String,Command>();

    public FrontController() {
        super();
    }

	/**
	 * init: 서블릿 초기화하는 곳, 실행할 Command 메소드를 등록한다.
	 */
    public void init(ServletConfig config) throws ServletException {
    	//수행할 Command를 넣는 곳
    	map.put("/home.do", new HomeCommand()); //Home, 처음 호출했을 때 보여주는 페이지
    	map.put("/noticeList.do", new NoticeList()); //공지사항 목록
    	map.put("/noticeSelect.do", new NoticeSelect()); //세부 내역 보기
    	map.put("/noticeForm.do", new NoticeForm()); //게시글 입력하기
    	map.put("/noticeInsert.do", new NoticeInsert()); //게시글 저장
    	map.put("/noticeDelete.do", new NoticeDelete()); //게시글 삭제
		map.put("/memberSelectList.do", new MemberSelectList());
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //실제 로그인 처리
		map.put("/memberLogout.do", new MemberLogout()); //로그아웃
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입 폼 호출
		map.put("/memberJoin.do", new MemberJoin()); //회원가입 처리
		map.put("/memberSelect.do", new MemberSelect()); //로그인 되었을 때 내 정보 띄우기. 
    }

    //실제 요청을 분석하고 수행할 명령command를 찾아 실행한다. 그 후 결과를 보여줄 페이지를 선택한다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청분석
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI(); //요청명령을 분석하기 위해 URI를 구한다.
		String contextPath = request.getContextPath(); //프로젝트의 루트를 찾아낸다.
		String page = uri.substring(contextPath.length()); //실제 호출한 페이지 찾기,실제 수행해야할 호출명을 구한다.
		
		//명령찾기
		Command command = map.get(page); //command라는 인터페이스를 통해 명령을 호출한다
		String viewPage = command.run(request, response); //명령을 실행하고 돌려줄 페이지(viewPage)를 받는다.
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp"; //보여줄 페이지 찾기 => view Resolve
		}
		
		//요청을 페이지에 보여준다. DAO에서 가져온 값을 담고 가는 dispatcher(db에서 받아온 값을 그대로 전달하기 위해 dispatcher 사용)
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //명령에서 돌아온 값을 request객체에 담고 그것을 dispatcher라는 변수에 담는다.
		dispatcher.forward(request, response); //dispatcher를 통해 명령에서 돌아온 값을 페이지로 보여준다.
				
	}

}
