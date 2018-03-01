package com.heven.testSource;

public class 深浅克隆 {

	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A("字符串",10,new Wing(10));
		A a1 = (A)a.clone();
		System.out.println(a==a1);
		System.out.println("a:"+a.getNum()+",a1:"+a1.getNum());
		System.out.println(a1.getLeftWing());
		a1.setLeftWing(new Wing(100));
		System.out.println("a:"+a.getNum()+",a1:"+a1.getNum());
		System.out.println(a.getNum()==a1.getNum());
		System.out.println("(a.leftWing==a1.leftWing) = "+(a.getLeftWing()==a1.getLeftWing()));
		System.out.println(a1.getLeftWing());
	}
}

class A implements Cloneable{
	private String a ;
	private int num ;
	private Wing leftWing;
	 public Wing getLeftWing() {  
	        return leftWing;  
	    }  
	  
	    public void setLeftWing(Wing leftWing) {  
	        this.leftWing = leftWing;  
	    }  
	public A(String a,int num,Wing leftWing){
		this.a = a;
		this.num = num;
		this.leftWing = leftWing;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}

class Wing{  
	  
    private int width;  
  
    public Wing(int width){  
        this.width = width;  
    }  
      
    public int getWidth() {  
        return width;  
    }  
  
    public void setWidth(int width) {  
        this.width = width;  
    }  
}  

