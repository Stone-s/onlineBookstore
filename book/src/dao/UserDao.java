package dao;

import bean.User;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-20 10:48
 **/
public interface UserDao {

    /**
     * 通过用户名查询用户信息
     *
     * @param name
     * @return
     */
    User queryByUsername(String name);


    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    int saveUser(User user);


    /**
     * 根据用户名和密码查询用户
     *
     * @param userName
     * @param password
     * @return
     */
    User queryByUserNameAndPassword(String userName, String password);
}
