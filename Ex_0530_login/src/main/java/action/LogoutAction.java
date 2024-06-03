package action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutAction extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션객체는 static이라서 주소를 공유한다.
		// 어차피 객체를 여러 개 만들어도 하나만 생성되어 있다.
		HttpSession session = request.getSession();
		
		session.removeAttribute("vo");
		
		response.sendRedirect("login_form.jsp");
	}
}
