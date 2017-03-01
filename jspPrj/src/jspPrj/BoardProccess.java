package jspPrj;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardProccess extends Connect {
	public void boardInsert(BoardModel board) {
		try {
			connect();
			insertQuery(board);
			
		} catch (SQLException ex) {
			throw new RuntimeException(ex);

		} finally {
			connectionClose();
		}
	}

	private void insertQuery(BoardModel board) throws SQLException {
		String title = board.getTitle();
		String description = board.getDescription();
		String writer = board.getWriter();
		Date creatDate = new Date();
		String query = "INSERT INTO board (title, description, writer, creatDate) VALUES(?,?,?,?)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, title);
		pstmt.setString(2, description);
		pstmt.setString(3, writer);
		pstmt.setDate(4, new java.sql.Date(creatDate.getTime()));
				
		pstmt.executeUpdate();
	}
	
	
	
	public List<BoardModel> boardList() throws SQLException {
		List<BoardModel> list;
		try {
			connect();
			list = boardSelectList();
			
		} finally {
			connectionClose();
		}
		return list;
	} 
	
	private List<BoardModel> boardSelectList() throws SQLException {
		List<BoardModel> list = new ArrayList<BoardModel>();
		String selectQuery = "SELECT * FROM board order by boardid desc";
		pstmt = conn.prepareStatement(selectQuery);
		rs = pstmt.executeQuery();
		
		while (rs != null && rs.next()) {
			BoardModel board = new BoardModel();
			
			int boardId = rs.getInt("boardId");
			String title = rs.getString("title");
			String description = rs.getString("description");
			String writer = rs.getString("writer");
			Date creatDate = rs.getDate("creatDate");
			Date updateDate = rs.getDate("updateDate");
			int	hit = rs.getInt("hit");
			
			board.setBoardId(boardId);
			board.setTitle(title);
			board.setDescription(description);
			board.setWriter(writer);
			board.setCreatDate(creatDate);
			board.setUpdateDate(updateDate);
			board.setHit(hit);
			
			list.add(board);
		}
		return list;
	}

	public BoardModel boardGet(int boardId) throws SQLException {
		BoardModel board = null;
		try {
			connect();
			board = boardSelect(boardId);
		} finally {
			connectionClose();
		}
		return board;
	}

	private BoardModel hitUpdate(BoardModel board) throws SQLException {
		int boardId = board.getBoardId();
		int hit = board.getHit()+1;
		String updateHit = "UPDATE board SET hit = ? WHERE boardId = ?";
		
		pstmt = conn.prepareStatement(updateHit);
		pstmt.setInt(1, hit);
		pstmt.setInt(2, boardId);
		pstmt.executeUpdate();
		
		return null;
	}
	
	private BoardModel boardSelect(int paramId) throws SQLException {
		String selectQueryId = "SELECT * FROM board WHERE boardId = ?";
		pstmt = conn.prepareStatement(selectQueryId);
		pstmt.setInt(1, paramId); 
		rs = pstmt.executeQuery();
		
		BoardModel board = new BoardModel();
		
		if (rs != null && rs.next()) {
			int boardId = rs.getInt("boardId");
			String title = rs.getString("title");
			String description = rs.getString("description");
			String writer = rs.getString("writer");
			Date creatDate = rs.getDate("creatDate");
			Date updateDate = rs.getDate("updateDate");
			int	hit = rs.getInt("hit");
			
			board.setBoardId(boardId);
			board.setTitle(title);
			board.setDescription(description);
			board.setWriter(writer);
			board.setCreatDate(creatDate);
			board.setUpdateDate(updateDate);
			board.setHit(hit);
			
			hitUpdate(board);
		}
		return board;
	}

	public BoardModel boardUpdate(BoardModel board) throws SQLException {
		try {
			connect();
			board = boardUpdeteQuery(board);
			
		} finally {
			connectionClose();
		}
		return board;
	}

	private BoardModel boardUpdeteQuery(BoardModel board) throws SQLException {
		int boardId = board.getBoardId();
		String title = board.getTitle();
		String description = board.getDescription();
		String writer = board.getWriter();
		Date updateDate = new Date();
		String updateQuery = "UPDATE board SET title=?, description=?, writer=?, updateDate=? WHERE boardId = ?";
		
		pstmt = conn.prepareStatement(updateQuery);
		pstmt.setString(1, title);
		pstmt.setString(2, description);
		pstmt.setString(3, writer);
		pstmt.setDate(4, new java.sql.Date(updateDate.getTime()));
		pstmt.setInt(5, boardId); 
		pstmt.executeUpdate();
		return null;
	}

	public void boardDelete(int boardId) throws SQLException {
		try {
			connect();
			boardDeleteQuery(boardId);
			
		} finally {
			connectionClose();
		}
	}

	private void boardDeleteQuery(int inputid) throws SQLException {
		int boardId = inputid;
		String deleteQuery = "DELETE FROM board WHERE boardId = ?";
		pstmt = conn.prepareStatement(deleteQuery);
		pstmt.setInt(1, boardId); 
		pstmt.executeUpdate();
	}
}
