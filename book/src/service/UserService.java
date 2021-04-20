package service;

import bean.User;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-20 11:28
 **/
public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean  register(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null,登录失败,否则,登录成功
     */
     User login(User user);

    /**
     * 检查用户名是否可用
     * @param userName
     * @return 如果返回true,说明该用户名在数据库中已存在,不可使用,返回false代表可以使用
     */
    boolean existUser(String  userName );

}
