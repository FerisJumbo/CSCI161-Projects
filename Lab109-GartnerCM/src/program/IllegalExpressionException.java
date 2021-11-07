package program;

/**
 * IllegalExpressionException
 * Used to notify the client of an illegal expression that cannot be computed.
 *
 * @author Cole Gartner
 * @version Oct 31, 2021
 */
public class IllegalExpressionException extends Exception {
    
    /**
     * Creates a new Illegal Expression Exception with just text.
     * @param text body
     */
    public IllegalExpressionException(String text) {
            super(text);
        }
        
    /**
     * Creates a new Illegal Expression Exception with text and a separate throwable.
     * @param text body
     * @param e throwable exception
     */
    public IllegalExpressionException(String text, Throwable e) {
        super(text, e);
    }
    
}
