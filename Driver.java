package com.revature.operation;

import java.awt.Container;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator obj = new Calculator();
		Boolean cont = true;
		
		do {	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the first number you wish to evaluate: ");
		String a = sc.nextLine();

		
		System.out.println("Please enter the second number: ");
		String b = sc.nextLine();
		
		System.out.println("Please enter your data Type: ");
		String dT = sc.nextLine();
		
		System.out.println("Please enter your operation: add/substract/multiply/divide: ");
		String op = sc.nextLine();
	
		
		if (op.equalsIgnoreCase("add")) {
			System.out.println(a +" + "+  b +" = "+obj.add(a, b, dT));
		} else if(op.equalsIgnoreCase("substract")){
			System.out.println("Failed");

		}
		
		
		
		
		
		
		
		
		
		System.out.println("Do you wish to perform more calculation? (Yes or No)");
		String conti = sc.nextLine();
		String contin = conti.trim();
		
		if (contin.equalsIgnoreCase("yes")) {
			cont = true;
		}else {
			cont = false;
		}
		}
		while (cont);
		
		System.out.println("Thank you for using my calculator");
		

	}

}
