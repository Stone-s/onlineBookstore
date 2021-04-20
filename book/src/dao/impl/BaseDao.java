package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.Jdbcutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-20 10:25
 **/
public abstract class BaseDao {

    private static QueryRunner queryRunner=new QueryRunner();

    //    出现异常返回-1
    public int update(Connection conn, String sql, Object... args) {
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Jdbcutils.releaseConnection(conn);
        }
        return -1;

    }

    //    返回一个对象
    public <T> T queryForOne(Connection conn, Class<T> type, String sql, Object... args) {
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } finally {
            Jdbcutils.releaseConnection(conn);
        }
        return null;
    }


    //    返回多个javaBean对象
    public <T> List<T> queryForList(Connection conn, Class<T> type, String sql, Object... args) {
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } finally {
            Jdbcutils.releaseConnection(conn);
        }
        return null;

    }

    //    返回某个列的值

    public Object queryForScalar(Connection conn, String sql, Object... args) {
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Jdbcutils.releaseConnection(conn);
        }
        return null;
    }

}



