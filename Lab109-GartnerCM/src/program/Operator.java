package program;

/**
 * Holds an operator.
 *
 * @author Cole Gartner
 * @version Nov 01, 2021
 */
public class Operator implements Token {
    
    /** An enum of operators */
    private enum Operators { PLUS, MINUS, MULTIPLY, DIVIDE }
    
    private Operators operator;
    
    /**
     * Constructor to convert string operator into an enum of operator.
     * @param o operator
     * @throws IllegalExpressionException IllegalExpressionException
     */
    public Operator (String o) throws IllegalExpressionException {
        operator = switch (o) {
            case "+" -> Operators.PLUS;
            case "-" -> Operators.MINUS;
            case "*" -> Operators.MULTIPLY;
            case "/" -> Operators.DIVIDE;
            default -> throw new IllegalExpressionException("Invalid Operator");
        };
    }
    
    /**
     * When calculating two Operands together, it looks for whether any operand
     * is a double value and if so will calculate both fields as double values.
     * It also will calculate both fields in the case that the operator is division.
     * @param o1 Operand 1
     * @param o2 Operand 2
     * @return new Operand
     * @throws IllegalExpressionException IllegalExpressionException
     */
    public Operand calculate(Operand o1, Operand o2) throws IllegalExpressionException {
        
        if ( !operator.equals(Operators.DIVIDE) && o1.isInteger() && o2.isInteger() ) {
            int a = o1.getIntVal();
            int b = o2.getIntVal();
            
            return switch (operator) {
                case PLUS -> new Operand(String.valueOf(a+b));
                case MINUS -> new Operand(String.valueOf(a-b));
                case MULTIPLY -> new Operand(String.valueOf(a*b));
                default -> new Operand("");
            };
        }
        else {
            double a = o1.getDoubVal();
            double b = o2.getDoubVal();
            
            return switch (operator) {
                case PLUS -> new Operand(String.valueOf(a+b));
                case MINUS -> new Operand(String.valueOf(a-b));
                case MULTIPLY -> new Operand(String.valueOf(a*b));
                case DIVIDE -> new Operand(String.valueOf(a/b));
                default -> new Operand("");
            };
        }
    }

    /**
     * Checks to see if the character c can be converted into its token object.
     * @param c character
     * @return isToken
     */
    public static boolean isToken(char c) {
        return switch(String.valueOf(c)) {
            case "+" -> true;
            case "-" -> true;
            case "*" -> true;
            case "/" -> true;
            default -> false;
        };
    }
    
    /**
     * Returns the token string value
     * @return token
     */
    @Override
    public String getToken() {
        return switch (operator) {
            case PLUS -> "+";
            case MINUS -> "-";
            case MULTIPLY -> "*";
            case DIVIDE -> "/";
            default -> "";
        };
    }

    @Override
    public String toString() {
        return getToken();
    }
    
}
