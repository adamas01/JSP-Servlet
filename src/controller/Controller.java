package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.ModelAndView;

public interface Controller {
	ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
