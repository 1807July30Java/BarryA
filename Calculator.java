package com.revature.operation;

public class Calculator {
	public String add (String a, String b, String dataType)  {
		String result = null;
		
		if (dataType.equalsIgnoreCase("double")) {            //Double
			double three = 0;
			String ans = "Please enter a valid number";
				
				try {
					double one = Double.parseDouble(a);
					double two = Double.parseDouble(b);
					three = one + two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 		
			
				result = Double.toString(three);
				
		}else if (dataType.equalsIgnoreCase("int")) {       //Int
			int three = 0;
			String ans = "Please enter a valid number";
			
				
				try {
					int one = Integer.parseInt(a);
					int two = Integer.parseInt(b);
					three = one + two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 
			
				result = Integer.toString(three);
		}else if (dataType.equalsIgnoreCase("long")) {
			long three = 0;
			String ans = "Please enter a valid number";
			
				
				try {
					long one = Long.parseLong(a);
					long two = Long.parseLong(b);
					three = one + two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 
			
				result = Long.toString(three);
		}else if (dataType.equalsIgnoreCase("short")) {
			short three = 0;
			String ans = "Please enter a valid number";	
				try {
					short one = Short.parseShort(a);
					short two = Short.parseShort(b);
					three = (short) (one + two);
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Short.toString(three);	
		}else if (dataType.equalsIgnoreCase("byte")) {
			byte three = 0;
			String ans = "Please enter a valid number";	
				try {
					byte one = Byte.parseByte(a);
					byte two = Byte.parseByte(b);
					three = (byte) (one + two);
					
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Short.toString(three);	
			
		}else if (dataType.equalsIgnoreCase("float")) {
			
			float three = 0;
			String ans = "Please enter a valid number";	
				try {
					float one = Float.parseFloat(a);
					float two = Float.parseFloat(b);
					three = (one + two);
					
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Float.toString(three);	
			
		}
			
		
		return result;
	
			
		
		
	}
	
	//Multiply 
	
	public String multiply (String a, String b, String dataType)  {
		String result = null;
		
		if (dataType.equalsIgnoreCase("double")) {            //Double
			double three = 0;
			String ans = "Please enter a valid number";
				
				try {
					double one = Double.parseDouble(a);
					double two = Double.parseDouble(b);
					three = one * two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 		
			
				result = Double.toString(three);
				
		}else if (dataType.equalsIgnoreCase("int")) {       //Int
			int three = 0;
			String ans = "Please enter a valid number";
			
				
				try {
					int one = Integer.parseInt(a);
					int two = Integer.parseInt(b);
					three = one * two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 
			
				result = Integer.toString(three);
		}else if (dataType.equalsIgnoreCase("long")) {
			long three = 0;
			String ans = "Please enter a valid number";
			
				
				try {
					long one = Long.parseLong(a);
					long two = Long.parseLong(b);
					three = one * two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 
			
				result = Long.toString(three);
		}else if (dataType.equalsIgnoreCase("short")) {
			short three = 0;
			String ans = "Please enter a valid number";	
				try {
					short one = Short.parseShort(a);
					short two = Short.parseShort(b);
					three = (short) (one * two);
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Short.toString(three);	
		}else if (dataType.equalsIgnoreCase("byte")) {
			byte three = 0;
			String ans = "Please enter a valid number";	
				try {
					byte one = Byte.parseByte(a);
					byte two = Byte.parseByte(b);
					three = (byte) (one * two);
					
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Short.toString(three);	
			
		}else if (dataType.equalsIgnoreCase("float")) {
			
			float three = 0;
			String ans = "Please enter a valid number";	
				try {
					float one = Float.parseFloat(a);
					float two = Float.parseFloat(b);
					three = (one * two);
					
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Float.toString(three);	
			
		}
			
		
		return result;
	
			
		
		
	}
	
// Substract
	
	public String substract (String a, String b, String dataType)  {
		String result = null;
		
		if (dataType.equalsIgnoreCase("double")) {            //Double
			double three = 0;
			String ans = "Please enter a valid number";
				
				try {
					double one = Double.parseDouble(a);
					double two = Double.parseDouble(b);
					three = one - two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 		
			
				result = Double.toString(three);
				
		}else if (dataType.equalsIgnoreCase("int")) {       //Int
			int three = 0;
			String ans = "Please enter a valid number";
			
				
				try {
					int one = Integer.parseInt(a);
					int two = Integer.parseInt(b);
					three = one - two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 
			
				result = Integer.toString(three);
		}else if (dataType.equalsIgnoreCase("long")) {
			long three = 0;
			String ans = "Please enter a valid number";
			
				
				try {
					long one = Long.parseLong(a);
					long two = Long.parseLong(b);
					three = one - two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 
			
				result = Long.toString(three);
		}else if (dataType.equalsIgnoreCase("short")) {
			short three = 0;
			String ans = "Please enter a valid number";	
				try {
					short one = Short.parseShort(a);
					short two = Short.parseShort(b);
					three = (short) (one - two);
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Short.toString(three);	
		}else if (dataType.equalsIgnoreCase("byte")) {
			byte three = 0;
			String ans = "Please enter a valid number";	
				try {
					byte one = Byte.parseByte(a);
					byte two = Byte.parseByte(b);
					three = (byte) (one - two);
					
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Short.toString(three);	
			
		}else if (dataType.equalsIgnoreCase("float")) {
			
			float three = 0;
			String ans = "Please enter a valid number";	
				try {
					float one = Float.parseFloat(a);
					float two = Float.parseFloat(b);
					three = (one - two);
					
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Float.toString(three);	
			
		}
			
		
		return result;
			
	}
	
	// Divide
	
	public String divide (String a, String b, String dataType)  {
		String result = null;
		
		if (dataType.equalsIgnoreCase("double")) {            //Double
			double three = 0;
			String ans = "Please enter a valid number";
				
				try {
					double one = Double.parseDouble(a);
					double two = Double.parseDouble(b);
					three = one / two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 		
			
				result = Double.toString(three);
				
		}else if (dataType.equalsIgnoreCase("int")) {       //Int
			int three = 0;
			String ans = "Please enter a valid number";
			
				
				try {
					int one = Integer.parseInt(a);
					int two = Integer.parseInt(b);
					three = one / two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 
			
				result = Integer.toString(three);
		}else if (dataType.equalsIgnoreCase("long")) {
			long three = 0;
			String ans = "Please enter a valid number";
			
				
				try {
					long one = Long.parseLong(a);
					long two = Long.parseLong(b);
					three = one / two;
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					
					System.out.println(ans+ " your operation can not be completed");
					
				} 
			
				result = Long.toString(three);
		}else if (dataType.equalsIgnoreCase("short")) {
			short three = 0;
			String ans = "Please enter a valid number";	
				try {
					short one = Short.parseShort(a);
					short two = Short.parseShort(b);
					three = (short) (one / two);
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Short.toString(three);	
		}else if (dataType.equalsIgnoreCase("byte")) {
			byte three = 0;
			String ans = "Please enter a valid number";	
				try {
					byte one = Byte.parseByte(a);
					byte two = Byte.parseByte(b);
					three = (byte) (one / two);
					
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Short.toString(three);	
			
		}else if (dataType.equalsIgnoreCase("float")) {
			
			float three = 0;
			String ans = "Please enter a valid number";	
				try {
					float one = Float.parseFloat(a);
					float two = Float.parseFloat(b);
					three = (one / two);
					
				} catch (NumberFormatException e) {
					System.out.println(ans+ " your operation can not be completed");
				} 	
				result = Float.toString(three);	
			
		}
			
		
		return result;
	
			
		
		
	}
	
	
	
	

}
