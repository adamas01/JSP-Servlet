package controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ElecDTO;
import service.ElecService;
import view.ModelAndView;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String modelNum = req.getParameter("modelNum");
		String modelName = req.getParameter("model_name"); 
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		String pw = req.getParameter("password");
				
		ElecDTO elec = new ElecDTO(modelNum, modelName, Integer.parseInt(price), description, pw);
		ElecService.editPost(elec);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("elec?command=read&modelNum="+URLEncoder.encode(modelNum, "UTF-8")+"&flag=1");
		mv.setRedirect(true);
		return mv;
	}

}
