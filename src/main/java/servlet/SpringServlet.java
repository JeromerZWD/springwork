package servlet;

import entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.AccountService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SpringServlet", urlPatterns = "/SpringServlet")
public class SpringServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        ApplicationContext ctx= WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //2. 从 IOC 容器中得到需要的 bean
        AccountService  accountService=(AccountService)ctx.getBean("accountService");
       List<Account> list=accountService.queryAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
}
