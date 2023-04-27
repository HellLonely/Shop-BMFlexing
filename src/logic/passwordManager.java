

package logic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;




public class passwordManager {
    public static String hashGenerator(String password){
        MessageDigest md = null;
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
			return sb.toString();
		}

}
