package jspPrj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardWrite")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String inputTitle = request.getParameter("title");
		String inputWriter = request.getParameter("writer");
		String inputDescription = request.getParameter("description");
		
		if (null != inputTitle && null != inputWriter && null != inputDescription) {
			BoardModel board = new BoardModel();
			board.setTitle(inputTitle);
			board.setWriter(inputWriter);
			board.setDescription(inputDescription);
			
			BoardProccess boardProccess = new BoardProccess();
			boardProccess.boardInsert(board);
	
			response.sendRedirect("/BoardServletList");
		}
	}
}
