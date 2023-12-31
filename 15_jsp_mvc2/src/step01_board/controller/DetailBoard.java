package step01_board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step01_board.dao.BoardDAO;

@WebServlet("/bDetail")
public class DetailBoard extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("boardDTO" , BoardDAO.getInstance().getBoardDetail(Long.parseLong(request.getParameter("boardId"))));
		
		RequestDispatcher dis = request.getRequestDispatcher("step01_boardEx/bDetail.jsp");
		dis.forward(request, response);
		
	}

}
