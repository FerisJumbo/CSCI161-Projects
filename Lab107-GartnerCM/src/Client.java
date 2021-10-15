
/**
 * Client class
 * 
 * @author Cole Gartner
 * @version Oct 12, 2021
 */
public class Client {
    
    private static TimingTest timer = new TimingTest();
    
    // capacity for arrays
    private static final int c = 100000000;

    /**
     * Main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayStack<Integer> aStack = new ArrayStack<>(c);
        LinkedStack<Integer> lStack = new LinkedStack<>();
        
        Stack[] stacks = {aStack, lStack};
        
        ArrayQueue<Integer> aQueue = new ArrayQueue<>(c);
        LinkedQueue<Integer> lQueue = new LinkedQueue<>();
        
        Queue[] queues = {aQueue, lQueue};
        
        long[][] timeTrialsPush = new long[4][8];
        long[][] timeTrialsPop = new long[4][8];
           
        // Stack tests
        
        for (int i = 0; i < 2; i++) {
            for (int n = 0; n < 8; n++) {
                
                timer.startTimer();
                for (int j = 0; j <= Math.pow(10, n); j++) {
                    stacks[i].push(j);
                }
                long diff = timer.stopTimer();
                timeTrialsPush[i][n] = diff;
                
                timer.startTimer();
                for (int j = 0; j <= Math.pow(10, n); j++) {
                    stacks[i].pop();
                }
                diff = timer.stopTimer();
                timeTrialsPop[i][n] = diff;
            }
        }
        
        for (int i = 2; i < 4; i++) {
            for (int n = 0; n < 8; n++) {
                
                timer.startTimer();
                for (int j = 0; j <= Math.pow(10, n); j++) {
                    queues[i-2].enqueue(j);
                }
                long diff = timer.stopTimer();
                timeTrialsPush[i][n] = diff;
                
                timer.startTimer();
                for (int j = 0; j <= Math.pow(10, n); j++) {
                    queues[i-2].dequeue();
                }
                diff = timer.stopTimer();
                timeTrialsPop[i][n] = diff;
            }
        }
        
        TablePrint arrayStackTable = new TablePrint("ArrayStack Test", "N", "Push (ns)", "Pop (ns)");
        TablePrint linkedStackTable = new TablePrint("LinkedStack Test", "N", "Push (ns)", "Pop (ns)");
        TablePrint arrayQueueTable = new TablePrint("ArrayQueue Test", "N", "Push (ns)", "Pop (ns)");
        TablePrint linkedQueueTable = new TablePrint("LinkedQueue Test", "N", "Push (ns)", "Pop (ns)");
        
        
        
        long[] n = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

        System.out.println(arrayStackTable.print(n, timeTrialsPush[0], timeTrialsPop[0]));
        System.out.println(linkedStackTable.print(n, timeTrialsPush[1], timeTrialsPop[1]));
        System.out.println(arrayQueueTable.print(n, timeTrialsPush[2], timeTrialsPop[2]));
        System.out.println(linkedQueueTable.print(n, timeTrialsPush[3], timeTrialsPop[3]));
    }
    
    /**
     * Code used from StackOverflow.
     * Question: https://stackoverflow.com/questions/8154366/how-to-center-a-string-using-string-format
     * Center aligns a string.
     * 
     * @author Mertuarez
     * @param text text
     * @param len length
     * @return table
     */
    public static String center(String text, int len){
        String out = String.format("%"+len+"s%s%"+len+"s", "",text,"");
        float mid = (out.length()/2);
        float start = mid - (len/2);
        float end = start + len; 
        return out.substring((int)start, (int)end);
    }
    
}
