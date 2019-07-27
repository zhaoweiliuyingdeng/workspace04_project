package com.mybatis.Main;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.pojo.PhoneNumber;
import com.mybatis.pojo.Students;

public class Main
{
	public static void main(String[] args)
	{
		InputStream inputStream = Main.class.getResourceAsStream("/mybatis-config.xml");
		//相当于根据mybatis-config.xml构建连接池
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		
		//SqlSession相当于我们的Connection
		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			StudentMapper sm = session.getMapper(StudentMapper.class);
			
			//增加
			/*Students student = new Students() ;
			student.setDob(new Date());
			student.setEmail("Hello@163.com");
			student.setName("李四");
			student.setPhone(new PhoneNumber("187", "2932", "0295"));
			sm.insertStudent(student);
			session.commit();*/
			
			//查询
			
			List<Students> stus = sm.findAllStudents();
			for(Students s : stus)
			{
				
				System.out.println(s.getEmail()+"\t"+s.getName()+"\t"+s.getDob()+"\t"+s.getPhone());
			}
		} finally {
			session.close();
		}
	}

}
