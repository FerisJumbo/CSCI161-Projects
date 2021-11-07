package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import lib.LinkedBinaryTree;
import lib.LinkedQueue;
import lib.Position;
import lib.TablePrint;

/**
 * Client Class
 *
 * @author Cole Gartner
 * @version Oct 31, 2021
 */
public class Client {
    
    /**
     * Main method.
     * @param args args
     */
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(System.in);
        
            // D:\System\Desktop\lab109.txt
            System.out.print("What is the Absolute Filepath to expression file\n> ");
            String filepath = keyboard.nextLine();

            File expressions = new File(filepath);
            Scanner fileScan = new Scanner(expressions);
            
            LinkedQueue<String> queueExpressions = new LinkedQueue<>();
        
            while (fileScan.hasNext()) {
                queueExpressions.enqueue(fileScan.nextLine());
            }
            
            TablePrint table = new TablePrint(filepath, "Expression", "Valid", "Value", "Post-Fix", "Pre-Order", "In-Order", "Post-Order", "Eulers");
            String[] e = new String[queueExpressions.size()];
            String[] v = new String[queueExpressions.size()];
            String[] val = new String[queueExpressions.size()];
            String[] pf = new String[queueExpressions.size()];
            String[] preo = new String[queueExpressions.size()];
            String[] io = new String[queueExpressions.size()];
            String[] posto = new String[queueExpressions.size()];
            String[] eu = new String[queueExpressions.size()];
            
            int current = 0;
            while (!queueExpressions.isEmpty()) {
                String rawExpression = queueExpressions.dequeue();
                try {
                    ShuntingYard algo = new ShuntingYard(rawExpression);
                    
                    e[current] = rawExpression;
                    
                    v[current] = "Valid";
                    
                    val[current] = algo.evaluate();
                    
                    pf[current] = "";
                    LinkedQueue<Token> postfix = algo.postFixNotation(algo.getExpression());
                    while(!postfix.isEmpty()) {
                        pf[current] += "("+postfix.dequeue().getToken()+")";
                    }
                    
                    LinkedBinaryTree<Token> tree = algo.makeTree();
                    
                    preo[current] = "";
                    Iterator<Position<Token>> preoIt = tree.preorder().iterator();
                    while (preoIt.hasNext()) {
                        preo[current] += "("+preoIt.next().getElement().getToken()+")";
                    }
                    
                    io[current] = "";
                    Iterator<Position<Token>> inIt = tree.inorder().iterator();
                    while (inIt.hasNext()) {
                        io[current] += "("+inIt.next().getElement().getToken()+")";
                    }
                    
                    posto[current] = "";
                    Iterator<Position<Token>> postoIn = tree.postorder().iterator();
                    while (postoIn.hasNext()) {
                        posto[current] += "("+postoIn.next().getElement().getToken()+")";
                    }
                    
                    eu[current] = tree.eulerParenthasize(tree.root());
                    
                } catch (Exception ex) { // Invalid Expression
                    e[current] = rawExpression;
                    v[current] = "Invalid";
                    val[current] = "";
                    pf[current] = "";
                    preo[current] = "";
                    io[current] = "";
                    posto[current] = "";
                    eu[current] = "";
                }
                
                current++;
            }
            System.out.println(table.print(e, v, val, pf, preo, io, posto, eu));
            
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
