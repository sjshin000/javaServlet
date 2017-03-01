package jspPrj;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.deploy.MultipartDef;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

import java.io.*;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		service(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
		int maxSize = 10 * 1024 * 1024 ; 
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println(root);
		String savePath = root + "upload";
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		String id = multi.getParameter("id") ;
		String userName = multi.getParameter("userName");
		String pwd = multi.getParameter("pwd");
		String address = multi.getParameter("address");
		String email = multi.getParameter("email");
		String tel = multi.getParameter("tel");
		String birth = multi.getParameter("birth");
		String sex = multi.getParameter("sex");
		String[] interest = multi.getParameterValues("interest");
		
		LoginModel loginModel = new LoginModel();
	    loginModel.setId(id);
	    loginModel.setPwd(pwd);
	    loginModel.setName(userName);
	    loginModel.setAddress(address);
	    loginModel.setEmail(email);
	    loginModel.setTel(tel);
	    loginModel.setBirth(birth);
	    loginModel.setSex(sex);
	    loginModel.setInterest(interest);
		
		JoinProcess join = new JoinProcess();
		try {
			join.insertMember(loginModel);
			response.sendRedirect("/index.jsp");
		} catch (SQLException e) {	
			throw new ServletException(e);
		}
		
	}
}
