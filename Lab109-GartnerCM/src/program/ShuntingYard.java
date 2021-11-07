package program;

import lib.LinkedBinaryTree;
import lib.LinkedQueue;
import lib.LinkedStack;
import lib.Position;

/**
 * Shunting Yard algorithm is a way of computing infix notation strings by converting
 * them to postfix notation and solving them using stacks and queues.  While this class
 * isn't a perfect mathematical implementation, it satisfies the Shunting Yard criteria.
 *
 * @author Cole Gartner
 * @version Nov 01, 2021
 */
public class ShuntingYard {
    
    private final LinkedQueue<Token> expression;
    
    /**
     * Constructor that converts the string in a linked queue of tokens.
     * @param s expression
     * @throws IllegalExpressionException IllegalExpressionException
     */
    public ShuntingYard (String s) throws IllegalExpressionException {
        expression = normalize(s);
    }

    /**
     * normalizes the values in the string by converting each character into its
     * corresponding token (Operator, Operand, Grouper).  It uses string concatenation
     * for operands and negative values.
     * @param s expression
     * @return LinkedQueue expression
     * @throws IllegalExpressionException IllegalExpressionException
     */
    private LinkedQueue<Token> normalize(String s) throws IllegalExpressionException {
        LinkedQueue<Token> tokenList = new LinkedQueue<>();
        
        char[] charArray = s.toCharArray();
        
        String operand = "";
        boolean negativeCheck = true;
        for (char c : charArray) {
            if (Operator.isToken(c)) { // if Operator
                
                if ("-".equals(String.valueOf(c)) && negativeCheck) { // Assings negative value to operand
                    operand += c;
                    negativeCheck = false;
                    continue;
                }
                
                if (operand == "") {
                    tokenList.enqueue(new Operator(String.valueOf(c)));
                } else {
                    tokenList.enqueue(new Operand(operand));
                    operand = "";
                    tokenList.enqueue(new Operator(String.valueOf(c)));
                }
                
                negativeCheck = true;
                
            } else if (Operand.isToken(c)) { // if Operand
                operand += c;
                negativeCheck = false;
                
            } else if (Grouper.isToken(c)) { // if Grouping
                Grouper g = new Grouper(String.valueOf(c));
                
                if (g.isOpen()) negativeCheck = true;
                
                if (operand != "") {
                    tokenList.enqueue(new Operand(operand));
                    operand = "";
                }
                tokenList.enqueue(g);
                
                
            } else if (".".equals(String.valueOf(c))) {
                operand += '.';
            }
        }
        
        if (operand != "") tokenList.enqueue(new Operand(operand));
        
        if (validate(tokenList))
            return tokenList;
        else
            throw new IllegalExpressionException("Expression is invalid");
    }
    
    /**
     * Runs a minor check on the infix order to make sure there isn't some
     * rules that break logic.
     * @param t token queue
     * @return valid
     */
    private boolean validate(LinkedQueue<Token> t) {
        Token prevToken = t.dequeue();
        t.enqueue(prevToken);
        
        Token currToken;
        int size = t.size()-1;
        for (int i = 0; i < size; i++) {
            currToken = t.dequeue();
            if (currToken instanceof Operand) { // Cant have an operand or closing grouping before
                if (prevToken instanceof Operand) return false;
                if (prevToken instanceof Grouper g) if (!g.isOpen()) return false;
            }
            else if (currToken instanceof Operator) { // Cant have an operator before
                if (prevToken instanceof Operator) return false;
            }
            else if (currToken instanceof Grouper c) { // Cant have a number before opening grouping
                if (prevToken instanceof Operand) if (c.isOpen()) return false;
            }
            prevToken = currToken;
            t.enqueue(currToken);
        }
        return true;
    }
    
    /**
     * converts the infix expression to postfix notation.
     * @param infix infix
     * @return postfix
     */
    public LinkedQueue<Token> postFixNotation(LinkedQueue<Token> infix) {
        LinkedQueue<Token> postfix = new LinkedQueue<>();
        LinkedStack<Token> operatorStack = new LinkedStack<>();
        
        while (!infix.isEmpty()) {
            Token currToken = infix.dequeue();
            
            // Grouping Token
            if (currToken instanceof Grouper) {
                if ( ((Grouper) currToken).isOpen() )
                    operatorStack.push(currToken);
                else {
                    // Poping operators until the matching grouping symbol is found
                    while (!((Grouper) currToken).getComplement().equals(operatorStack.top().getToken())) {
                        postfix.enqueue(operatorStack.pop());
                    }
                    operatorStack.pop(); // pop off the open grouping symbol
                }
            }
            
            // Operator Token
            else if (currToken instanceof Operator) {
                operatorStack.push(currToken);
            }
            
            // Operand Token
            else if (currToken instanceof Operand) {
                postfix.enqueue(currToken);
            }
        }
        
        // If tokens are left in the stack, move them to the queue
        while (!operatorStack.isEmpty()) {
            postfix.enqueue(operatorStack.pop());
        }
        
        return postfix;
    }
    
    /**
     * Evaluates the expression held in the class.
     * @return value as a string.
     * @throws IllegalExpressionException IllegalExpressionException
     */
    public String evaluate() throws IllegalExpressionException {
        LinkedQueue<Token> postfix = postFixNotation(getExpression());
        LinkedStack<Operand> numberStack = new LinkedStack<>();
        
        while (!postfix.isEmpty()) {
            Token currToken = postfix.dequeue();
            
            if (currToken instanceof Operator) {
                Operand right = numberStack.pop();
                Operand left = numberStack.pop();
                Operand value = ((Operator) currToken).calculate(left, right);
                numberStack.push(value);
            } else {
                numberStack.push((Operand) currToken);
            }
        }
        
        return numberStack.pop().getToken();
    }
    
    /**
     * Returns a tree version of the expression.
     * @return binary tree
     */
    public LinkedBinaryTree<Token> makeTree() {
        LinkedBinaryTree<Token> tree = new LinkedBinaryTree<>();
        
        LinkedQueue<Token> postfix = postFixNotation(getExpression());
        LinkedStack<Token> invertPostfix = new LinkedStack<>();
        
        while (!postfix.isEmpty()) invertPostfix.push(postfix.dequeue());
        
        tree.addRoot(invertPostfix.pop());
        
        if (!invertPostfix.isEmpty()) tree = subtreeRecursion(tree, tree.root(), invertPostfix);
        
        return tree;
    }
    
    /**
     * Used to implement the inverted queue into a binary tree
     * @param tr tree
     * @param c current position
     * @param stack stack
     * @return Binary Tree
     */
    private LinkedBinaryTree<Token> subtreeRecursion(LinkedBinaryTree<Token> tr, Position<Token> c, LinkedStack<Token> stack) {
        Position<Token> right = tr.addRight(c, stack.pop());
        if (right.getElement() instanceof Operator) {
            subtreeRecursion(tr, right, stack);
        }
        
        Position<Token> left = tr.addLeft(c, stack.pop());
        if (left.getElement() instanceof Operator) {
            subtreeRecursion(tr, left, stack);
        }
        
        return tr;
    }

    /**
     * Clones the expression to create a new instance of it.
     * @return the expression
     */
    public LinkedQueue<Token> getExpression() {
        LinkedQueue<Token> newCloneExpression = new LinkedQueue<>();
        int size = expression.size();
        for (int i = 0; i < size; i++) {
            Token t = expression.dequeue();
            newCloneExpression.enqueue(t);
            expression.enqueue(t);
        }
        
        return newCloneExpression;
    }
    
}
