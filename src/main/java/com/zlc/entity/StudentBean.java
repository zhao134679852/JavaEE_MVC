package com.zlc.entity;

//实体类Student的bean
public class StudentBean {

	//变量*******************
	private int ID;
	private String name;
	private String sex;
	private int age;
	private String birthday;
	private String school;
	private String classes;
	
	//函数*******************
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	/**
	 * 
	 * @Title:        StudentBean
	 * @Description:    构造函数
	 * @param:    @param ID 学号 
	 * @param:    @param name 姓名
	 * @param:    @param sex 性别
	 * @param:    @param age 年龄
	 * @param:    @param birthday 生日
	 * @param:    @param school 学校
	 * @param:    @param classes 班级
	 * @throws
	 */
	public StudentBean(int ID, String name, String sex, int age, String birthday, String school, String classes) {
		super();
		this.ID = ID;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.school = school;
		this.classes = classes;
	}
	public StudentBean() {
		
	}
	
	public String toString() {
		return this.getID()+"-"+this.getName()+"-"+this.getSex()+"-"+this.getAge()+"-"+this.getBirthday()+"-"+this.getSchool()+"-"+this.getClasses();
	}
	
}
