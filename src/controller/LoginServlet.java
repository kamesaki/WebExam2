package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cookieService.CookieFac;
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
		
		Cookie[] cookies = request.getCookies();
		String valueId = "";
		String valuePass = "";
		String message ="";
		
		if(cookies != null) {
			for(Cookie c: cookies) {
				
				switch(c.getName()) {
				
				case ("id"):
					valueId = URLDecoder.decode(c.getValue(), "UTF-8");
					request.setAttribute("valueId", valueId);
					message = "また会ったな！<br>" + valueId + "！";
					break;
					
				case ("pass"):
					valuePass = URLDecoder.decode(c.getValue(), "UTF-8");
					request.setAttribute("valuePass",  valuePass);
					break;
			}
		}
	}
		
		request.setAttribute("title", message);
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/manageTop.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// クッキー生成処理
		Cookie idCookie = CookieFac.getCookie(id, "id");
		Cookie passCookie = CookieFac.getCookie(pass, "pass");
		
		// confirm.jspで表示されるメッセージ
		String message = "入力が不正です<br>やり直してください";
		
		if(idCookie != null && passCookie != null) {
			
			response.addCookie(idCookie); // レスポンスにIDのcookieを追加
			response.addCookie(passCookie); // レスポンスにパスワードのcookieを追加
			// if文を処理した（IDとPWが正常に入力された場合）のみ、メッセージが変わる！
			message = "クッキーを発行しました<br>TOPに戻ってみてね";
			// requestは、ブラウザからサーバーに要求を送る事。
		request.setAttribute("message", message);
		request.setAttribute("id", id);
		
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/mypage.jsp");
		dis.forward(request, response);
				
		}else {
			message = "入力が不正だぜ！";
			request.setAttribute("title", message);
			
			response.setContentType("text/html; charset=UTF-8");
			ServletContext context = getServletContext();
			RequestDispatcher dis = context.getRequestDispatcher("/manageTop.jsp");
			dis.forward(request, response);
		}
		

	}

}
