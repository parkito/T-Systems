package operator.utils;

/**
 * A parser class to parse different numbers like contractNumber.
 * It parses "(555) 555-55-55" to "5555555555".
 */
public class Parser {
    public static String doParse(String number) {
        return number.replaceAll(" ", "").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "");
    }

    public static void main(String[] args) {
        String a = "(555) 555-55-55";
        System.out.println(doParse(a));
    }
}
