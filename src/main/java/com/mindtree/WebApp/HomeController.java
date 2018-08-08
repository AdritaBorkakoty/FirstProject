package com.mindtree.WebApp;

import java.sql.SQLException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import DAO.DatabaseConn;

@EnableAutoConfiguration
@Controller
public class HomeController {

	public HomeController() {

	}
	
	@RequestMapping(path = "/home", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String serveHome() {

		String result = "";

		result = "diagnostic";

		return result;
	}
	
	@ResponseBody 
	@RequestMapping(value="/getResponse")
	public String getResponse(String key, String test, String check) 
	{
		int state =-1;
		try {
			DatabaseConn db = new DatabaseConn();
			//System.out.println(key+test+check);
			state = db.addD(key, test, check);			
		}
		
		catch(SQLException e)
		{
			System.out.println("SQL Exception has occured.");
		}
		
		return String.valueOf(state);
	}
	
	@ResponseBody 
@RequestMapping(value ="/getResponseofReport")
public String reportGen(String key, String test, String check)
{
		System.out.println("key"+key+" test"+test+" check :"+check);
	String state =" ";
	try {
		DatabaseConn db = new DatabaseConn();
		
		state = db.viewReport(key, test, check);
	}
	
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	return state;
}
		
}
