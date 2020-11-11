package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ElecDTO;
import service.ElecService;
import view.ModelAndView;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<ElecDTO> list = ElecService.selectAll();
		req.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("View/list.jsp");
		return mv;
	}

}
