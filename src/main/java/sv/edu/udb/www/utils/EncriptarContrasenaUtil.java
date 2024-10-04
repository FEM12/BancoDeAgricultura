package sv.edu.udb.www.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncriptarContrasenaUtil {

    public static String encriptarContrasena(String contrasena) {
        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(contrasena.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {

                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);

            }

            return hexString.toString();
        }
        catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    }

}
