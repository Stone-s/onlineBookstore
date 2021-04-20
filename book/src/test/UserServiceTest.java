package test;

import bean.User;
import org.junit.Test;
import service.UserService;
import service.impl.UserServiceImpl;

import static org.junit.Assert.*;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-20 11:35
 **/
public class UserServiceTest {
    UserService userService=new UserServiceImpl();

    @Test
    public void register() {
        User user = new User("李四", "123123");
        userService.register(user);


    }

    @Test
    public void login() {
        User user = userService.login(new User("王五", "123"));
        System.out.printf(user.toString());
    }

    @Test
    public void existUser() {
        boolean isExist = userService.existUser("");
        if (isExist) {
            System.out.println("该用户名已存在,请重试");
        }else {
            System.out.println("该用户名可以使用");
        }
    }
}