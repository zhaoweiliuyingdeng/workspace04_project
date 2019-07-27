package com.redcms.web.tag;

import java.lang.reflect.Field;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.redcms.beans.Channel;
import com.redcms.beans.Data;

public class PropertyTag extends TagSupport 
{
    private String name;//字段的名字
    
	@Override
	public int doEndTag() throws JspException {
		  try {
			String result=null;
			Tag parenttag=this.getParent();
			  if(parenttag instanceof ChannelListTag)
			  {
				  ChannelListTag parent=(ChannelListTag)parenttag;
				  Channel curr=parent.getCurrent();

				  //没有找到,找扩展字段
				  result=curr.getAttrs().get(name);
				  if(null==result||"".equals(result))
				  {
				     Class clazz=curr.getClass();
				     Field field=clazz.getDeclaredField(name);
				 
					  //找到
					  field.setAccessible(true);
					  result=field.get(curr).toString();
				  }
				
				  
			  }else  if(parenttag instanceof ArticleListTag)
			  {
				  ArticleListTag parent=(ArticleListTag)parenttag;
				  Data curr=parent.getCurrent();
                 
				  //没有找到,找扩展字段
				  result=curr.getAttrs().get(name);
				  if(null==result||"".equals(result))
				  {
				     Class clazz=curr.getClass();
				     Field field=clazz.getDeclaredField(name);
				     if(null!=field)
				      {
					  //找到
					  field.setAccessible(true);
					  result=field.get(curr).toString();
				      }
				  }
			  }
			  
			  
			  
			  pageContext.getOut().print(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		return super.doEndTag();
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
  
}
