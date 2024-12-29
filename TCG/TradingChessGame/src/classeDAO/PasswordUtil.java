package classeDAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
    public static String hashPassword(String password) { 
        try {
        	
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); //instance de l'algo SHA-256
            byte[] hash = digest.digest(password.getBytes()); //hachage du mots de passe 
            String hexString = "";
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString += "0";
                }
                hexString += hex;
            }
            return hexString;
            
        } catch (NoSuchAlgorithmException e) {
        	
            throw new RuntimeException(e);
            
        }
    }
}