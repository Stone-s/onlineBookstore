package web;

import base.BaseServlet;
import bean.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-26 20:06
 **/
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

       // TODO: 2021/4/26  这里的泛型可以再优化吗?
         User user=WebUtils.copyParamToBean(req.getParameterMap(),new User());

//        暂时写死验证码
        if (code.equalsIgnoreCase("123")) {
//            可以注册
            boolean isExistUser = userService.existUser(userName);
            if (isExistUser) {
//                不可用    跳转到注册页面
                req.setAttribute("msg", "用户名已存在!");
                req.setAttribute("username", userName);
                req.setAttribute("password", password);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
//                可以注册
                userService.register(new User(null, userName, password, email));
//                跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //            设置回显信息
            req.setAttribute("msg", "验证码错误!");
            req.setAttribute("username", userName);
            req.setAttribute("password", password);
            req.setAttribute("email", email);

//            跳转到注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
        String password = req.getParameter("password");
        System.out.println(userName + password);
        User user = userService.login(new User(userName, password));
        if (user != null) {
//            查询到用户信息 跳转到登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {
//            调回登录页面
            req.setAttribute("msg", "用户名或密码错误!");
            req.setAttribute("username", userName);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }
}
