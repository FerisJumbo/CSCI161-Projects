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
 * Salaried class which extends the Employee.java class.
 *
 * @see "Employee.java"
 * 
 * @author Cole Gartner
 * @version Aug 28, 2021
 */
public class Salaried extends Employee {
    
    /**
     * Keeps track of Salaried Employees created
     */
    public static int count = 0;

    private String title;
    private int salary;
    
    // <editor-fold defaultstate="uncollapsed" desc=" Constructors ">

    /**
     * Null Salaried Employee
     * @see "Employee()"
     */
    public Salaried() {
        super();
        title = "";
        salary = 0;
        
        count++;
    }
    
    /**
     * Creates a Salaried-Null Employee
     * @see "Employee()"
     * 
     * @param newTitle title
     * @param newSalary salary
     */
    public Salaried(String newTitle, int newSalary) {
        super();
        title = newTitle;
        salary = newSalary;
        
        count++;
    }

    /**
     * Creates a Salaried Employee
     * @see "Employee(int, String)"
     * 
     * @param newTitle title
     * @param newSalary salary
     * @param newName name
     */
    public Salaried(String newTitle, int newSalary, String newName) {
        super(newName);
        this.title = newTitle;
        this.salary = newSalary;
        
        count++;
    }

    // </editor-fold>

    
    
    // <editor-fold defaultstate="uncollapsed" desc=" Override Methods ">

    /**
     * 
     * @param obj object
     * @return Whether obj is the same Salaried Employee
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Salaried) {
            if (((Salaried) obj).getId() == getId()) {
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
        return  super.toString()+":"+getClass().getName()+"@"+title+":"+salary;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="uncollapsed" desc=" Getters & Setters ">
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    // </editor-fold>

}
