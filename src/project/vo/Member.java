package project.vo;

public class Member {
	private String id;
	private String passwd;
	private String name;
	private int age;
	private int count=0;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCount() {
		++count;
		return count;
		
	}
	public void setCount(int count) {
		this.count = count;
	}

}
