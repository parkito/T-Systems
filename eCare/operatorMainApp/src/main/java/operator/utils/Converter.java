package operator.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;

/**
 * Password hashing.
 */
public class Converter extends org.springframework.security.authentication.encoding.BasePasswordEncoder {

    /**
     * Method for password encoding
     *
     * @param secret user's password
     * @return encoded password
     * @throws NoSuchAlgorithmException if algorithm goes wrong
     */
    public static String getMD5(String secret) throws NoSuchAlgorithmException {
        String password = "one two free" + secret + "four five six";
        String md5Hex = DigestUtils.md5Hex(password);
        return md5Hex;
    }

    /**
     * Method for password checking
     *
     * @param s  - first password for checking
     * @param s2 - second password for checking
     * @param o  object for checking
     * @return true - if passwords are equals, false if aren't
     */
    @Override
    public boolean isPasswordValid(String s, String s2, Object o) {
        try {
            return (s.equals(getMD5(s2)));
        } catch (NoSuchAlgorithmException ex) {
            return false;
        }
    }

    /**
     * Support method for encoded
     *
     * @param s password for checking
     * @param o object for checking
     * @return encoded password
     */
    @Override
    public String encodePassword(String s, Object o) {
        try {
            return getMD5(s);
        } catch (NoSuchAlgorithmException ex) {
            return s;
        }
    }
}
