package com.sample.controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ForkJoinPool;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import javax.servlet.RequestDispatcher;

import java.sql.Statement;
import java.util.ArrayList;


//import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.async.DeferredResult;



import com.sample.model.Customer;
import com.sample.model.Logon;
import com.sample.model.Movie;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@Scope("prototype")
@RequestMapping("/rmsampledemo")

public class LogonController {
private static final Logger LOGGER = LoggerFactory.getLogger(LogonController.class);
	
	@Autowired
	private Customer mycust;
	//@RequestMapping(value = "/vardhan", method = RequestMethod.GET)
	@GetMapping("/vardhan")
	public String landing(Locale locale, Model model) throws SQLException {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		
		
		  System.out.println(1);
		  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  }
		  catch (ClassNotFoundException e) { // TODO Auto-generated catch block
		  e.printStackTrace();
		  } 
		  System.out.println(2);
		  
		  
		  String jdbcUrl ="jdbc:mysql://localhost:3306/sampleschemas"; 
		  Connection con =DriverManager.getConnection(jdbcUrl, "root", "root"); 
		  //String pathInfo =rs.getPathInfo();
		  String QUERY = "SELECT * FROM movie";
		  
		  
		  Statement stmt = con.createStatement(); 
		  ResultSet rs =stmt.executeQuery(QUERY);
		  ArrayList listmovies = new ArrayList(); 
		  //ArrayList<Movie> listmovies1 = new ArrayList<>();
		 
		 System.out.println(3);
		  
		 while (rs.next()) { // Create Movie objects and populate the list
		 
		 String movie_name= rs.getString("movie_name");
		 String date_time =rs.getString("date_time");
		 String desc = rs.getString("desc"); 
		 String movie_id = rs.getString("movie_id"); 
		 String movie_price =
		 rs.getString("movie_price");
		 
		  
		  
		  Movie movie = new Movie(); movie.setMovie_name(movie_name);
		  movie.setDate_time(date_time); movie.setDesc(desc);
		  movie.setMovie_id(movie_id); movie.setMovie_price(movie_price);
		 
		  listmovies.add(movie); } System.out.println(4);
		  model.addAttribute("listmovies", listmovies); System.out.println(5);
		 
		  return "listmovies";
		
	}
	
		
		

	@RequestMapping(value = "/satish", method = RequestMethod.POST)
	public String dashboard(@Validated Customer customer, Model model) {
		System.out.println("User Page Requested");
		System.out.println(customer.getUserName());
		model.addAttribute("userName", customer.getUserName());
		mycust.setUserName(customer.getUserName());
		System.out.println(mycust.getAccount().getOutstandingBalance());
		model.addAttribute("cust", mycust);
		return "user";
		
	}
	

	@RequestMapping(value = "/postdemo", method = RequestMethod.POST)
	public String postDemo(@RequestBody Logon customer) {
		System.out.println("User Page Requested");
		System.out.println(customer.getUsername());
		System.out.println(customer.getPassword());
		return "user";
	}	
	
	@RequestMapping("/{id}")
	public String pathVarDemo(@PathVariable("id") long id) {
		System.out.println("id is " + id);
		return "user";
	}
	
	@RequestMapping("/{id}/from/{fromid}")
	public String pathVarDemo(@PathVariable("id") long id, @PathVariable String fromid) {
		System.out.println("id is " + id);
		System.out.println("fromid is " + fromid);
		
		return "user";
	}

	@RequestMapping(value = "/rpd", method = RequestMethod.GET)
	public String requestParamDemo(@RequestParam("id") long id) {
		System.out.println("User Page Requested");
		System.out.println("rpd method id is " + id);
		return "user";
	}
	
	@RequestMapping("/sessionput")
	@ResponseBody
	public String testMestod(HttpServletRequest request){
	   request.getSession().setAttribute("lastlogin",new Date().toGMTString());
	   return "Welcome to Online policy renewal";
	}
	

	@RequestMapping("/sessionget")
	@ResponseBody
	public String testMestod2(HttpServletRequest request){
	   String message = (String)request.getSession().getAttribute("lastlogin");
	   //request.getSession().invalidate();
	   return "Welcome to Online policy renewal. Your last login is at" + message;
	}
	
	
	@ResponseBody
	@RequestMapping("/strdemo")
	String simpleString() {
	    return "WELCOME to SPRING";
	}

	@ResponseBody
	@RequestMapping("/rsdemo")
	@ResponseStatus(HttpStatus.CREATED)
	String simpleResponseStatus() {
	    return "WELCOME to SPRING";
	}
	
	@GetMapping("/blockrequest")
	 public ResponseEntity < ? > getSimpeResponse() throws InterruptedException {

		 System.out.println(Thread.currentThread().getName());
	  Thread.sleep(3000);
	  return ResponseEntity.ok("OK");
	 }
	
	 @GetMapping("/asynchronous-request")
	 public DeferredResult < ResponseEntity < ? >> asynchronousRequestProcessing(final Model model) {

	  final DeferredResult < ResponseEntity < ? >> deferredResult = new DeferredResult < > ();
	  System.out.println(Thread.currentThread().getName());
	  LOGGER.info("async started");
	  /**
	   * Section to simulate slow running thread blocking process
	   */
	  ForkJoinPool forkJoinPool = new ForkJoinPool();
	  forkJoinPool.submit(() -> {
		  LOGGER.info("async in new thread started");
		  System.out.println(Thread.currentThread().getName());
	   try {
	    Thread.sleep(4000);

	   } catch (InterruptedException e) {
	   }
	   
	   
	   deferredResult.onCompletion(() -> System.out.println("Processing complete"));
	   deferredResult.setResult(ResponseEntity.ok("OK"));
	  });
	  System.out.println(6);
	  
	 

	  return deferredResult;
	 }
	 


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
