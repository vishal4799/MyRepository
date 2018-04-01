package com.bmc.sync;

/**
 *
 * @author user
 */
public class ATMDemo {
    public static void main(String[] args) {
        ATM atm=new ATM("ICICI Bank","Yerwada");
        Person person1=new Person(atm,"Sabbir");
        Person person2=new Person(atm,"Amit");
        Person person3=new Person(atm,"Rakesh");
        Person person4=new Person(atm,"Mohit");
        Person person5=new Person(atm,"Chirag");
        Person person6=new Person(atm,"Roshni");
        
        Thread worker1=new Thread(person1);
        Thread worker2=new Thread(person2);
        Thread worker3=new Thread(person3);
        Thread worker4=new Thread(person4);
        Thread worker5=new Thread(person5);
        Thread worker6=new Thread(person6);
        
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        worker5.start();
        worker6.start();
        
        
        
        
    }
    
}
