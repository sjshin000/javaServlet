package jspPrj;

import java.sql.SQLException;

public class LoginProcess extends Connect {	
	private boolean isLogin;

	public void selectMember(LoginModel loginModel) {
		try {
			connect();
			stmt = conn.createStatement();
			loginCheck(loginModel);
			
		} catch (SQLException ex) {
			throw new RuntimeException(ex);

		} finally {
			connectionClose();
		}
	}
	
	public boolean loginCheck(LoginModel loginModel) throws SQLException {
		String inputId = loginModel.getId();
		String inputPwd = loginModel.getPwd();
		String query = "SELECT * FROM member WHERE id = '" + inputId + "'";
		rs = stmt.executeQuery(query);	
		
		if (rs != null && rs.next()) {
			String userPwd = rs.getString("pwd");
			String userName = rs.getNString("name");
			
			if (inputPwd.equals(userPwd)) {
				System.out.println("로그인 성공");
				isLogin = true;
				loginModel.setName(userName);
			} else {
				System.out.println("로그인 실패");
				isLogin = false;
			}
			
		} else {
			System.out.println("존재하지 않는 아이디 입니다.");
			isLogin = false;
			//로그인 페이지로 리다이렉트
		}
		return isLogin;
	}

	public boolean getIsLogin() {
		return isLogin;
	}
}
