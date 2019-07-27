package com.redcms.db;

import java.util.ResourceBundle;
import java.sql.Connection ;
import org.apache.log4j.Logger;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;


public class ConnectionManager {
	private static DruidDataSource ds = null ;
	public static Logger log=Logger.getLogger(ConnectionManager.class);
	private static ThreadLocal<Connection> conpool = new ThreadLocal<Connection>();
	private static ConnectionManager cm = null ;
	/**
	 * 得到ConnectionManager
	 * @return
	 */
	public static ConnectionManager newInstance() {
		if(null == cm ) {
			ConnectionManager cm = new ConnectionManager() ;
			cm.init();
		}
		return cm ;
	}
	/**
	 * 初始化连接池
	 */
	public static void init() {
		try {
			
			ResourceBundle res = ResourceBundle.getBundle("jdbc");
			
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
		}catch(Exception e) {
			log.error("com.redcms.db.ConnectionManager_ERROR_001_初始化连接池失败");
		}
	}
	/**
	 * 得到连接对象
	 */
	public static Connection getConnection() {
		
		Connection con = conpool.get();
		
		try {
			
			if(null==con || con.isClosed()) {
				con=ds.getConnection() ;
				conpool.set(con);
			}
		}catch(Exception e) {
			log.error("com.redcms.ds.ConnectionManager_ERROR_002_初始化连接池失败");
			
		}
		return con ;
	}
	public static void  closeDataSource() {
		if(null!=ds)
			ds.close();
	}
	

}
