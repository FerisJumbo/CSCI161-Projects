/*
 * Copyright 2021 Cole Gartner.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Description of Hourly
 *
 * @author Cole Gartner
 * @version Aug 28, 2021
 */
public class Hourly extends Employee {
    
    /**
     * Keeps track of the amount of Hourly Employees created.
     */
    public static int count = 0;
    
    private String position;
    private double hourlyRate;
    
    // <editor-fold defaultstate="uncollapsed" desc=" Constructors ">
    
    /**
     * Null Hourly Employee
     */
    public Hourly() {
        super();
        position = "";
        hourlyRate = 0;
        
        count++;
    }
    
    /**
     * Creates a Hourly-Null Employee
     * @param position position
     * @param hourlyRate hourly rate
     */
    public Hourly(String position, double hourlyRate) {
        super();
        this.position = position;
        this.hourlyRate = hourlyRate;
        
        count++;
    }
    
    /**
     * Creates a Hourly Employee
     * @param position position
     * @param hourlyRate hourly rate
     * @param newName name
     */
    public Hourly(String position, double hourlyRate, String newName) {
        super(newName);
        this.position = position;
        this.hourlyRate = hourlyRate;
        
        count++;
    }
    
    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="uncollapsed" desc=" Override Methods ">

    /**
     * 
     * @param obj object
     * @return Whether the obj equals the same hourly employee
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hourly) {
            if (((Hourly) obj).getId() == getId()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @return to string
     */
    @Override
    public String toString() {
        return  super.toString()+":"+getClass().getName()+"@"+position+":"+hourlyRate;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="uncollapsed" desc=" Getters & Setters ">
    
    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the hourlyRate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * @param hourlyRate the hourlyRate to set
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    // </editor-fold>

}
