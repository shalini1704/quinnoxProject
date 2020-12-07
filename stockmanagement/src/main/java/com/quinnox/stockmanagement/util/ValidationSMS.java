package com.quinnox.stockmanagement.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ValidationSMS {
	
	private static Pattern EMAIL_PATTERN = 
			Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	public static boolean userEmailValidation(String email) {
		Matcher mtch = EMAIL_PATTERN.matcher(email);
        if(mtch.matches()){
            return true;
        }
        return false;
	}
	public boolean valueValidation(String value) {
		boolean found;
		String regex = "^[0-9]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher  matcher = pattern.matcher(value);
		if( !matcher.matches()) {
			found=false;
		}else {
			found=true;	
		}
     return found;
	}	
	private static Pattern pswNamePtrn = 
	        Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
	     
	    public static boolean passwordValidation(String password){
	        Matcher mtch = pswNamePtrn.matcher(password);
	        if(mtch.matches()){
	            return true;
	        }
	        return false;
	    }
	    
	public boolean nameValidation(String name) {
		boolean found;
		String regex = "^[a-zA-Z][a-zA-Z\\\\s]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher  matcher = pattern.matcher(name);
		if( !matcher.matches()) {
			found=false;
		}else {
			found=true;	
		}
     return found;
	}
	public boolean companyIdValidation(String id) {
		boolean found;
		String regex = "^[A-Za-z]+(?:[ _-][0-9]+)*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher  matcher = pattern.matcher(id);
		if( !matcher.matches()) {
			found=false;
		}else {
			found=true;	
		}
     return found;
	}
	public boolean phoneValidation(String phone) {
		boolean found;
	String regex1 = "[6789]{1}[0-9]{9}";
	Pattern pattern1 = Pattern.compile(regex1);
	Matcher matcher1 = pattern1.matcher(phone);
	if(! matcher1.matches()) {

		found=false;
	}else {
		
		found=true;
	}
	return found;
	}
	
	public boolean roleValidation(String role) {
		boolean found;
		String regex = "^((admin)|(ADMIN)|(MANAGER)|(manager)|(investor)|(Investor)|(INVESTOR)|(Manager)|(Admin))$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher  matcher = pattern.matcher(role);
		if( !matcher.matches()) {
		
			found=false;

		}else {
			
			found=true;
			
		}
     return found;
	}	
	
}
