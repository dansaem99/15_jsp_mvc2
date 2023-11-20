package step01_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private void getConnection() {
		
		try {
			
			/*
			
			이클립스에서 Servers폴더에 있는 Context.xml파일에 아래의 설정 추가 
			context은 경로다. xml은 설정파일이다. Context.xml 경로 설정파일이다.

			<Resource 
				auth="Container" 
				driverClassName="com.mysql.cj.jdbc.Driver"
				type="javax.sql.DataSource" 
				url="jdbc:mysql://localhost:3306/MVC2_PRACTICE?serverTimezone=Asia/Seoul&amp;useSSL=false"
				name="jdbc/board" 
				username="root"
				password="1234" 
				loginTimeout="10" 
				maxWait="5000" 
			/> 

			 */

			/*
			 *  import javax.naming.Context;
			 *	import javax.naming.InitialContext;
			 *	import javax.sql.DataSource;
			 */
			
			Context initctx = new InitialContext();
			// lookup 메서드를 통해 context.xml 파일에 접근하여 자바환경 코드를 검색
			Context envctx = (Context) initctx.lookup("java:comp/env");
			// <Context>태그안의 <Resource> 환경설정의 name이 jdbc/board인 것을 검색
			DataSource ds = (DataSource) envctx.lookup("jdbc/board");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
