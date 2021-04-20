package dao.impl;

import bean.User;
import dao.UserDao;
import utils.Jdbcutils;

import java.sql.Connection;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-20 10:55
 **/
public class UserDaoImpl extends BaseDao implements UserDao {
     Connection connection = null;


    @Override
    public User queryByUsername(String name) {
        connection = Jdbcutils.getConnection();
        String sql = "select  * from  userinfo where  username=?";
        User user = queryForOne(connection, User.class, sql, name);
        return user;
    }

    @Override
    public int saveUser(User user) {
        connection = Jdbcutils.getConnection();
        String sql = "insert into  userinfo(username, password, email) values (?,?,?);";
        int update = update(connection, sql, user.getUsername(), user.getPassword(), user.getEmail());
        return update;
    }

    @Override
    public User queryByUserNameAndPassword(String userName, String password) {
        connection = Jdbcutils.getConnection();
        String sql="select * from userinfo where username=? and password=?";
        User user = queryForOne(connection, User.class, sql, userName, password);
        return user;
    }
}
