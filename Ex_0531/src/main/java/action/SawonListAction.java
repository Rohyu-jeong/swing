package action;

import java.io.IOException;
import java.util.List;

import dao.SawonDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.SawonVO;

@WebServlet("/sawon_list")
public class SawonListAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptno = 0; // 부서 번호를 담기 위한 변수
		
		// 넘어온 데이터를 문자열로 받는다.
		// 왜 why -> 맨 처음 실행할 때는 null이니까 정수로 바꾸려고 하면 
		// NumberFormatException이 일어난다.
		String str_deptno = request.getParameter("deptno");
		
		// nulld이 아니거나 empty가 아닌 경우에만 정수로 바꿔라
		if (str_deptno != null && !str_deptno.isEmpty()) {
			deptno = Integer.parseInt(str_deptno);
		}
		
		List<SawonVO> list = null;
		if (deptno == 0) {
			list = SawonDAO.getInstance().select();
		} else {
			list = SawonDAO.getInstance().select(deptno);
		}
		
		
		
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("sawon_list.jsp");
		disp.forward(request, response);
	
	}
}
