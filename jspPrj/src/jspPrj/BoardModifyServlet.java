package jspPrj;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardModify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardModifyServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	serviceGet(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	serviceUpdate(request, response);
	}

	
	protected void serviceGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		BoardProccess boardProccess = new BoardProccess();
		
		try {
			BoardModel board = boardProccess.boardGet(boardId);
			request.setAttribute("board", board);
			request.getRequestDispatcher("/board/boardModify.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void serviceUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int inputBoardId = Integer.parseInt(request.getParameter("boardId"));
		System.out.println(inputBoardId);
		String inpuTitle = request.getParameter("title");
		String inputWriter = request.getParameter("writer");
		String inputDescription = request.getParameter("description");
		
		BoardModel boardModel = new BoardModel();
		boardModel.setBoardId(inputBoardId);
		boardModel.setTitle(inpuTitle);
		boardModel.setWriter(inputWriter);
		boardModel.setDescription(inputDescription);
		
		if(null != inpuTitle && null != inputWriter && null != inputDescription) {
			BoardProccess boardProccess = new BoardProccess();
			try {
				boardProccess.boardUpdate(boardModel);
				response.sendRedirect("/BoardServletList");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
