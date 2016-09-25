package operator.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A controllers that converts to MD5.
 */
public class Converter extends org.springframework.security.authentication.encoding.BasePasswordEncoder {
    public static String getMD5(String word) throws NoSuchAlgorithmException{
        String password = "notParanoic" + word + "really";
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] array = messageDigest.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte anArray : array) {
            sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    @Override
    public boolean isPasswordValid(String s, String s2, Object o) {
        try {
        return (s.equals(getMD5(s2))); }
        catch (NoSuchAlgorithmException ex) {
            return false;
        }
    }

    @Override
    public String encodePassword(String s, Object o) {
        try {
            return getMD5(s);
        }
        catch (NoSuchAlgorithmException ex) {
            return s;
        }
    }
}
