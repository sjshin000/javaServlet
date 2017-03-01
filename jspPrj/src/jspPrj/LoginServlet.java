package jspPrj;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//http://www.egovframe.go.kr/wiki/doku.php?id=egovframework:%EA%B8%B0%EC%97%85%ED%9A%8C%EC%9B%90_%EA%B4%80%EB%A6%AC%EA%B8%B0%EB%8A%A5
//회원가입 관리기능
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -5844191997202495126L;
//	private  inputId = null;
//	private String inputPwd = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputId = request.getParameter("id") ;
		String inputPwd = request.getParameter("pwd") ;  
	    
	    if (inputId != null && inputPwd != null) {
		    LoginModel loginModel = new LoginModel();
		    loginModel.setId(inputId);
		    loginModel.setPwd(inputPwd);
		   
			LoginProcess login = new LoginProcess();
			login.selectMember(loginModel);
			
			if (login.getIsLogin() == true) {
		        HttpSession session = request.getSession();
		        session.setAttribute("isLogin", "true");
				session.setAttribute("loginInfo", loginModel);
				//response.sendRedirect("/login/loginOk.jsp");
				request.getRequestDispatcher("/login/loginOk.jsp").forward(request, response);
		    }
		}
	} 	
}

