

package logic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class passwordManager {

    /**
     * Genera un hash de la contraseña que le pasamos.
    */
    
    private String nativePassword;

    public passwordManager(String nativePassword) {
        this.nativePassword = nativePassword;
    }
    

    public String hashGenerator() {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] hash = md.digest(nativePassword.getBytes());
        StringBuffer sb = new StringBuffer();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
