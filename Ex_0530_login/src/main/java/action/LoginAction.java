package action;

import java.io.IOException;

import dao.MemberDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.MemberVO;

@WebServlet("/login.do")
public class LoginAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberVO vo = MemberDAO.getInstance().selectOne(id);
		
		String param = "";
		String resultStr = "";
		
		if (vo == null) {
			param = "no_id";
			resultStr = String.format("[{'param':'%s'}]", param);
			response.getWriter().print(resultStr);
			return;
		}
		
		if (!vo.getPwd().equals(pwd)) {
			param = "no_pwd";
			resultStr = String.format("[{'param':'%s'}]", param);
			response.getWriter().print(resultStr);
			return;
		}
		
		// 아이디와 비밀번호 체크가 문제가 없다면 세션에 바인딩한다.
		// 세션은 서버의 메모리를 사용하기 때문에 많이 사용할수록 브라우저가 느려지기 때문에
		// 필요한 곳에서만 사용하도록 하자
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600); // 초단위로 써야함
		session.setAttribute("vo", vo);
		
		// 포워딩을 할 필요가 없고 어느 jsp에서든 el표현식으로 사용할 수 있다.
		param = "clear";
		resultStr = String.format("[{'param'}]", param);
		response.getWriter().print(resultStr);
		
		
		
		
	}
}
