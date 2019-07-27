package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.Students;

public interface StudentMapper {
	//查询所有学生
	public List<Students> findAllStudents();
	//根据ID找学生
	public Students findStudentById(Integer id);
	//增加一个学生
	public void insertStudent(Students student);

}
