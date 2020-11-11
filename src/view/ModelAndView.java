package view;
/**
 * 각각의 Controller의 구현체가 실행된 후에
 * 이동해야할 뷰의정보와 이동방식을 관리해 줄 객체
 * */

public class ModelAndView {
	String ViewName;//이동페이지
	boolean isRedirect;//이동방식
	
	public ModelAndView() {}

	public ModelAndView(String viewName, boolean isRedirect) {
		super();
		ViewName = viewName;
		this.isRedirect = isRedirect;
	}

	//getter,setter생성
	public String getViewName() {
		return ViewName;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setViewName(String viewName) {
		ViewName = viewName;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
	
	
}
