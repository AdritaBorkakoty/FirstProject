package DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import entity.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class DatabaseConn {
	
	Connection con;
	public DatabaseConn() throws SQLException
	{
		connection ob =  new connection();;
	
		con=ob.getconnection();
	}
	
	public int addD(String key, String test, String check) throws SQLException{
		PreparedStatement ps;
		System.out.println("email :"+key+"testName:"+test+"selected:"+check);
		if(check.equalsIgnoreCase(check)) {
			//System.out.println("lolwa");
			ps=con.prepareStatement("select p_id from patient where email=?");
			ps.setString(1,key);
			//System.out.println("lolwahaibhsi");
			//System.out.println(key);
		}
		else {
			ps=con.prepareStatement("select P_ID from PATIENT where PHONE=?");
			ps.setString(1, key);
		}
		
		ResultSet rs = ps.executeQuery();
		
		int p_id=-1;
		if(rs.next())
		{
			p_id=rs.getInt(1);
		}
		//System.out.println("pid :"+p_id);
		PreparedStatement pss = con.prepareStatement("select T_ID from TEST where NAME= ?");
		pss.setString(1,test); 
		ResultSet rss = pss.executeQuery();
		int t_id = -1;
		if(rss.next())
		{
			t_id=rss.getInt(1);
		}
		//System.out.println("pid: "+p_id+"tid: "+t_id);
		int state= -1;
		if(p_id>0 && t_id>0) {
			
			Date date = new Date();
			SimpleDateFormat simpledate = new SimpleDateFormat("dd/MM/yyyy");
			String presentDate = simpledate.format(date);
			System.out.println("presentdate"+presentDate);
			PreparedStatement p = con.prepareStatement("insert into patient_test values(?,?,?)");
			p.setInt(1, p_id);
			p.setInt(2, t_id);
			p.setString(3, presentDate);
			
			state = p.executeUpdate();
			
			return state;
		}
		
		return state;
	}
	public String viewReport(String key, String testDate, String check) throws SQLException
	{
		int state = -1;
		PreparedStatement ps;
		if(check.equalsIgnoreCase("email"))
		{
			ps=con.prepareStatement("select p.name , p.email, p.phone , pt.date , t.name ,t.cost from patient p inner join patient_test pt inner join test t on p.p_id=pt.p_id and t.t_id=pt.t_id and p.email=? and pt.date=? order by t.name");
			ps.setString(1, key);
			ps.setString(2, testDate.trim());
		}
		else
		{
			ps=con.prepareStatement("select p.name , p.email, p.phone , pt.date , t.name,t.cost from patient p inner join patient_test pt inner join test t on p.p_id=pt.p_id and t.t_id=pt.t_id and p.phone=? and pt.date=? order by t.name");
			ps.setString(1, key);
			ps.setString(2, testDate.trim());
		}
		ResultSet rs = ps.executeQuery();
		String email="", da="";
		
		
		String s ="<table><th>Test Name</th><th>Test Cost</th>";
		
		String info="";
		int tCost=0;
		while(rs.next())
		{
			tCost += rs.getInt(6);
			info="Name : "+ rs.getString(1)+ "<br> Email: "+ rs.getString(2) +  "<br> Test Date :" + testDate + "<br> Total cost" + tCost;
			email = rs.getString(2);
			da = rs.getString(4);
			Test obj = new Test();
			obj.setTestName(rs.getString(5));
			obj.setCost(6);
			
			s=s+"<tr><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td></tr>";	
		}
		
		s= s +"</table>";
		s= info+s;
		
		return s;
	}

}
