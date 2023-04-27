

package logic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;




public class passwordManager {
    public static void hashGenerator(){
        MessageDigest md = null;
        String password = "1234";
	try {
	md = MessageDigest.getInstance("SHA-256");
	} 
	catch (NoSuchAlgorithmException e) {		
	e.printStackTrace();
	}
	    
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
	    
	for(byte b : hash) {        
	sb.append(String.format("%02x", b));
	}
        System.out.println(sb.toString());
        System.out.println(sb.length());
    }
}
