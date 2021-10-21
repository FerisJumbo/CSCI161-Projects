/**
 * Client class
 * @author Cole Gartner
 * @version Oct 15, 2021
 */
public class Client {

    /**
     * Main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LuckyNumberList lList = new LuckyNumberList();
        
        lList.addLuckyNumber(new LuckyNumber("Jack"));
        lList.addLuckyNumber(new LuckyNumber("Keith"));
        lList.addLuckyNumber(new LuckyNumber("Timmy"));
        lList.addLuckyNumber(new LuckyNumber("Tobby"));
        lList.addLuckyNumber(new LuckyNumber("John"));
        lList.addLuckyNumber(new LuckyNumber("Nick"));
        lList.addLuckyNumber(new LuckyNumber("Matt"));
        lList.addLuckyNumber(new LuckyNumber("Gart"));
        lList.addLuckyNumber(new LuckyNumber("Rahne"));
        lList.addLuckyNumber(new LuckyNumber("Ethan"));
        
        Iterator<Position<LuckyNumber>> defaultIterator = lList.getIterable().iterator();
        Iterator<Position<LuckyNumber>> primeIterator = lList.getPrimeIterable().iterator();
        Iterator<Position<LuckyNumber>> evenIterator = lList.getEvenIterable().iterator();
        
        System.out.println("Lucky Number List Contents");
        while (defaultIterator.hasNext()) {
            LuckyNumber lN = defaultIterator.next().getElement();
            System.out.println(String.format("%-7s\t%1d\t%-4s\t%-9s", lN.getName(),
                                        lN.getNumber(), lList.isEven(lN)?"Even":"Odd",
                                        lList.isPrime(lN)?"Prime":"Not Prime"));
        }
        
        System.out.println("\nLucky Number List Contents (Primes)");
        while (primeIterator.hasNext()) {
            LuckyNumber lN = primeIterator.next().getElement();
            System.out.println(String.format("%-7s\t%1d\t%-4s\t%-9s", lN.getName(),
                                        lN.getNumber(), lList.isEven(lN)?"Even":"Odd",
                                        lList.isPrime(lN)?"Prime":"Not Prime"));
        }
        
        System.out.println("\nLucky Number List Contents (Evens)");
        while (evenIterator.hasNext()) {
            LuckyNumber lN = evenIterator.next().getElement();
            System.out.println(String.format("%-7s\t%1d\t%-4s\t%-9s", lN.getName(),
                                        lN.getNumber(), lList.isEven(lN)?"Even":"Odd",
                                        lList.isPrime(lN)?"Prime":"Not Prime"));
        }
        
    }
    
}
