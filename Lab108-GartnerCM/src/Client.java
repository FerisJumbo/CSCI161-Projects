
import java.util.Iterator;

/**
 * Client class holds main method.
 * 
 * @author Cole Gartner
 * @version Oct 21, 2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedBinaryTree<String> equation = new LinkedBinaryTree<>();
        Position<String> root = equation.addRoot("+");
        
        LinkedBinaryTree<String> t1 = new LinkedBinaryTree<>();
        Position<String> t1p1 = t1.addRoot("+");
        t1.addLeft(t1p1, "2");
        t1.addRight(t1p1, "9");
        
        LinkedBinaryTree<String> t2 = new LinkedBinaryTree();
        t2.addRoot("7");
        
        LinkedBinaryTree<String> t3 = new LinkedBinaryTree<>();
        Position<String> t3p1 = t3.addRoot("*");
        t3.addLeft(t3p1, "3");
        t3.addRight(t3p1, "8");
        
        // Attaching Trees
        LinkedBinaryTree<String> t4 = new LinkedBinaryTree();
        Position<String> t4p1 = t4.addRoot("-");
        
        t4.attach(t4p1, t2, t3);
        equation.attach(root, t1, t4);
        
        System.out.println("( 2 + 9 ) + ( 7 - (3 * 8 ) )\n");
        System.out.println("Height: " + equation.height(root));
        
        System.out.println("PreOrder traversal");
        
        Iterator<Position<String>> preOrder = equation.preorder().iterator();
        
        while (preOrder.hasNext()) {
            System.out.print(preOrder.next().getElement() + " ");
        }
        
        System.out.println("\n\nInOrder traversal");
        
        Iterator<Position<String>> inOrder = equation.inorder().iterator();
        
        while (inOrder.hasNext()) {
            System.out.print(inOrder.next().getElement() + " ");
        }
        
        System.out.println("\n\nPostOrder traversal");
        
        Iterator<Position<String>> postOrder = equation.postorder().iterator();
        
        while (postOrder.hasNext()) {
            System.out.print(postOrder.next().getElement() + " ");
        }
        
        System.out.println("\n\nBreathFirst traversal");
        
        Iterator<Position<String>> breadthOrder = equation.breadthfirst().iterator();
        
        while (breadthOrder.hasNext()) {
            System.out.print(breadthOrder.next().getElement() + " ");
        }
        
        System.out.println("\n\nEuler Parenthasize traversal");
        
        String eulerTraversal = equation.eulerParenthasize(root);
        System.out.println(eulerTraversal);
        
    }
    
}
