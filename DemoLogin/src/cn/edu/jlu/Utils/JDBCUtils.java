package cn.edu.jlu.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 连接池的工具类
 */
public class JDBCUtils {
    private static DataSource  ds;
    static{
        try {
            Properties pro=new Properties();
            ClassLoader classLoader=JDBCUtils.class.getClassLoader();
            InputStream is=classLoader.getResourceAsStream("druid.properties");
            pro.load(is);
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接方法
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    }

    /**
     * 释放资源方法
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn ){
        try {
            if(stmt!=null){
                stmt.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * 释放资源方法
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs,Statement stmt, Connection conn ){
        try {
            if(rs!=null){
                rs.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(stmt!=null){
                stmt.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * 获取连接池方法
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
