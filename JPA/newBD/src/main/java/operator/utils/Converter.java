package operator.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.NoSuchAlgorithmException;

/**
 * Password hashing.
 */
public class Converter extends org.springframework.security.authentication.encoding.BasePasswordEncoder {
    /**
     * Method for password encoding
     * @param secret user's password
     * @return encoded password
     * @throws NoSuchAlgorithmException if algorithm goes wrong
     */
    public static String getMD5(String secret) throws NoSuchAlgorithmException{
        String password = "one two free" + secret + "four five six";
        String md5Hex = DigestUtils.md5Hex(password);
        return md5Hex;
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
