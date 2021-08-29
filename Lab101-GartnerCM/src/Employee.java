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
 * Employee class which holds base information of an Employee
 *
 * @author Cole Gartner
 * @version Aug 28, 2021
 */
public class Employee {
    
    /**
     * Keeps track of the amount of Employees made.
     */
    public static int count = 0;
    
    private int id;
    private String name;

    // <editor-fold defaultstate="uncollapsed" desc=" Constructors ">

    /**
     * Null Employee
     */
    public Employee() {
        id = -1;
        name = "";
        
        count++;
    }

    /**
     * Creates a new Employee.
     * @param newName new name
     */
    public Employee(String newName) {
        id = count;
        name = newName;
        
        count++;
    }

    // </editor-fold>
    
    
    
    // <editor-fold defaultstate="uncollapsed" desc=" Override Methods ">

    /**
     * 
     * @param obj object
     * @return Whether the obj equals the same Employee
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            if (((Employee) obj).getId() == id) {
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
        return  "\nID:       " + id +
                "\nName:     " + name;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="uncollapsed" desc=" Getters & Setters ">

    /**
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    // </editor-fold>
    
}
