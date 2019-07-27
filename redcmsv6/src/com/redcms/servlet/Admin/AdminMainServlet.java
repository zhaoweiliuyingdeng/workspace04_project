package com.redcms.servlet.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.redcms.servelt.core.Action;
@WebServlet("/admin/index")
public class AdminMainServlet extends Action {

	@Override
	public void index(){
		try {
			forword("admin/index.jsp");
		}catch(Exception e) {
			
		}
		
	}

}
