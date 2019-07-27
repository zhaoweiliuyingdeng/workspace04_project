package com.mybatis.utils;
/**
 * 
 * 完成数据库类型到java类型的转化
 * rs.getString("phone")---->PhoneNumber
 * ps.setString(3,PhoneNumber.getAsString)----->
 * 
 */
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.mybatis.pojo.PhoneNumber;

public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return new PhoneNumber(rs.getString(columnName));
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return new PhoneNumber(rs.getString(columnIndex));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return new PhoneNumber(cs.getString(columnIndex));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, PhoneNumber parameter, JdbcType jdbcType)
			throws SQLException {

		ps.setString(i, parameter.getAsString());
	}

}
