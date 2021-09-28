/**
 * Holds the main method
 * @author Cole Gartner
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("NDSU MENS FOOTBALL TEAM\n");
        
        ArrayBag<Player> mensTeam = new ArrayBag<>();
        
        mensTeam.add(new Player("Zach Mathis", "Wide Reciever", 0));
        mensTeam.add(new Player("Quincy Patterson", "Quarterback", 2));
        mensTeam.add(new Player("Cole Payton", "Quarterback", 15));
        mensTeam.add(new Player("Dalton Tieman", "Cornerback", 22));
        mensTeam.add(new Player("Jernaro Ocama", "Cornerback", 24));
        mensTeam.add(new Player("TK Marshall", "Running Back", 28));
        mensTeam.add(new Player("Sam Jung", "Safety", 35));
        mensTeam.add(new Player("Griffin Crosa", "Kicker", 39));
        
        System.out.println(mensTeam.toString());
        
        System.out.println("Removed: " + mensTeam.remove());
        
        System.out.println(mensTeam.toString());
        
        Player mensFifthPlayer = mensTeam.get(4);
        System.out.println(mensFifthPlayer);
        
        mensTeam.add(new Player("Hayden Johnston", "Offensive Guard", 59));
        System.out.println("Added: " + mensTeam.get(mensTeam.size()-1));
        
        System.out.println(mensTeam);
        
        System.out.println("Removed: " + mensTeam.remove(mensFifthPlayer));
        
        System.out.println(mensTeam);
        
        ArrayBag<String> courses = new ArrayBag<>();
        courses.add("COMM 110");
        courses.add("CSCI 161");
        courses.add("HNES 100");
        courses.add("MATH 166");
        courses.add("MUSC 111");
        courses.add("THEA 115");
        
        System.out.println("\n\nCOURSES\n");
        System.out.println(courses);
        
        System.out.println("Removed: " + courses.remove());
        System.out.println(courses);
        
        
        System.out.println("\n\nNDSU WOMANS BASKETBALL TEAM\n");
        
        LinkedBag<Player> womansTeam = new LinkedBag<>();
        
        womansTeam.add(new Player("Kylie Strop", "Guard", 2));
        womansTeam.add(new Player("Ellie Dague", "Guard", 4));
        womansTeam.add(new Player("Ryan Cobbins", "Guard/Forward", 5));
        womansTeam.add(new Player("Gabby Forde", "Forward", 14));
        womansTeam.add(new Player("Olivia Skibiel", "Guard/Forward", 23));
        womansTeam.add(new Player("Abby Schulte", "Guard", 24));
        womansTeam.add(new Player("Katie Hildebrandt", "Forward", 33));
        womansTeam.add(new Player("Emily Dietz", "Forward", 34));
        
        System.out.println(womansTeam);
        
        System.out.println("Removed: " + womansTeam.remove());
        
        System.out.println(womansTeam);
        
        Player womansFifthPlayer = womansTeam.get(4);
        System.out.println("Fifth Player: " + womansFifthPlayer);
        
        womansTeam.add(new Player("Britney Epperson", "Forward", 25));
        System.out.println("Added: " + womansTeam.get(womansTeam.size()-1));
        System.out.println(womansTeam);
        
        System.out.println("Removed: " + womansTeam.remove(womansFifthPlayer));
        
        System.out.println(womansTeam);
    }
    
}
