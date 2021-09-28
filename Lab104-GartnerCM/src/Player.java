/**
 * Holds information about a player.
 *
 * @author Cole Gartner
 * @version Sep 21, 2021
 */
public class Player {
    
    private String name,
                   positionPlayed;
    private int jerseyNumber;
    
    
    // <editor-fold defaultstate="uncollapsed" desc=" Constructors ">

    /**
     * Creates an empty Player
     */
    public Player() {
        name = positionPlayed = "";
        jerseyNumber = 0;
    }
    
    /**
     * Creates a new Player
     * @param n name
     * @param pP position
     * @param jN jersey number
     */
    public Player(String n, String pP, int jN) {
        name = n;
        positionPlayed = pP;
        jerseyNumber = jN;
    }
    
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="uncollapsed" desc=" Override Methods ">

    @Override
    public String toString() {
        return getClass().getName() + "@" + name + ":" + positionPlayed + ":" + jerseyNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Player) {
            if (((Player) o).toString().equals(this.toString())) return true;
        }
        return false;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="uncollapsed" desc=" Getters & Setters ">
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the positionPlayed
     */
    public String getPositionPlayed() {
        return positionPlayed;
    }

    /**
     * @param positionPlayed the positionPlayed to set
     */
    public void setPositionPlayed(String positionPlayed) {
        this.positionPlayed = positionPlayed;
    }

    /**
     * @return the jerseyNumber
     */
    public int getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * @param jerseyNumber the jerseyNumber to set
     */
    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
    
    // </editor-fold>
}
