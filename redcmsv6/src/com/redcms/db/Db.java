package com.redcms.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.log4j.Logger;

import com.alibaba.druid.pool.DruidDataSource;

//操作数据库的工具类
public class Db{ //extends QueryRunner
	
	private static Logger log = Logger.getLogger(Db.class);
	private static QueryRunner run =  new QueryRunner() ;
	private static DruidDataSource ds = null ;
	//只放进行事务的Connection
	private static ThreadLocal<Connection> conn = new ThreadLocal<Connection>() ;
	static {
		//初始化连接池
		try {
			
			ResourceBundle res=ResourceBundle.getBundle("jdbc");
			
			ds=new DruidDataSource();
			ds.setUrl(res.getString("url"));
			ds.setDriverClassName(res.getString("driverClassName"));
			ds.setUsername(res.getString("username"));
			ds.setPassword(res.getString("password"));
			ds.setFilters(res.getString("filters"));
			ds.setMaxActive(Integer.parseInt(res.getString("maxActive")));
			ds.setInitialSize(Integer.parseInt(res.getString("initialSize")));
			ds.setMaxWait(Long.parseLong(res.getString("maxWait")));
			ds.setMinIdle(Integer.parseInt(res.getString("minIdle")));
			ds.setValidationQuery("SELECT 'x'");
			ds.setTestWhileIdle(true);
			ds.setTestOnBorrow(false);
			ds.setTestOnReturn(false);
			ds.setTimeBetweenEvictionRunsMillis(600000);
			
			
		}catch(Exception e) {
			log.error("com.redcms.db.Db.ERROR_003_初始化连接池失败");
		}
	}
	/**
	 * 通过DataSource得到Connection
	 * @return
	 * @throws SQLException
	 * 
	 */
	public static Connection getConnection () throws SQLException {
		//得到ThreadLocal中的connection
		Connection con = conn.get() ;
		//如果开启了事务，则con不为空，应该直接返回con
		/*if(null!=con) {
			return con ;
		}*/
		if(null==con||con.isClosed())
		{
			con = ds.getConnection();
			conn.set(con);
		}
		return con ;
	}
	
	/**
	 * 开启事务
	 * @throws SQLException
	 * 
	 */
	public static void beginTransaction() throws SQLException{
		//得到ThreadLocal中的connection
		/*Connection con = conn.get() ;
		//判断con是否为空，如果不为空，则说明事务已经开启
		if(null!=con) {
			throw new SQLException("事务已经开启了，不能重复开启事务");
			
		}*/
		//如果为空，则开启事务
		Connection con = getConnection() ;
		//设置事物提交为手动
		con.setAutoCommit(false);
		//把当前开启的事物放入ThreadLocal中
		conn.set(con);
	}
	/**
	 * 提交事物
	 * @throws SQLException
	 * 
	 */
	public static void commitTransaction() throws SQLException{
		//得到ThreadLocal中的connection
		Connection con = conn.get() ;
		//判断con是否为空，如果为空，则说明事务没有开启
		if(null==con) {
			throw new SQLException("没有开启事务，不能提交事务");
		}
		//如果con不为空，提交事务
		con.commit();
		//提交事务后，关闭连接
		con.close();
		//将链接移除ThreadLocal
		conn.remove();
	}
	/**
	 * 回滚事务
	 * @throws SQLException
	 * 
	 */
	public static void rollbackTransaction() {
		try {
			
			//得到ThreadLocal中的connection
			Connection con = conn.get() ;
			//判断con是否为空，如果为空，则说明没有开启事务，也就不能提交事务
			if(null==con) {
				throw new SQLException("没有开启事务，不能回滚事务");
			}
			//回滚事务
			con.rollback();
			//事务回滚后，关闭连接
			con.close();
			//将连接移除ThreadLocal
			conn.remove();
			
		}catch(Exception e) {
			
		}
	}
	
	/**
	 * 关闭事务
	 * @param connection
	 * @throws SQLException
	 * 
	 */
	public static void releaseConnection(Connection connection)throws SQLException{
		//得到ThreadLocal中的connection
		Connection con = conn.get() ;
		//如果参数连接与当前的事务不相等，则说明参数连接不是事务连接，可以关闭，否则交由事务关闭
		if(connection != null && con != connection) {
			//如果连接没有关闭，关闭
			if(!connection.isClosed()) {
				connection.close();
			}
			
		}
	}
	public static void closeDataSource() {
		if(null!=ds)
			ds.close();
	}
	//----------------------------重写QueryRunner中的方法  ----------------------------------------------------------
	public static int[] batch(String sql,Object[][] params) throws SQLException{
		Connection conn = getConnection() ;
		int[] result = run.batch(conn,sql, params);
		releaseConnection(conn);
		return result ;
	}
	public static <T> T query(String sql , ResultSetHandler<T> rsh, Object... params) throws SQLException{
		Connection conn = getConnection() ;
		T result = run.query(conn, sql,rsh,params);
		releaseConnection(conn);
		return result ;
	}
	public static <T> T query(String sql, ResultSetHandler<T> rsh)  
            throws SQLException {  
        Connection conn = getConnection();  
        T result =  run.query(conn, sql, rsh);  
        releaseConnection(conn);  
        return result;  
    }  
	
	public static int update(String sql , Object... params)throws Exception{
		Connection conn = getConnection();
		int result = run.update(conn,sql, params);
		releaseConnection(conn);
		return result ;
	}
	public static int update(String sql , Object param)throws Exception{
		Connection conn = getConnection() ;
		int result = run.update(conn, sql, param);
		releaseConnection(conn);
		return result ;
		
	}
	
	public static int update(String sql)throws Exception{
		Connection conn = getConnection();
		int result = run.update(conn,sql);
		releaseConnection(conn);
		return result ;
	}
	

}
