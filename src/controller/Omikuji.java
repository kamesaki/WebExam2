package controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
		String[] Ans = {"(´· ·`)なぎお(´· ·`)", "井田吉(ﾟ⊿ﾟ)ｶﾏﾜﾅｲﾖ", "中吉", "守吉(๑`·ᴗ·´๑)", "美奈吉ヽ(。·ω·。)ﾉ", "大吉", "舞吉(´◠ω◠`)", "青吉✌✌(๏д๏)✌✌", "吉", "亀吉・。・", "冨吉(`·_·´ )"};
		int r = new java.util.Random().nextInt(3);
		
		request.setAttribute("omikuji", Ans[r]);
		
		Cookie[] cookies = request.getCookies();
		String id = "";
		
		if(cookies != null) {
			for(Cookie c: cookies) {
				
				switch(c.getName()) {
				
				case ("id"):
					id = URLDecoder.decode(c.getValue(), "UTF-8");
					request.setAttribute("id", id);
					break;
					
			}
		}
	}
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/mypage.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getAttribute("id");
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/mypage.jsp");
		dis.forward(request, response);
	}

}
