package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ElecService;
import view.ModelAndView;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String modelNum = req.getParameter("modelNum");
		String password = req.getParameter("password");
		String path = req.getServletContext().getRealPath("/save");
		
		ElecService.delete(modelNum, password, path);
		
		ModelAndView mv = new ModelAndView("elec",true);
		return mv;
				
	}
	
}

