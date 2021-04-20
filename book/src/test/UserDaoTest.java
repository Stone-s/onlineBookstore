package test;

import bean.User;
import dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-20 11:12
 **/
public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void queryByUsername() {

        User user = userDao.queryByUsername("张三");
//        这里能这么写吗?
        if (user==null) {
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名不可用");
        }

    }

    @Test
    public void saveUser() {
        User newUser = new User(null, "王五", "123", ":1234@qq.com");
        int affectedLines = userDao.saveUser(newUser);
        if (affectedLines>0){
            System.out.println("用户信息插入成功!");
        }
    }

    @Test
    public void queryByUserNameAndPassword() {
        if (userDao.queryByUserNameAndPassword("王五","123")==null) {
            System.out.println("用户名或密码错误,请检查后重新输入!");
        }
        else {
            System.out.println("登录成功!");

        }
    }
}