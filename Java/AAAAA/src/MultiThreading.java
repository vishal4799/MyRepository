
public class MultiThreading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableDemo R1 = new RunnableDemo( "Thread-1");
	      Thread t1 = new Thread (R1, "Thread-1" );
	         t1.start ();
//	         R1.start();
	      
	      RunnableDemo R2 = new RunnableDemo( "Thread-2");
	      Thread t2 = new Thread (R2, "Thread-2" );
	         t2.start ();
//	      R2.start();
	}

}
class RunnableDemo implements Runnable {
   private String threadName;
   
   RunnableDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
//   public void start () {
//      System.out.println("Starting " +  threadName );
//      if (t == null) {
//         t = new Thread (this, threadName);
//         t.start ();
//      }
//   }
}

	