package com.redcms.servlet.Admin;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.redcms.Admin;
import com.redcms.servelt.core.Action;
@WebServlet("/admin/login")
public class AdminServlet extends Action {

	@Override
	public void index(){
		try {
			this.forword("admin/login.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void logout () throws ServletException, IOException{
		req.getSession().removeAttribute("loged");
		req.getSession().invalidate();
		
		redirect("login");
	}
	public void checkLogin() throws SQLException,IOException{
		Admin admin=new Admin() ;
		this.getBean(admin);
		
	}

}
