package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.ModelAndView;
/**
 * 사용자 요청을 중앙집중적으로 관리해 줄
 * FrontController 
 *  : 사용자 요청을 받아서 그에 해당하는 Controller를
 *    찾아서 호출하고 그결과(ModelAndView)를 받아서 해당하는
 *    뷰페이지로 이동시킨다.
 */

@WebServlet(urlPatterns = "/elec", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	
	//properties의 키|값을 넣을 Map을 선언
    private Map<String, Controller> map;
    
    @Override
    public void init() throws ServletException {
    	//attribute로 해당 map값을 받아 위에 선언한 map에 넣는다.
    	map = (Map<String, Controller>)getServletContext().getAttribute("map");
    	
    }
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//파라미터로 command값을 가져와 key에 넣는다.
    	String key = req.getParameter("command");
    	
    	//키 값이 null이거나 공백과 같으면 키에 list를 넣어준다.
    	if(key==null||key=="") key="list";
    	try {
    		ModelAndView mv = map.get(key).handleRequest(req, resp);
    		
    		if(mv.isRedirect()) {
    			resp.sendRedirect(mv.getViewName());
    		}else {
    			RequestDispatcher rd = req.getRequestDispatcher(mv.getViewName());
    			rd.forward(req, resp);
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    		req.setAttribute("errorMsg", e.getMessage());
    		req.getRequestDispatcher("errorView/error.jsp").forward(req, resp);
    	}
    
    }

}
