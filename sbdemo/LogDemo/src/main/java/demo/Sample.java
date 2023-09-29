package demo;

import org.apache.log4j.Logger;

public class Sample {

	 static Logger log = Logger.getLogger(Sample.class.getName());  
	public static void interestCalc() {
		int principal = 123;
		int rateOfInterest = 2;
		int years = 2;
		int interest = (principal * rateOfInterest * years)/100;
		System.out.println("interest is " + interest);
		log.debug("in ic method Hello this is a debug message");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("Hello");
		  
		  log.info("Hello this is a info message");  
		  log.warn("Hello this is a warn message");  
		  log.error("Hello this is a error message");  
		  
		  if(log.isDebugEnabled()) {
			  log.debug("Hello this is a debug message");  
		  }
		  
		  interestCalc();

	}

}
