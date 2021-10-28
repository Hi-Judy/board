package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainCommand implements Command {
	
	@Override
	public String run (HttpServletRequest request, HttpServletResponse response) {
		// main 페이지를 돌려준다.
		
		return "main/main"; // views/main/main.jsp
		
	}
}
