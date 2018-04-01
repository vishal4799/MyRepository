package com.bmc.sync;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Person implements Runnable{
    String personName;
    private ATM atm;
    public Person(ATM atm,String personName){
        this.atm=atm;
        this.personName=personName;
    }

    @Override
    public void run() {
       System.out.println(personName+" waiting in queue...");
       synchronized(atm){
            try {
                System.out.println(personName+" enters ATM");
                System.out.println(personName+" doing transaction");
                Thread.sleep(500);
                System.out.println(personName+" completes transaction");
            } catch (InterruptedException ex) {
                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
            }
       System.out.println(personName+" exits ATM");
       }
    }
    
    
}
