package jspPrj;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardDeleteServlet() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	request.setCharacterEncoding("UTF-8");
    	int boardId = Integer.parseInt(request.getParameter("boardId"));
    	BoardProccess boardProccess = new BoardProccess();
    	try {
			boardProccess.boardDelete(boardId);
			response.sendRedirect("/BoardServletList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
