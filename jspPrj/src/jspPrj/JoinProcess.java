package jspPrj;

import java.sql.SQLException;

public class JoinProcess extends Connect {
	public void insertMember(LoginModel loginModel) throws SQLException {
		try {
			connect();
			insertQuery(loginModel);
		} finally {
			connectionClose();
		}
	}

	public void insertQuery(LoginModel loginModel) throws SQLException {
		String id = loginModel.getId();
		String pwd = loginModel.getPwd();
		String name = loginModel.getName();
		String address = loginModel.getAddress();
		String email = loginModel.getEmail();
		String tel = loginModel.getTel();
		String birth = loginModel.getBirth();
		String sex = loginModel.getSex();
		String[] interest = loginModel.getInterest();
		String interests = "";
		for(String tempStr : interest){
			interests += tempStr + ",";
		}
		String insertQuery = "INSERT INTO member (id,pwd,name,address,email,tel,birth,sex,interest) VALUES(?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(insertQuery);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		pstmt.setString(4, address);
		pstmt.setString(5, email);
		pstmt.setString(6, tel);
		pstmt.setString(7, birth);
		pstmt.setString(8, sex);
		pstmt.setString(9, interests);
		pstmt.executeUpdate();
	}
}
