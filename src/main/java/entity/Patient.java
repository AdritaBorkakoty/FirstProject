package entity;

public class Patient {


	private int p_Id;
	private String name;
	private String email;
	private String phone;
	private String date;
	public Patient(int p_Id, String name, String email, String phone, String date) {
		super();
		this.p_Id = p_Id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.date = date;
	}
	public int getP_Id() {
		return p_Id;
	}
	public void setP_Id(int p_Id) {
		this.p_Id = p_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDOB() {
		return date;
	}
	public void setDOB(String date) {
		this.date = date;
	}
	

}
