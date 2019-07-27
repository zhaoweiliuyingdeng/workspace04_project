package com.redcms.web.tag;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.redcms.beans.Data;
import com.redcms.beans.DataAttr;
import com.redcms.db.Db;

public class ArticleInfoTag extends SimpleTagSupport 
{
	
	private long dataId;//内容的id
	private String name;//访问内容的哪个字段
    
	@Override
	public void doTag() throws JspException, IOException
	{
		StringBuilder sb=new StringBuilder();
		try {
		
		PageContext pc=(PageContext)this.getJspContext();
	   //首先找内存
		Data data=(Data)pc.getAttribute("data", PageContext.REQUEST_SCOPE);
		if(null==data||data.getId()!=dataId)
		{
			//内存中有
		
			//内存中没有
			   String sql="select d.*,c.name as channel_name from alldata d inner join channel c on(d.id=? and d.channel_id=c.id)";

				 data=Db.query(sql, new BeanHandler<Data>(Data.class),dataId);
				fillAttr(data);
				// 取 data对应的字段
				
				
			    pc.setAttribute("data", PageContext.REQUEST_SCOPE);
			
		}
		
		 //没有找到,找扩展字段
		Object  result=data.getAttrs().get(name);
		  if(null==result||"".equals(result))
		  {
		     Class clazz=data.getClass();
		     Field field=clazz.getDeclaredField(name);
		      if(null!=field)
		      {
			  //找到
			  field.setAccessible(true);
			  result=field.get(data).toString();
		      }
		  }
		
		sb.append(result);
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.getJspContext().getOut().print(sb.toString());
		
	}
	

    //填充扩展字段
    public void fillAttr(Data current) 
    {
    	try {
    		//填充扩展字段
    		List<DataAttr> attrlist=Db.query("select * from data_attr where data_id=?", new BeanListHandler<DataAttr>(DataAttr.class),current.getId());
    		if(null!=attrlist&&attrlist.size()>0)
    		{
    			for(DataAttr ca:attrlist)
    			{
    				current.getAttrs().put(ca.getField_name(), ca.getField_value());
    			}
    		}
    	    attrlist=null;
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
     }


	public long getDataId() {
		return dataId;
	}


	public void setDataId(long dataId) {
		this.dataId = dataId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

    
    //---------------------------------------------------------
    
}
