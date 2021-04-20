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
 * @create: 2021-04-20 17:42
 **/
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
//        暂时写死验证码
        if (code.equalsIgnoreCase("123")) {
//            可以注册
            boolean isExistUser = userService.existUser(userName);
            if (isExistUser) {
//                不可用    跳转到注册页面
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
//                可以注册
                userService.register(new User(null, userName, password, email));
//                跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        } else {
//            跳转到注册页面
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            System.out.println("验证码错误" + code);
        }

    }
}
