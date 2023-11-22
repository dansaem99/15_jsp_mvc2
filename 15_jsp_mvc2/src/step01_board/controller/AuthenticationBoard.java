package step01_board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO;
import step01_board.dto.BoardDTO;

@WebServlet("/bAuthentication")
public class AuthenticationBoard extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("boardDTO", BoardDAO.getInstance().getBoardDetail(Long.parseLong(request.getParameter("boardId"))));
		request.setAttribute("menu", request.getParameter("menu"));
		
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bAuthentication.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		long boardId = Long.parseLong(request.getParameter("boardId"));
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardId(boardId);
		boardDTO.setPassword(request.getParameter("password"));
		
		String menu = request.getParameter("menu");
		
		String jsScript = "";
		if (BoardDAO.getInstance().checkAuthorizeUser(boardDTO)) {
			
			if (menu.equals("update")) {
				// 업데이트 화면으로 이동
				jsScript = "<script>";
				jsScript += "location.href='bUpdate?boardId="+ boardId +"';";
				jsScript += "</script>";
				
			}
			if (menu.equals("delete")) {
				// 삭제 화면으로 이동
				jsScript = "<script>";
				jsScript += "location.href='bDelete?boardId="+ boardId +"';";
				jsScript += "</script>";
			}
			
		}
		else {
			// 뒤로가기
			jsScript = "<script>";
			jsScript += "alert('패스워드를 확인하세요.');";
			jsScript += "history.go(-1);";
			jsScript += "</script>";
			
		}
		
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	   
	    out.print(jsScript);
		
	}

}
