package com.redcms.db;

import java.sql.SQLException;

public class Test {
	public static void main(String[] args)throws SQLException{
		
		try {
		Db.beginTransaction();
		Db.update("insert into t1(f1) values(?)","fff81");
		Db.update("insert into t2(f1) values(?)","ddd81");
		Db.commitTransaction();
		}
		catch(Exception e) {
			Db.rollbackTransaction();
		}
	}

}
