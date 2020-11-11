package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ElecDTO;
import service.ElecService;
import view.ModelAndView;

public class ReadController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			String modelNum = req.getParameter("modelNum");
			String flag = req.getParameter("flag");
			
			boolean state = flag == null? true: false;
			
			ElecDTO elec = ElecService.searchByModelNum(modelNum, state);
			
			req.setAttribute("elec", elec);
			
			ModelAndView mv = new ModelAndView();
			
			mv.setViewName("View/read.jsp");
			
		return mv;
	}

	
		

}
