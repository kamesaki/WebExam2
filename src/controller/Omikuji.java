package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Omikuji
 */
@WebServlet("/Omikuji")
public class Omikuji extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] Ans = {"亀吉", "青吉", "舞吉", "守吉", "美奈吉", "大吉", "中吉", "末吉", "吉", "凶", "大凶"};
		int r = new java.util.Random().nextInt(10);
		
		request.setAttribute("omikuji", Ans[r]);
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/mypage.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/mypage.jsp");
		dis.forward(request, response);
	}

}