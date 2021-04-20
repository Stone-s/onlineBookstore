package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-18 20:29
 **/
public class Jdbcutils {

    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            InputStream stream = Jdbcutils.class.getClassLoader().getResourceAsStream("jdbc.properties");
//           从流中加载数据
            properties.load(stream);
//            创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //    获取连接
    public static Connection getConnection() {
        Connection connection=null;
        try {
           return connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    //  关闭资源
    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
