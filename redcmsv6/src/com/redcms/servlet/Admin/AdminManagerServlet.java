package com.redcms.servlet.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.redcms.servelt.core.Action;

@WebServlet("/admin/index")
public class AdminManagerServlet extends Action{

	@Override
	public void index(){
		// TODO Auto-generated method stub
		try {
			forword("admin/index.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
