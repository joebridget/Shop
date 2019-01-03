package com.lxk.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCUtil {
    //创建线程 用于绑定连接
    private static ThreadLocal<Connection> thread = new ThreadLocal<>();
    //创建集合  存储配置文件信息
//    private static Properties properties = new Properties();
    //静态代码块  加载文件信息
//    static {
//        //读取文件信息
//        InputStream is = Object.class.getResourceAsStream("jdbc.properties");
//        try{
//            //把资源加载到集合中
//            properties.load(is);
//            //关闭资源
//            is.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    //方法  用于创建连接
    public static Connection getConnection() throws Exception{
        //从线程中获取链接资源
        Connection conn = thread.get();
        //如果线程中不存在连接  就创建一个 并且绑定在线程当中
        if(conn == null){
            //加载驱动
//            Class.forName(properties.getProperty("driver"));
            Class.forName("oracle.jdbc.OracleDriver");
            //连接数据库
//            conn = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","admin");
            //绑定线程
            thread.set(conn);
        }
        return conn;
    }
    //各种关闭资源   关闭原则  后创建的先关闭
    //关闭结果集
    public static void close(ResultSet rs){
        if(rs != null){try{rs.close();}catch (Exception e){e.printStackTrace();}}
    }
    //关闭载体
    public static void close(PreparedStatement pstm){
        if(pstm != null){try{pstm.close();}catch (Exception e){e.printStackTrace();}}
    }
    //关闭连接
    public static void close(Connection conn){
        if(conn != null){try{conn.close();thread.remove();}catch (Exception e){e.printStackTrace();}}
    }
    //关闭结果集 和 载体
    public static void close(ResultSet rs,PreparedStatement pstm){
        if(rs != null){try{rs.close();}catch (Exception e){e.printStackTrace();}}
        if(pstm != null){try{pstm.close();}catch (Exception e){e.printStackTrace();}}
    }
    //关闭 结果集 和 连接
    public static void close(ResultSet rs,Connection conn){
        if(rs != null){try{rs.close();}catch (Exception e){e.printStackTrace();}}
        if(conn != null){try{conn.close();thread.remove();}catch (Exception e){e.printStackTrace();}}
    }
    //关闭 载体 和 连接
    public static void close(PreparedStatement pstm,Connection conn){
        if(pstm != null){try{pstm.close();}catch (Exception e){e.printStackTrace();}}
        if(conn != null){try{conn.close();thread.remove();}catch (Exception e){e.printStackTrace();}}
    }
    //关闭结果集 载体  连接
    public static void close(ResultSet rs,PreparedStatement pstm,Connection conn){
        if(rs != null){try{rs.close();}catch (Exception e){e.printStackTrace();}}
        if(pstm != null){try{pstm.close();}catch (Exception e){e.printStackTrace();}}
        if(conn != null){try{conn.close();thread.remove();}catch (Exception e){e.printStackTrace();}}
    }
}
