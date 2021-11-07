package program;

/**
 * Holds a grouping symbol and its complement.
 *
 * @author Cole Gartner
 * @version Nov 01, 2021
 */
public class Grouper implements Token {
    
    private String token, complement;
    
    /**
     * Creates a Grouper that holds the token and its complement.
     * @param s grouper
     */
    public Grouper (String s) {
        token = s;
        complement = switch(token) {
            case "(" -> ")";
            case ")" -> "(";
            case "[" -> "]";
            case "]" -> "[";
            case "{" -> "}";
            case "}" -> "{";
            default -> "";
        };
    }
    
    /**
     * Returns wether the grouping symbol is an opener.
     * @return isOpen
     */
    public boolean isOpen() {
        return switch(token) {
            case "(" -> true;
            case "[" -> true;
            case "{" -> true;
            default -> false;
        };
    }
    
    /**
     * Checks to see if the character c can be converted into its token object.
     * @param c character
     * @return isToken
     */
    public static boolean isToken(char c) {
        return switch(String.valueOf(c)) {
            case "(" -> true;
            case ")" -> true;
            case "[" -> true;
            case "]" -> true;
            case "{" -> true;
            case "}" -> true;
            default -> false;
        };
    }

    /**
     * Returns the token string value
     * @return token
     */
    @Override
    public String getToken() {
        return token;
    }

    /**
     * Gets the complement
     * @return the complement
     */
    public String getComplement() {
        return complement;
    }
    
    
    
}
