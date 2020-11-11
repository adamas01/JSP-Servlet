package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ElecDTO;
import service.ElecService;
import view.ModelAndView;

public class UpdateFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 수정을 하기 위해 폼 띄우기. 모델번호에 해당하는 정보 가져오기(조회수는 증가X)
		String modelNum = req.getParameter("modelNum");
		ElecDTO elec = ElecService.searchByModelNum(modelNum, false);
		
		
		req.setAttribute("elec", elec);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("View/update.jsp");
		return mv;
	}

}
