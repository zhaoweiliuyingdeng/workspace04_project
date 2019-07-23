package com.zw.Prototype;

public class PrototypeCitation {
	public static void main(String[] args) throws CloneNotSupportedException{
		citation obj1 = new citation("张三","同学：在2016年第一学期中，表现优秀，被评为三好学生。","韶关学院");
		obj1.display();
		citation obj2 = (citation)obj1.clone() ;
		obj2.setName("李四");
		obj2.display();
		
	}

}
class citation implements Cloneable{
	private String name ;
	private String info ;
	private String college ;
	public citation(String name , String info , String college ) {
		this.name = name ;
		this.info = info ;
		this.college = college ;
		System.out.println("创建奖状成功！");
		
	}
	public void setName(String name) {
		this.name = name ;
	}
	public String getName() {
		return name ;
	}
	public void display() {
		System.out.println(name+info+college);
	}
	public Object clone() throws CloneNotSupportedException{
		System.out.println("拷贝奖状成功!");
		return (citation)super.clone() ;
	}
}
