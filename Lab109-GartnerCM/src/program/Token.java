package program;

/**
 * A basic interface to connect the 3 token subclasses.
 *
 * @author Cole Gartner
 * @version Nov 01, 2021
 */
public interface Token { 
    
    /**
     * Returns the token string value
     * @return token
     */
    public String getToken();
    
    /**
     * Checks to see if the character c can be converted into its token object.
     * @param c character
     * @return isToken
     */
    //public static boolean isToken(char c);
    
}
