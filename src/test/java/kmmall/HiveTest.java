package kmmall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HiveTest {

    //查询数据
    @Test
    public void selectUidPidData() throws SQLException {
    	sql = "select * from uid_pid";
    	System.out.println("Running:"+sql);
    	res = stmt.executeQuery(sql);
    	while (res.next()){
    		System.out.println(res.getString("uid") + 
    				"\t\t" + res.getString("pid"));
    	}
    }
    @Test
    public void countUidPidData() throws SQLException {
    	sql = "select count(*) from uid_pid";
    	System.out.println("Running:"+sql);
    	res = stmt.executeQuery(sql);
    	while (res.next()){
    		System.out.println(res.getString(1));
    	}
    }

	
	
	
	//首先，在hive中，通过命令： hive --service hiveserver2    启动hive服务
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	private static String url = "jdbc:hive2://172.16.85.131:10000/default";
	private static String user = "root";
	private static String password = "123123";
	private static String sql = "";
	private static ResultSet res;

	private static Connection conn;
	private static Statement stmt;

	// 加载驱动、创建连接
	@Before
	public void init() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
	}

	// 创建数据库
	@Test
	public void createDatabase() throws SQLException {
		sql = "create database hive_jdbc";
		System.out.println("Running:" + sql);
		stmt.execute(sql);
	}

	// 查询所有数据库
	@Test
	public void showDatabases() throws SQLException {
		sql = "show databases";
		System.out.println("Running:" + sql);
		res = stmt.executeQuery(sql);
		while (res.next()) {
			System.out.println(res.getString(1));
		}
	}


    //创建表
    @Test
    public void createTable() throws SQLException {
        sql= "create table emp1("
        		+ "id int,name string,age int)"
        		+ " row format delimited "
        		+ "fields terminated by ','";
        System.out.println("Running:"+sql);
        stmt.execute(sql);
    }


    //查看表结构
    @Test
    public void descTable() throws SQLException {
        sql ="desc emp1";
        System.out.println("Running:"+sql);
        res = stmt.executeQuery(sql);
        while (res.next()){
            System.out.println(res.getString(1)+
            		"\t"+res.getString(2));
        }
    }


    //加载数据
    @Test
    public void loadData() throws SQLException {
        String filePath = "'/opt/emp.test'";
        sql="load data local inpath "+filePath+""
        		+ " "+"into table emp1";
        System.out.println("Running:"+sql);
        stmt.execute(sql);
    }

    //查询数据
    @Test
    public void selectData() throws SQLException {
        sql = "select * from emp1";
        System.out.println("Running:"+sql);
        res = stmt.executeQuery(sql);
        while (res.next()){
            System.out.println(res.getString("id") + 
            		"\t\t" + res.getString("name") +
            		"\t\t" + res.getString("age"));
        }
    }



    // 统计查询（会运行mapreduce作业）
    @Test
    public void countData() throws Exception {
        sql = "select count(1) from emp1";
        System.out.println("Running: " + sql);
        res = stmt.executeQuery(sql);
        while (res.next()) {
            System.out.println(res.getInt(1) );
        }
    }

    // 删除数据库
    @Test
    public void dropDatabase() throws Exception {
        String sql = "drop database if exists hive_jdbc";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 删除数据库表
    @Test
    public void dropTable() throws Exception {
        String sql = "drop table if exists emp1";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 释放资源
    @After
    public void destory() throws Exception {
        if ( res != null) {
            res.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
