package entity;

public class Test {

	private int t_id;
	private String name;
	
	public Test(int t_id, String name, int cost) {
		super();
		this.t_id = t_id;
		this.name = name;
		this.cost = cost;
	}
	public Test() {
		// TODO Auto-generated constructor stub
	}
	public int getTid() {
		return t_id;
	}
	public void setTid(int t_id) {
		this.t_id = t_id;
	}
	public String getTestName() {
		return name;
	}
	public void setTestName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	private int cost;
	
	
}
