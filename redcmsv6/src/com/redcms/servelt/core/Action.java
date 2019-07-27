package com.redcms.servelt.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action extends HttpServlet {
	private static final long serialVersionUID = -5111943848202016062L;

	protected HttpServletRequest req ;
	protected HttpServletResponse resp ;
	protected SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String method = null!=req.getParameter("action")?req.getParameter("action"):"index";
		Class[] param = new Class[] {HttpServletRequest.class,HttpServletResponse.class};
		
		Class clazz= this.getClass() ;
		try {
			Method m=clazz.getDeclaredMethod(method, new Class[] {});
			if(null!=m) {
				this.req=req ;
				this.resp = resp ;
				m.invoke(this, new Object[] {});
			}
		} catch (Exception e) {
			System.out.println("ERROR__001__找不到目标方法");
		} 
		
		
	}
	//默认要实现的方法
	public abstract void index();
	//取字符串
	public String getString(String param ) {
		
		return null!=req.getParameter(param)?req.getParameter(param):"";
	}
	public String[] getStringArray(String param) {
		return req.getParameterValues(param);
	}
	//返回一个数字参数
	public int getInt(String param) {
		int re = -1 ;
		String str=this.getString(param);
		if(str.matches("\\d+")) {
			re=Integer.parseInt(str);
		}
		return re ;
	}
	//填充请求参数到Bean对象
	public void getBean(Object bean) {
		Class clazz = bean.getClass() ;
		Field[] all=clazz.getDeclaredFields();
		if(null!=all&&all.length>0) {
			try {
				for(Field f : all) {
					f.setAccessible(true);
					String fname=f.getName();//字段名
					Class types = f.getType();// 属性和类型
					String paramv=this.getString(fname);
					if(types==String.class) {
						f.set(bean, paramv);
					}else if(types==Integer.class||types==Integer.TYPE) {
						f.set(bean, this.getInt(fname));
						
					}else if(types==Date.class) {
						if(paramv.matches("\\d{4}[-]\\d{2}[-]\\d{2}[]\\d{2}[:]\\d{2}[:]\\d{2}")) {
							f.set(bean, sf.parse(paramv));
							
						}
						
					}
				}
				
			}catch(Exception e) {
					System.out.println("ERROR___02 填充对象出错");
			}
		}
	}
	//设置
	public void setAttr(String key , Object value) {
		req.setAttribute(key, value);
	}
	//跳转
	public void forword(String path) throws ServletException,IOException{
		req.getRequestDispatcher("/WEB-INF/"+path).forward(req, resp);
		
	}
	//直接输出值
	public void redirect(String path)throws ServletException,IOException{
		resp.sendRedirect(path);
	}
	public void randerText(String msg)throws ServletException,IOException{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter() ;
		out.println(msg);
		out.close();
	}
	//输出json
	public void randerJson(Object obj)throws ServletException,IOException{
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter() ; 
		out.println(obj);
		out.close();
				
	}

}
