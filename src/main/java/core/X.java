package core;
import java.util.*;
import java.util.regex.*;

import sun.applet.Main;

public class X {
	private static Pattern 	VALID_IPV4_PATTERN 		=null;
	private static final String ipv4Pattern			=""
													+"((25[0-5]|"
													+"2[0-4][0-9]|"
													+"[01]?[0-9][0-9]?)\\.){3}(25[0-5]|"
													+"2[0-4][0-9]|"
													+"[01]?[0-9][0-9]?)";

	private static Pattern 	VALID_IPV6_PATTERN 		=null;
	private static final String ipv6Pattern			=""
													+"([0-9a-f]{1,4}:){7}"
													+"([0-9a-f]){1,4}";
	
	public static boolean isIpAddress(String ipAddress){
		VALID_IPV4_PATTERN=Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
		VALID_IPV6_PATTERN=Pattern.compile(ipv6Pattern, Pattern.CASE_INSENSITIVE);
		
		Matcher m4=X.VALID_IPV4_PATTERN.matcher(ipAddress);
		Matcher m6=X.VALID_IPV6_PATTERN.matcher(ipAddress);
		if(m4.matches()) {return true;}
		if(m6.matches()) {return true;}
		else {return false;}}
		
	public static void main(String[] args){
		List<String> list=new ArrayList<String>();
		//Valid
		list.add("2001:0db8:0000:0000:0000:ff00:0042:8329");
		list.add("127.0.0.1");                        
		list.add("192.168.1.255");                    
		list.add("255.255.255.255");                  
		list.add("0.0.0.0");                          
		list.add("1.1.1.01");  
		// Invalid
		list.add("2001:0DB8:0000:CD30:0000:0000:0000");
		list.add("100.100.100");                     
		list.add("1.1.1.256");                      
		list.add("30.168.1.255.1");                   
		list.add("127.1");                            
		list.add("192.168.1.256");                    
		list.add("1.2.3.4"); 
		for(String ip_address:list){
			System.out.println(isIpAddress(ip_address)+" \t<= "+ip_address);}
	
	}

}
