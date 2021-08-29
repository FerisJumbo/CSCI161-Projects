
import java.util.ArrayList;

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
 * Main method access class.
 * 
 * @author Cole Gartner
 * @version Aug 28, 2021
 */
public class Client {
    
    /**
     * Holds all employees created.
     */
    public static ArrayList<Employee> employeeList;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // <editor-fold defaultstate="uncollapsed" desc=" Step 1 ">

        System.out.println("\nPopulating Employee List.");
        
        employeeList = new ArrayList<>();
        
        Salaried al = new Salaried("Manager", 60000, "Al");
        employeeList.add(al);
        
        Hourly kelly = new Hourly("Hostess", 25.75, "Kelly");
        employeeList.add(kelly);
        
        Salaried peggy = new Salaried("CEO", 120000, "Peggy");
        employeeList.add(peggy);
        
        Hourly bud = new Hourly("Busboy", 15.00, "Bud");
        employeeList.add(bud);
        
        Hourly marcy = new Hourly("Server", 10.00, "Marcy");
        employeeList.add(marcy);
        
        Hourly jefferson = new Hourly("Cook", 35.00, "Jefferson");
        employeeList.add(jefferson);
        
        employeeList.add(new Salaried());
        employeeList.add(new Hourly());
        employeeList.add(new Salaried());
        employeeList.add(new Hourly());

        // </editor-fold>
        
        // <editor-fold defaultstate="uncollapsed" desc=" Step 2 ">

        System.out.println("\nPrinting all Employee's");
        
        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }

        // </editor-fold>
        
        // <editor-fold defaultstate="uncollapsed" desc=" Step 3 ">

        System.out.println("\nGiving a 25% raise to all employee's and printing.");
        
        giveRaise(0.25);
        
        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }

        // </editor-fold>
        
        // <editor-fold defaultstate="uncollapsed" desc=" Step 4 ">

        System.out.println("\nGiving a 10% raise to all employee's and printing only non-null employees.");
        
        giveRaise(0.10);
        
        for (Employee e : employeeList) {
            // Tests if an employee is given the null id number
            if (e.getId() != -1)
                System.out.println(e.toString());
        }

        // </editor-fold>
        
        // <editor-fold defaultstate="uncollapsed" desc=" Step 5 ">

        System.out.println("\nUsing class specific .equals() method");
        
        System.out.println("\nTesting al.equals(al)");
        System.out.println(al.equals(al));
        
        System.out.println("\nTesting al.equals(jefferson)");
        System.out.println(al.equals(jefferson));
        
        System.out.println("\nTesting marcy.equals(marcy)");
        System.out.println(al.equals(al));
        
        System.out.println("\nTesting marcy.equals(peggy)");
        System.out.println(al.equals(peggy));

        // </editor-fold>
    }
    
    /**
     * Raises all employees payroll by a set percent.
     * 0.25 -> 25% raise
     * @param percent decimal value
     */
    public static void giveRaise(double percent) {
        percent = 1 + percent;
        
        for (Employee e : employeeList) {
            // Transforms "e" into a cast of Salaried object "s"
            if (e instanceof Salaried s) {
                
                s.setSalary((int) (s.getSalary() * percent));
                
            // Transorms "e" into a cast of Hourly object "h"
            } else if (e instanceof Hourly h) {
                // Use Math.floor and "* 100 / 100" to keep only two decimal places
                h.setHourlyRate(Math.floor( (h.getHourlyRate()) * percent * 100) / 100);
                
            }
        }
    }
}
