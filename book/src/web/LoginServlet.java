package web;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-20 19:55
 **/
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
        String password = req.getParameter("password");
        System.out.println(userName+password);
        User user = userService.login(new User(userName, password));
        if (user != null){
//            查询到用户信息 跳转到登录成功页面
            System.out.println(user);
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        }else {
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        }

    }
}
