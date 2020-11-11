package listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import controller.Controller;

@WebListener
public class HandlerMappingListener implements ServletContextListener {

	/**
	 * 미리 생성할 객체를 생성해서 Map에 저장하고 
	 * Map에 application영역에 저장한다.
	 * */
    public void contextInitialized(ServletContextEvent e)  { 
    	ServletContext application = e.getServletContext();
    	String fileName = application.getInitParameter("fileName");
    	
    	Map<String, Controller> map = new HashMap<String, Controller>();
    	
    	ResourceBundle rb = ResourceBundle.getBundle(fileName);
    	for(String key:rb.keySet()) {
    		String value = rb.getString(key);
    		try {
    			Controller controller = (Controller)Class.forName(value).newInstance();
    			map.put(key, controller);
    			System.out.println(key+":"+controller);
    		}catch(Exception ex) {
    			ex.printStackTrace();
    		}
    	}
    	application.setAttribute("map", map);
    	
    }
	
}
