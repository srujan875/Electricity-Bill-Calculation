package com.wipro.eb.main;

import com.wipro.eb.service.ConnectionService;

public class EBMain {

	public static void main(String a[])
	{
	System.out.println(new ConnectionService().generateBill(130,100,"Domestic"));
	System.out.println(new ConnectionService().generateBill(180,100,"Domestic"));
	System.out.println(new ConnectionService().generateBill(250,100,"Domestic"));
	System.out.println(new ConnectionService().generateBill(130,100,"Commercial"));
	System.out.println(new ConnectionService().generateBill(180,100,"Commercial"));
	System.out.println(new ConnectionService().generateBill(250,100,"Commercial"));
	}

}
