
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 * @author ibm
 */

public class SessionListener implements ServletContextListener, HttpSessionListener {

    public void contextInitialized(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void sessionCreated(HttpSessionEvent se) {
      //  throw new UnsupportedOperationException("Not supported yet.");
        String current =(String)se.getSession().getServletContext().getAttribute("online");
        if(current==null) current="0";
        int c=Integer.parseInt(current);
        c++;
        current=String.valueOf(c);
        se.getSession().getServletContext().setAttribute("online", current);

        String his=(String)se.getSession().getServletContext().getAttribute("Counter");
        if(his==null) his="0";
        int total = Integer.parseInt(his)+1;
        his=String.valueOf(total);
        se.getSession().getServletContext().setAttribute("Counter", his);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      // throw new UnsupportedOperationException("Not supported yet.");
        String current=(String)se.getSession().getServletContext().getAttribute("online");
        if(current==null)current="0";
        int c=Integer.parseInt(current);
        c--;
        current=String.valueOf(c);
        se.getSession().getServletContext().setAttribute("online", c);
    }
}