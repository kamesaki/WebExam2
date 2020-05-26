package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ItemDto;

/**
 * Session学習用サーブレット
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * セッションを破棄し、ログインページに遷移する(ログアウト処理時、ログイン失敗時、不正操作時など)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// セッションの取得(なければnullが返ってくる)
		// ここに処理を記入してください
		HttpSession session = request.getSession(false);
		// セッションの破棄
		// ここに処理を記入してください
		if(session != null) session.invalidate();
		// ログイン失敗時、ログアウト時、不正操作時以外の場合
		if(request.getAttribute("message") == null) request.setAttribute("message", "名前とパスワードを入力してください");
				
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/top.jsp");
		dis.forward(request, response);
		
		
	}

	/**
	 * 受取るパラメータをもとにページ遷移を行う
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String fileName = "top";
		String button = request.getParameter("button");
		
		try {
			// セッションの取得
			// ここに処理を記入してください
			HttpSession session = request.getSession(false);
			ItemDto pBean = null;
			
			// セッションに格納されているオブジェクトを取得
			// ここに処理を記入してください
			if(session != null) pBean = (ItemDto) session.getAttribute("bean");
		
			// ログインボタンが押された場合
			if(button.equals("login")) {
				
				// ログイン成功時の処理
				if(request.getParameter("pass").equals("reglecasse")) {
					
					// 新規セッションの取得
					// ここに処理を記入してください
					HttpSession newSession = request.getSession(true);
					//セッションの制限時間
					newSession.setMaxInactiveInterval(60);
					
					pBean = new ItemDto();
					pBean.setName(request.getParameter("name"));
					
					// セッションにオブジェクトを格納
					// ここに処理を記入してください
					newSession.setAttribute("bean", pBean);
					fileName = "myPage";
					
				// ログイン失敗時の処理
				}else {
					request.setAttribute("message", "ログインに失敗しました");
					doGet(request, response);
					return;
				}
				
			// profileボタンが押された場合
			}else if(button.equals("profile") && pBean != null) {
				fileName = "ask1";
				
			// logoutボタンが押された場合
			}else if(button.equals("logout") && pBean != null) {
				request.setAttribute("message", "ログアウトしました");
				doGet(request, response);
				return;
				
			// nextボタンが押された場合
			}else if(button.equals("next") && pBean != null) {
				String askNo = request.getParameter("askNo");

				// ask1.jspから飛んできた場合
				if(askNo.equals("1")) {
					
					// ここに処理を記入してください
					pBean.setAge(request.getParameter("age"));
					session.setAttribute("bean", pBean);
					fileName = "ask2";
					
				// ask2.jspから飛んできた場合
				}else if(askNo.equals("2")) {
					
					// ここに処理を記入してください
					pBean.setGender(request.getParameter("gender"));
					session.setAttribute("bean", pBean);
					fileName = "ask3";
					
				}else if(askNo.equals("3")) {
					
					// ここに処理を記入してください
					pBean.setSnack(request.getParameter("snack"));
					session.setAttribute("bean", pBean);
					fileName = "myPage";
				}
				
			// 不正な操作が行われた場合
			}else {
				request.setAttribute("message", "セッションが不正です");
				doGet(request, response);
				return;
			}
				
		}catch(Exception e) {
			request.setAttribute("message", "セッションが不正です");
			doGet(request, response);
			return;
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/" + fileName + ".jsp");
		dis.forward(request, response);
	}
}
