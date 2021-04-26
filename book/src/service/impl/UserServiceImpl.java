package service.impl;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-20 11:31
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    //TODO 是不是要加入注册成功判断
    @Override
    public boolean register(User user) {
        userDao.saveUser(user);
        return false;
    }

    @Override
    public User login(User user) {
        return userDao.queryByUserNameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUser(String  userName) {
        if (userDao.queryByUsername(userName)==null) {
//            说明这个用户名不存在,可以注册
            return false;
        }
//        说明存在
        return true;
    }
}
