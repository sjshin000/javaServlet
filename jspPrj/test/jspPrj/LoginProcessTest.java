package jspPrj;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class LoginProcessTest {

	@Test
	public void testPass() throws SQLException {
		LoginProcess input = new LoginProcess();
//		input.selectMember("sjshin", "0000");
		//assertEquals(true, input.loginCheck("sjshin", "0000"));
	}
	
//	@Test
//	public void testIdF() {
//		LoginProcess inpyt1 = new LoginProcess();
//		inpyt1.selectMember(null, "0000");
//		assertEquals(false, inpyt1.getIsLogin());
//	}
//	
//	
//	@Test
//	public void testPwdF() {
//		LoginProcess inpyt3 = new LoginProcess();
//		inpyt3.selectMember("sjshin", "00100");
//		assertEquals(false, inpyt3.getIsLogin());
//	}
}
