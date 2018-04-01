package com.bmc.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ShoppingCart {
	
    private final ReentrantReadWriteLock rwl = 
            new ReentrantReadWriteLock();   
	
	List<Product> cart=new ArrayList<Product>();
	
	public void addItem(Product item){
		rwl.writeLock().lock();

		cart.add(item);

		rwl.writeLock().unlock();

	}
	public Product showDetail(){
		
		Product item = null;
        rwl.readLock().lock();

        for(Product p:cart){
        	item=p;
        }

        rwl.readLock().unlock();
        return item;
	}
	
	public double getTotal() {

		double total=0.0;
		for(Product product:cart){
			
			total+=product.getProductPrice();
			
		}
		return total;
		
		
    }

	
	
	

}
