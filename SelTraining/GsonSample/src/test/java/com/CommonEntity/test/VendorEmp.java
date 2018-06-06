package com.CommonEntity.test;

import com.CommonEntity.template.CreateEmp;
import com.CommonEntity.template.VendorType;
import com.google.gson.Gson;

public class VendorEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("My first Json using Gson");

		//Nested VendorType
		VendorType vendorType = new VendorType();
		vendorType.setId("6731582e-ffb4-453c-8ede-0260a51b4848");
		vendorType.setType("Broker");

		CreateEmp vendorEmp = new CreateEmp();
		vendorEmp.setFirstName("Kalpana");
		vendorEmp.setLastName("Dontha");
		vendorEmp.setComplianceStatus("Inactive");
		vendorEmp.setRole("Admin");
		vendorEmp.setEmployeeStatus("Invited");
		vendorEmp.setEmail("VosTesting2018+8080@gmail.com");
		vendorEmp.setVendorType(vendorType);

		//Nested VendorType
		/*VendorType vendorType = new VendorType();
		vendorType.setId("6731582e-ffb4-453c-8ede-0260a51b4848");
		vendorType.setType("Broker");*/
		String VendorEmp = new Gson().toJson(vendorEmp);
		//String VendorType = new Gson().toJson(vendorType);
		System.out.println(VendorEmp);
		
	}

}
