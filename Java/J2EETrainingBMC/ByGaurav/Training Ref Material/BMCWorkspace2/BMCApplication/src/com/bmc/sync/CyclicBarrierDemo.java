package com.bmc.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author user
 */
class CyclicBarrierRunnable1 implements Runnable{

    @Override
    public void run() {
        System.out.println("--Barrier 1 executed--");
    }
    
}
class CyclicBarrierRunnable2 implements Runnable{

    @Override
    public void run() {
        System.out.println("--Barrier 2 executed--");
    }
    
}


class WorkerThread implements Runnable{
   private CyclicBarrier barrier1;
   private CyclicBarrier barrier2;
   private String name;
    public WorkerThread(CyclicBarrier barrier1,CyclicBarrier barrier2,String name){
        this.barrier1=barrier1;
        this.barrier2=barrier2;
        this.name=name;
    }
    @Override
    public void run() {
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(name+" waiting at Barrier 1");
            barrier1.await();
            System.out.println(name+" crossed Barrier 1");
            Thread.sleep(1000);
            System.out.println(name+" waiting at Barrier 2");
            barrier2.await();
            System.out.println(name+" crossed Barrier 2");
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier1=new CyclicBarrier(2,new CyclicBarrierRunnable1());
        CyclicBarrier barrier2=new CyclicBarrier(2,new CyclicBarrierRunnable2());
        
        Thread worker1=new Thread(new WorkerThread(barrier1,barrier2,"Thread-1"));
        Thread worker2=new Thread(new WorkerThread(barrier1,barrier2,"Thread-2"));
        Thread worker3=new Thread(new WorkerThread(barrier1,barrier2,"Thread-3"));
        worker1.start();
        worker2.start();
        worker3.start();
        
        
    }
    
}
