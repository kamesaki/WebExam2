package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbAccess.DBAccess;
import dbAccess.SelectForLogin;
import dto.ItemDto;

/**
 * ログイン時に呼び出されるサーブレット<br>
 * ・doGet...ログインページに遷移<br>
 * ・doPost...データ照合処理を呼び出し、成功時は管理ページにリダイレクト、失敗時はログインページに戻る
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/manageTop.html");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String button = request.getParameter("button");
		
		if(button.equals("login")) {
			if(request.getParameter("pass").equals("1234567890")) {
				
				HttpSession newSession = request.getSession(true);
				
				ItemDto Item = new ItemDto();
				Item.setUserName(request.getParameter("userName"));
			
				newSession.setAttribute("item", Item);
			}else {
				request.setAttribute("message", "ログインに失敗しました");
				doGet(request, response);
				return;
			}
		}
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/mypage.jsp");
		dis.forward(request, response);
	}
}
