/**
 * Holds key information about a stocks quote on a specific day
 *
 * @author Cole Gartner
 * @version Sep 09, 2021
 */
public class Quote {
    
    private String ticker, date;
    private double open, high, low, close;
    private int vol;
    
    // <editor-fold defaultstate="uncollapsed" desc=" Constructors ">
    
    /**
     * Creates an empty quote object
     */
    public Quote() { 
        ticker = date = "";
        open = high = low = close = 0.0;
        vol = 0;
    }
    
    /**
     * Creates a full quote object
     * @param ticker ticker
     * @param date date
     * @param open open
     * @param high high
     * @param low low
     * @param close close
     * @param vol vol
     */
    public Quote(String ticker, String date, double open, double high, double low, double close, int vol) {
        this.ticker = ticker;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.vol = vol;
    }
    
    // </editor-fold>
    
    /**
     * Returns the difference between close and open
     * @return margin
     */
    public double margin() {
        return close-open;
    }
    
    // <editor-fold defaultstate="uncollapsed" desc=" Override Methods ">

    /**
     * To String Method
     * @return  to String
     */
    @Override
    public String toString() {
        return getClass().getName() + "@" + getTicker() + ":" + getDate() + ":" + getOpen() +
                ":" + getHigh() + ":" + getLow() + ":" + getClose() + ":" + getVol();
    }
    
    /**
     * Equals Method
     * @param obj object
     * @return whether the objects are equal to each other
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Quote o) {
            if ( o.getTicker().equals(getTicker()) && o.getDate().equals(getDate()) && o.getOpen() == getOpen() &&
                    o.getHigh() == getHigh() && o.getLow() == getLow() && o.getClose() == getClose() && o.getVol() == getVol()) {
                return true;
            }
            return false;
        }
        return false;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="uncollapsed" desc=" Getters & Setters ">
    
    /**
     * @return the ticker
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * @param ticker the ticker to set
     */
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the open
     */
    public double getOpen() {
        return open;
    }

    /**
     * @param open the open to set
     */
    public void setOpen(double open) {
        this.open = open;
    }

    /**
     * @return the high
     */
    public double getHigh() {
        return high;
    }

    /**
     * @param high the high to set
     */
    public void setHigh(double high) {
        this.high = high;
    }

    /**
     * @return the low
     */
    public double getLow() {
        return low;
    }

    /**
     * @param low the low to set
     */
    public void setLow(double low) {
        this.low = low;
    }

    /**
     * @return the close
     */
    public double getClose() {
        return close;
    }

    /**
     * @param close the close to set
     */
    public void setClose(double close) {
        this.close = close;
    }

    /**
     * @return the vol
     */
    public int getVol() {
        return vol;
    }

    /**
     * @param vol the vol to set
     */
    public void setVol(int vol) {
        this.vol = vol;
    }
    
    // </editor-fold>
    
}
