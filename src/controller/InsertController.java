package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import domain.ElecDTO;
import service.ElecService;
import view.ModelAndView;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String saveDir = req.getServletContext().getRealPath("/save");
		int maxSize = 1024*1024*100;
		String encoding="UTF-8";
		//cos lib안에 MultipartRequest 생성자를 생성하고 request, 데이터 받는 String, maxSize, encoding과 fileRename값 넣기
		MultipartRequest multi = new MultipartRequest(req, saveDir,maxSize, encoding, new DefaultFileRenamePolicy());

		String modelNum = multi.getParameter("model_num");
		String modelName = multi.getParameter("model_name");
		String price = multi.getParameter("price");
		String description = multi.getParameter("description");
		String pw = multi.getParameter("password");
		
		ElecDTO elec = new ElecDTO(modelNum, modelName, Integer.parseInt(price), description, pw);
		if(multi.getFilesystemName("file")!=null) {
			elec.setFname(multi.getFilesystemName("file"));
			elec.setFsize((int)multi.getFile("file").length());
		}
		ElecService.writing(elec);
		ModelAndView mv = new ModelAndView("elec",true);

		return mv;

	}
}
