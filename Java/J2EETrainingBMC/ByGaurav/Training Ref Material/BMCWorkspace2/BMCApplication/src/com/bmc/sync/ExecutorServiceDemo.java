package com.bmc.sync;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author user
 */

class Worker implements Runnable{
    int count;
    public Worker(int count){
    this.count=count;
    }
    
    public double sum(){
        double sum=0;
        for(int i=1;i<=count;i++){
           sum+=i;
        }
        return sum;
    
    }
            

    @Override
    public void run() {
        double sum=sum();
        System.out.println("Sum of count"+count+" "+sum);
    }


}


class Worker2 implements Callable{
  int count;
    public Worker2(int count){
        this.count=count;
    
    }
    public double product(){
        double product=1;
        for(int i=1;i<=count;i++){
            product*=i;
        }
        return product;
    }
    
    
    
    @Override
    public Object call() throws Exception {
        return product();
    }
    
    
    
    
}

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        final int nThreads=10;
        ExecutorService service=Executors.newFixedThreadPool(nThreads);
        
        for(int i=1;i<=nThreads;i++){
            service.execute(new Worker(i*2));
            
        }
        Set<Future<Double>> set=new HashSet<>();
        for(int i=1;i<=nThreads;i++){
            Future<Double> future=service.submit(new Worker2(i*3));
            set.add(future);
        }
        
        for(Future f:set){
            try {
                System.out.println(f.get());
            } catch (InterruptedException ex) {
            } catch (ExecutionException ex) {
            }
        }
        service.awaitTermination(10, TimeUnit.MINUTES);
        
        service.shutdown();
        
    }
    
    
}
