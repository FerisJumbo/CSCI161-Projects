package program;

/**
 * Holds an operand.
 *
 * @author Cole Gartner
 * @version Nov 01, 2021
 */
public class Operand implements Token {
    
    private String operand;
    
    private Integer intVal;
    private Double doubVal;
    
    private boolean isInt;
    
    /**
     * Converts operand.  If the operand is a double, only getDoubVal will work
     * as a string double cannot be converted to integer.
     * @param o operand
     * @throws IllegalExpressionException IllegalExpressionException
     */
    public Operand (String o) throws IllegalExpressionException {
        operand = o;
        
        try {
            intVal = Integer.parseInt(operand);
            doubVal = Double.parseDouble(operand);
            isInt = true;
        } catch (NumberFormatException e) {
            try {
                doubVal = Double.parseDouble(operand);
                isInt = false;
            } catch (NumberFormatException ex) {
                throw new IllegalExpressionException("Cannot convert \"" + operand + "\"", ex);
            }
        }
    }
    
    /**
     * Gets the integer value.
     * @return intVal
     */
    public int getIntVal() { return intVal; }
    
    /**
     * Gets the double value.
     * @return doubVal
     */
    public double getDoubVal() { return doubVal; }
    
    /**
     * Returns wether this operand is an integer.
     * @return isInteger
     */
    public boolean isInteger() { return isInt; }
    
    /**
     * Checks to see if the character c can be converted into its token object.
     * @param t character
     * @return isToken
     */
    public static boolean isToken(char t) {
        try {
            Integer.parseInt(String.valueOf(t));
            Double.parseDouble(String.valueOf(t));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Returns the token string value
     * @return token
     */
    public String getToken() { return operand; }

    @Override
    public String toString() {
        return operand;
    }
    
}
