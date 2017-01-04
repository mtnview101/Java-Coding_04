package core;
import java.util.*;
import java.util.regex.*;

import sun.applet.Main;

public class X_Full {
	private static Pattern 	VALID_IPV4_PATTERN 		=null;
	private static final String ipv4Pattern			=""
													+"((25[0-5]|"
													+"2[0-4][0-9]|"
													+"[01]?[0-9][0-9]?)\\.){3}(25[0-5]|"
													+"2[0-4][0-9]|"
													+"[01]?[0-9][0-9]?)";
	// IPv6 RegEx
	private static Pattern 	VALID_IPV6_PATTERN 		=null;
	private static final String ipv6Pattern	= ""
	+"(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|"         // 1:2:3:4:5:6:7:8
	+"([0-9a-fA-F]{1,4}:){1,7}:|"                         // 1::                              1:2:3:4:5:6:7::
	+"([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|"         // 1::8             1:2:3:4:5:6::8  1:2:3:4:5:6::8
	+"([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|"  // 1::7:8           1:2:3:4:5::7:8  1:2:3:4:5::8
	+"([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|"  // 1::6:7:8         1:2:3:4::6:7:8  1:2:3:4::8
	+"([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|"  // 1::5:6:7:8       1:2:3::5:6:7:8  1:2:3::8
	+"([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|"  // 1::4:5:6:7:8     1:2::4:5:6:7:8  1:2::8
	+"[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|"       // 1::3:4:5:6:7:8   1::3:4:5:6:7:8  1::8  
	+":((:[0-9a-fA-F]{1,4}){1,7}|:)|"                     // ::2:3:4:5:6:7:8  ::2:3:4:5:6:7:8 ::8       ::     
	+"fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|"     // fe80::7:8%eth0   fe80::7:8%1     (link-local IPv6 addresses with zone index)
	+"::(ffff(:0{1,4}){0,1}:){0,1}"
	+"((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}"
	+"(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|"          // ::255.255.255.255   ::ffff:255.255.255.255  ::ffff:0:255.255.255.255  (IPv4-mapped IPv6 addresses and IPv4-translated addresses)
	+"([0-9a-fA-F]{1,4}:){1,4}:"
	+"((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}"
	+"(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))";           // 2001:db8:3:4::192.0.2.33  64:ff9b::192.0.2.33 (IPv4-Embedded IPv6 Address)
	

	
	public static boolean isIpAddress(String ipAddress){
		VALID_IPV4_PATTERN=Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
		VALID_IPV6_PATTERN=Pattern.compile(ipv6Pattern, Pattern.CASE_INSENSITIVE);
		
		Matcher m4=X_Full.VALID_IPV4_PATTERN.matcher(ipAddress);
		Matcher m6=X_Full.VALID_IPV6_PATTERN.matcher(ipAddress);
		if(m4.matches()) {return true;}
		if(m6.matches()) {return true;}
		else {return false;}}
		
	public static void main(String[] args){
		List<String> list=new ArrayList<String>();
		
		list.add("2001:0db8:0000:0000:0000:ff00:0042:8329");	// Valid
		list.add("2001:db8:0:0:0:ff00:42:8329");            	// Valid            
		list.add("2001:db8::ff00:42:8329");                    	// Valid
		list.add("::1");                  						// Valid
		list.add("1::");                          				// Valid
		list.add("1::1");  										// Valid
		
		list.add("2001:0DB8:0000:CD30:0000:0000:0000");			// Invalid
		list.add("5::5::5");   									// Invalid                  
		list.add("hf:::");                    					// Invalid  
 
		for(String ip_address:list){
			System.out.println(isIpAddress(ip_address)+" \t<= "+ip_address);}
	
	}

}
