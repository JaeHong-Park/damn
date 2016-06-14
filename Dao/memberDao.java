package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Db.Dbclose;
import Db.Dbconnection;
import Dto.memberDto;

public class memberDao {
	Connection conn;
	memberDto dto;
	
	public int join(memberDto member_dto){
		conn = Dbconnection.makeConnection();
		int cnt =0;
		Statement stmt = null;
		dto = member_dto;
		
		String sql = "insert into member(id, pw, nickname, email, sex, recommend, question, answer) \n";
		   	   sql += "values('" + dto.getId() + "', '"+ dto.getPw() + "', '" + dto.getNickname() + "', '" + dto.getEmail() +"', '"+ dto.getSex() + "', '"
		   			   + dto.getRecommend() + "', '" + dto.getQuestion() + "', '" + dto.getAnswer() + "')";
		System.out.println("sql = " + sql);
		
		try{
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql);
		}catch(SQLException e){
			System.out.println(e. getMessage());
		}finally{
			Dbclose.close(stmt, conn);
		}
		return cnt;
	}
	
	public memberDto search(memberDto member_dto){
		conn = Dbconnection.makeConnection();
		Statement stmt = null;
		ResultSet rs = null;
		dto = member_dto;
		
		String sql = "select id, pw, nickname, email, sex, recommend, question, answer \n";
			   sql += "from member \n";
			   sql += "where id = '" + dto.getId() +"'";
		System.out.println("sql =" + sql);
		
		try{
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
			 
			 while(rs.next()){
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setNickname(rs.getString("nickname"));
				dto.setEmail(rs.getString("email"));
				dto.setSex(rs.getString("sex"));
				dto.setRecommend(rs.getString("recommend"));
				dto.setQuestion(rs.getString("question"));
				dto.setAnswer(rs.getString("answer"));
			 }
			 
		}catch( SQLException e){
				System.out.println(e.getMessage());
		}
		finally{
				Dbclose.close(stmt, conn, rs);
		}
		return dto;
	}
}
