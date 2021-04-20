package test;


import org.junit.Test;
import utils.Jdbcutils;

import java.sql.SQLException;

/**
 * @program: untitled
 * @description:
 * @author: stone
 * @create: 2021-04-18 21:29
 **/


public class JdbcUtilsTest {
    @Test
    public void testJDBCUtils() throws SQLException {
        System.out.println(Jdbcutils.getConnection());
    }
}
