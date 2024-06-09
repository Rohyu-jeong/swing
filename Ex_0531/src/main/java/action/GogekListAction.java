package action;

import java.io.IOException;
import java.util.List;

import dao.GogekDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.GogekVO;

@WebServlet("/gogek_list")
public class GogekListAction extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = "all";
		
		// gogek_list -> null(메모리 할당도 안 됐음)
		// gogek_list?search= -> empty 상태 (메모리 할당은 됐는데 내용이 없음)
		
		String str_search = request.getParameter("search");
		
		// 정상적으로 값이 들어온 경우
		if(str_search != null && !str_search.isEmpty()) {
			search = str_search;
		}
		
		List<GogekVO> list = null;
		if(search.equals("all")) {
			list = GogekDAO.getInstance().select();
		} else {
			list = GogekDAO.getInstance().select(search);
		}
		
		
		
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("gogke_list.jsp");
		disp.forward(request, response);
		
	}
}
