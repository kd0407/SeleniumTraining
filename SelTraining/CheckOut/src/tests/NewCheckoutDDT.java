package tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class NewCheckoutDDT {
	String email;
	String name;
	String address;
	/*String paymentType;
	String cardNo;
	String verificationCode;*/
	
	@Test
	public void newCheckoutTea() {
		System.out.println("New Record:" + email+","+name+","+address);	
	}
	
    //Parameters are going to come from this getData() method and those will be fed into the @Test using the constructor
	@Parameters
	public static List<String[]> getData(){
		//Create a new csv file for checkout page
		return utilities.CSV.get("D:\\MBNG\\automation_framework\\Checkout.csv");
			
	}
	//constructor that passes parameters to the Test
	
	public NewCheckoutDDT (String email,String name,String address) {
		this.email=email;
		this.name=name;
		this.address=address;
	}
	    
	    
}
